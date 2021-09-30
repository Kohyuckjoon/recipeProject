package com.kh.recipe.mainPage.model.dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.mainPage.model.dto.Recipe;

public class MainPageDao {
	
	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public List<Recipe> selectRecipeByDetail(Connection conn) throws SQLException {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		String query = "select rcp_seq, att_file_no_mk, rcp_pat2, rcp_nm from recipe";
		ResultSet rset = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				Recipe recipe = new Recipe();
				recipe.setRcpSeq(rset.getInt("rcp_seq")); // 인덱스
				recipe.setAttFileNoMk(rset.getString("att_file_no_mk")); // 사진
				recipe.setRcpPat2(rset.getString("rcp_pat2")); // 종류
				recipe.setRcpNm(rset.getString("rcp_nm")); // 요리명
				Recipes.add(recipe);
			}

		}catch (Exception e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR);
		}finally {
			template.close(rset,pstm);
		}
		return Recipes;
	}

	public int insertRecipe(Connection conn) {
		
		JSONObject recipeDetail = null;
		PreparedStatement pstm = null;
		
		String value = "";
		String query = "insert into recipe(rcp_seq, rcp_nm, rcp_way2, rcp_pat2, info_eng, info_car, info_pro, info_fat, info_na, att_file_no_main, att_file_no_mk, rcp_parts_dtls, manual01, manual02, manual03, manual04, manual05, manual06, manual07, manual08, manual09, manual10, manual11, manual12, manual13, manual14, manual15, manual16, manual17, manual18, manual19, manual20) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";                                                                                      
		int res = 0;
		
		try {
			URL url = new URL("https://openapi.foodsafetykorea.go.kr/api/9ee2439be26f471d9ffd/COOKRCP01/json/1215/1318");
			BufferedReader br;
			br = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"));
			value = br.readLine();

			JSONParser parser = new JSONParser();
			
			JSONObject object = (JSONObject) parser.parse(value);
			JSONObject COOKRCP01 = (JSONObject) object.get("COOKRCP01");
			JSONArray recipeArray = (JSONArray) COOKRCP01.get("row"); 
					   
			pstm = conn.prepareStatement(query);
			
			for (int i = 0; i < recipeArray.size(); i++){
				
				Recipe recipe = new Recipe();
				
				recipeDetail = (JSONObject) recipeArray.get(i);
				
				recipe.setRcpSeq(Integer.parseInt(recipeDetail.get("RCP_SEQ").toString())); // 인덱스
				recipe.setRcpNm(recipeDetail.get("RCP_NM").toString()); // 요리명
				recipe.setRcpWay2(recipeDetail.get("RCP_WAY2").toString());
				recipe.setRcpPat2(recipeDetail.get("RCP_PAT2").toString());
				
				recipe.setInfoEng(Integer.parseInt(roundOff(recipeDetail.get("INFO_ENG").toString())));
				recipe.setInfoCar(Integer.parseInt(roundOff(recipeDetail.get("INFO_CAR").toString())));
				recipe.setInfoPro(Integer.parseInt(roundOff(recipeDetail.get("INFO_PRO").toString())));
				recipe.setInfoFat(Integer.parseInt(roundOff(recipeDetail.get("INFO_FAT").toString())));
				recipe.setInfoNa(Integer.parseInt(roundOff(recipeDetail.get("INFO_NA").toString())));
				
				recipe.setAttFileNoMain(recipeDetail.get("ATT_FILE_NO_MAIN").toString());
				recipe.setAttFileNoMk(recipeDetail.get("ATT_FILE_NO_MK").toString()); // 사진
				recipe.setRcpPartsDtls(recipeDetail.get("RCP_PARTS_DTLS").toString());
				recipe.setManual1(recipeDetail.get("MANUAL01").toString());
				recipe.setManual2(recipeDetail.get("MANUAL02").toString());
				recipe.setManual3(recipeDetail.get("MANUAL03").toString());
				recipe.setManual4(recipeDetail.get("MANUAL04").toString());
				recipe.setManual5(recipeDetail.get("MANUAL05").toString());
				recipe.setManual6(recipeDetail.get("MANUAL06").toString());
				recipe.setManual7(recipeDetail.get("MANUAL07").toString());
				recipe.setManual8(recipeDetail.get("MANUAL08").toString());
				recipe.setManual9(recipeDetail.get("MANUAL09").toString());
				recipe.setManual10(recipeDetail.get("MANUAL10").toString());
				recipe.setManual11(recipeDetail.get("MANUAL11").toString());
				recipe.setManual12(recipeDetail.get("MANUAL12").toString());
				recipe.setManual13(recipeDetail.get("MANUAL13").toString());
				recipe.setManual14(recipeDetail.get("MANUAL14").toString());
				recipe.setManual15(recipeDetail.get("MANUAL15").toString());
				recipe.setManual16(recipeDetail.get("MANUAL16").toString());
				recipe.setManual17(recipeDetail.get("MANUAL17").toString());
				recipe.setManual18(recipeDetail.get("MANUAL18").toString());
				recipe.setManual19(recipeDetail.get("MANUAL19").toString());
				recipe.setManual20(recipeDetail.get("MANUAL20").toString());

				pstm.setInt(1, recipe.getRcpSeq());
				pstm.setString(2, recipe.getRcpNm());
				pstm.setString(3, recipe.getRcpWay2());
				pstm.setString(4, recipe.getRcpPat2());
				pstm.setInt(5, recipe.getInfoEng());
				pstm.setInt(6, recipe.getInfoCar());
				pstm.setInt(7, recipe.getInfoPro());
				pstm.setInt(8, recipe.getInfoFat());
				pstm.setInt(9, recipe.getInfoNa());
				pstm.setString(10, recipe.getAttFileNoMain());
				pstm.setString(11, recipe.getAttFileNoMk());
				pstm.setString(12, recipe.getRcpPartsDtls());
				pstm.setString(13, recipe.getManual1());
				pstm.setString(14, recipe.getManual2());
				pstm.setString(15, recipe.getManual3());
				pstm.setString(16, recipe.getManual4());
				pstm.setString(17, recipe.getManual5());
				pstm.setString(18, recipe.getManual6());
				pstm.setString(19, recipe.getManual7());
				pstm.setString(20, recipe.getManual8());
				pstm.setString(21, recipe.getManual9());
				pstm.setString(22, recipe.getManual10());
				pstm.setString(23, recipe.getManual11());
				pstm.setString(24, recipe.getManual12());
				pstm.setString(25, recipe.getManual13());
				pstm.setString(26, recipe.getManual14());
				pstm.setString(27, recipe.getManual15());
				pstm.setString(28, recipe.getManual16());
				pstm.setString(29, recipe.getManual17());
				pstm.setString(30, recipe.getManual18());
				pstm.setString(31, recipe.getManual19());
				pstm.setString(32, recipe.getManual20());

				res = pstm.executeUpdate();
				
			}
			
			template.commit(conn);
		} catch (Exception e) {
			e.printStackTrace();
			throw new HandlableException(ErrorCode.API_LODING_FAIL);
		}finally {
			template.close(pstm);
		}
		return res;
	}

	public String roundOff(String primeNum) {
		
		String result = null;
		boolean hasDecimalPoint = primeNum.contains(".");
		
		if (hasDecimalPoint) {
			int idx = primeNum.indexOf(".");
			result = primeNum.substring(0, idx);
		} else {
			result = primeNum;
		} 
		
		return result;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
