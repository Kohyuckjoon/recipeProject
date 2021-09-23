package com.kh.recipe.common.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.pool.OracleDataSource;
import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class JDBCTemplate {
   
   //SingleTon pattern
   //클래스의 인스턴스가 하나만 생성되도록 처리하는 디자인패턴
   private static JDBCTemplate instance;
   PoolDataSource pds;
   
   //1. 오라클 드라이버 jvm에 등록
   private JDBCTemplate() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@db202109141233_high?TNS_ADMIN=C:/CODE/Wallet_DB202109141233";
         String user = "ADMIN";
         String password = "2whTpalvmf__";
                  
         final String CONN_FACTORY_CLASS_NAME="oracle.jdbc.pool.OracleDataSource";
         
         // Get the PoolDataSource for UCP
         pds = PoolDataSourceFactory.getPoolDataSource();

         // Set the connection factory first before all other properties
         pds.setConnectionFactoryClassName(CONN_FACTORY_CLASS_NAME);
         pds.setURL(url);
         pds.setUser(user);
         pds.setPassword(password);
         pds.setConnectionPoolName("JDBC_UCP_POOL");

         // Default is 0. Set the initial number of connections to be created
         // when UCP is started.
         pds.setInitialPoolSize(5);

         // Default is 0. Set the minimum number of connections
         // that is maintained by UCP at runtime.
         pds.setMinPoolSize(5);

         // Default is Integer.MAX_VALUE (2147483647). Set the maximum number of
         // connections allowed on the connection pool.
         pds.setMaxPoolSize(20);

         // Default is 30secs. Set the frequency in seconds to enforce the timeout
         // properties. Applies to inactiveConnectionTimeout(int secs),
         // AbandonedConnectionTimeout(secs)& TimeToLiveConnectionTimeout(int secs).
         // Range of valid values is 0 to Integer.MAX_VALUE. .
         pds.setTimeoutCheckInterval(5);

         // Default is 0. Set the maximum time, in seconds, that a
         // connection remains available in the connection pool.
         pds.setInactiveConnectionTimeout(10);

         
      } catch (ClassNotFoundException | SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public static JDBCTemplate getInstance() {
      if(instance == null) {
         instance = new JDBCTemplate();
      }
      
      return instance;
   }
   
   //2. 데이터베이스와 연결 수립
   public Connection getConnection() {
      Connection conn = null;
      
      try {
    	conn = pds.getConnection();
	    
        //트랜잭션관리를 개발자가 하기 위해 Auto Commit 끄기
        conn.setAutoCommit(false);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      return conn;
   }
   
   //3. commit/rollback
   public void commit(Connection conn) {
      try {
         conn.commit();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public void rollback(Connection conn) {
      try {
         conn.rollback();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   //4. close()
   public void close(Connection conn) {
      try {
         if(conn != null && !conn.isClosed()) {
            conn.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public void close(Statement stmt) {
      try {
         if(stmt != null && !stmt.isClosed()) {
            stmt.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public void close(ResultSet rset) {
      try {
         if(rset != null && !rset.isClosed()) {
            rset.close();
         }
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   public void close(Statement stmt, Connection conn) {
      close(stmt);
      close(conn);
   }
   
   public void close(ResultSet rset, Statement stmt) {
      close(rset);
      close(stmt);
   }
   
   public void close(ResultSet rset, Statement stmt, Connection conn) {
      close(rset);
      close(stmt);
      close(conn);
   }
   
   
   
   
   
   
   
}