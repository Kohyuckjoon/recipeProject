package com.kh.recipe.recipePage.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.recipe.common.code.ErrorCode;
import com.kh.recipe.common.db.JDBCTemplate;
import com.kh.recipe.common.exception.HandlableException;
import com.kh.recipe.recipePage.model.dto.Recipe;

public class RecipeDao {

	private JDBCTemplate template = JDBCTemplate.getInstance();
	
	public List<Recipe> selectRecipeByDetail(Connection conn) {
		
		List<Recipe> Recipes = new ArrayList<Recipe>();
		String query = "select rcp_seq, att_file_no_mk, rcp_pat2, rcp_nm, info_eng, info_car, info_pro, "
				+ "info_fat, info_na, rcp_parts_dtls, manual01, manual02, manual03, manual04, manual05, "
				+ "manual06, manual07, manual08, manual09, manual10, manual11, manual12, manual13, "
				+ "manual14, manual15, manual16, manual17, manual18, manual19, manual20, manual_img01, "
				+ "manual_img02, manual_img03, manual_img04, manual_img05, manual_img06, manual_img07, "
				+ "manual_img08, manual_img09, manual_img10, manual_img11, manual_img12, manual_img13, "
				+ "manual_img14, manual_img15, manual_img16, manual_img17, manual_img18, manual_img19, "
				+ "manual_img20 from recipe";
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
				recipe.setInfoEng(rset.getInt("info_eng")); // 칼로리
				recipe.setInfoCar(rset.getInt("info_car")); // 탄수화물
				recipe.setInfoPro(rset.getInt("info_pro")); // 단백질
				recipe.setInfoFat(rset.getInt("info_fat")); // 지방
				recipe.setInfoNa(rset.getInt("info_na")); // 나트륨
				recipe.setRcpPartsDtls(rset.getString("rcp_parts_dtls")); // 재료
				recipe.setManual1(rset.getString("manual01"));
				recipe.setManual2(rset.getString("manual02"));
				recipe.setManual3(rset.getString("manual03"));
				recipe.setManual4(rset.getString("manual04"));
				recipe.setManual5(rset.getString("manual05"));
				recipe.setManual6(rset.getString("manual06"));
				recipe.setManual7(rset.getString("manual07"));
				recipe.setManual8(rset.getString("manual08"));
				recipe.setManual9(rset.getString("manual09"));
				recipe.setManual10(rset.getString("manual10"));
				recipe.setManual11(rset.getString("manual11"));
				recipe.setManual12(rset.getString("manual12"));
				recipe.setManual13(rset.getString("manual13"));
				recipe.setManual14(rset.getString("manual14"));
				recipe.setManual15(rset.getString("manual15"));
				recipe.setManual16(rset.getString("manual16"));
				recipe.setManual17(rset.getString("manual17"));
				recipe.setManual18(rset.getString("manual18"));
				recipe.setManual19(rset.getString("manual19"));
				recipe.setManual20(rset.getString("manual20"));
				recipe.setManualImg01(rset.getString("manual_img01"));
				recipe.setManualImg02(rset.getString("manual_img02"));
				recipe.setManualImg03(rset.getString("manual_img03"));
				recipe.setManualImg04(rset.getString("manual_img04"));
				recipe.setManualImg05(rset.getString("manual_img05"));
				recipe.setManualImg06(rset.getString("manual_img06"));
				recipe.setManualImg07(rset.getString("manual_img07"));
				recipe.setManualImg08(rset.getString("manual_img08"));
				recipe.setManualImg09(rset.getString("manual_img09"));
				recipe.setManualImg10(rset.getString("manual_img10"));
				recipe.setManualImg11(rset.getString("manual_img11"));
				recipe.setManualImg12(rset.getString("manual_img12"));
				recipe.setManualImg13(rset.getString("manual_img13"));
				recipe.setManualImg14(rset.getString("manual_img14"));
				recipe.setManualImg15(rset.getString("manual_img15"));
				recipe.setManualImg16(rset.getString("manual_img16"));
				recipe.setManualImg17(rset.getString("manual_img17"));
				recipe.setManualImg18(rset.getString("manual_img18"));
				recipe.setManualImg19(rset.getString("manual_img19"));
				recipe.setManualImg20(rset.getString("manual_img20"));

				Recipes.add(recipe);
			}

		}catch (Exception e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR);
		}finally {
			template.close(rset,pstm);
		}
		return Recipes;
	}

	public List<Recipe> selectRecipeByDetailToScrape(Connection conn, Recipe recipe) {
		List<Recipe> Recipes = new ArrayList<Recipe>();
		String query = "select rcp_seq, att_file_no_mk, rcp_pat2, rcp_nm, info_eng, info_car, info_pro, "
				+ "info_fat, info_na, rcp_parts_dtls, manual01, manual02, manual03, manual04, manual05, "
				+ "manual06, manual07, manual08, manual09, manual10, manual11, manual12, manual13, "
				+ "manual14, manual15, manual16, manual17, manual18, manual19, manual20, manual_img01, "
				+ "manual_img02, manual_img03, manual_img04, manual_img05, manual_img06, manual_img07, "
				+ "manual_img08, manual_img09, manual_img10, manual_img11, manual_img12, manual_img13, "
				+ "manual_img14, manual_img15, manual_img16, manual_img17, manual_img18, manual_img19, "
				+ "manual_img20 from recipe "
				+ "where rcp_seq = ?";
		ResultSet rset = null;
		PreparedStatement pstm = null;
		
		try {
			pstm = conn.prepareStatement(query);
			pstm.setInt(1, recipe.getRcpSeq());
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				recipe.setRcpSeq(rset.getInt("rcp_seq")); // 인덱스
				recipe.setAttFileNoMk(rset.getString("att_file_no_mk")); // 사진
				recipe.setRcpPat2(rset.getString("rcp_pat2")); // 종류
				recipe.setRcpNm(rset.getString("rcp_nm")); // 요리명
				recipe.setInfoEng(rset.getInt("info_eng")); // 칼로리
				recipe.setInfoCar(rset.getInt("info_car")); // 탄수화물
				recipe.setInfoPro(rset.getInt("info_pro")); // 단백질
				recipe.setInfoFat(rset.getInt("info_fat")); // 지방
				recipe.setInfoNa(rset.getInt("info_na")); // 나트륨
				recipe.setRcpPartsDtls(rset.getString("rcp_parts_dtls")); // 재료
				recipe.setManual1(rset.getString("manual01"));
				recipe.setManual2(rset.getString("manual02"));
				recipe.setManual3(rset.getString("manual03"));
				recipe.setManual4(rset.getString("manual04"));
				recipe.setManual5(rset.getString("manual05"));
				recipe.setManual6(rset.getString("manual06"));
				recipe.setManual7(rset.getString("manual07"));
				recipe.setManual8(rset.getString("manual08"));
				recipe.setManual9(rset.getString("manual09"));
				recipe.setManual10(rset.getString("manual10"));
				recipe.setManual11(rset.getString("manual11"));
				recipe.setManual12(rset.getString("manual12"));
				recipe.setManual13(rset.getString("manual13"));
				recipe.setManual14(rset.getString("manual14"));
				recipe.setManual15(rset.getString("manual15"));
				recipe.setManual16(rset.getString("manual16"));
				recipe.setManual17(rset.getString("manual17"));
				recipe.setManual18(rset.getString("manual18"));
				recipe.setManual19(rset.getString("manual19"));
				recipe.setManual20(rset.getString("manual20"));
				recipe.setManualImg01(rset.getString("manual_img01"));
				recipe.setManualImg02(rset.getString("manual_img02"));
				recipe.setManualImg03(rset.getString("manual_img03"));
				recipe.setManualImg04(rset.getString("manual_img04"));
				recipe.setManualImg05(rset.getString("manual_img05"));
				recipe.setManualImg06(rset.getString("manual_img06"));
				recipe.setManualImg07(rset.getString("manual_img07"));
				recipe.setManualImg08(rset.getString("manual_img08"));
				recipe.setManualImg09(rset.getString("manual_img09"));
				recipe.setManualImg10(rset.getString("manual_img10"));
				recipe.setManualImg11(rset.getString("manual_img11"));
				recipe.setManualImg12(rset.getString("manual_img12"));
				recipe.setManualImg13(rset.getString("manual_img13"));
				recipe.setManualImg14(rset.getString("manual_img14"));
				recipe.setManualImg15(rset.getString("manual_img15"));
				recipe.setManualImg16(rset.getString("manual_img16"));
				recipe.setManualImg17(rset.getString("manual_img17"));
				recipe.setManualImg18(rset.getString("manual_img18"));
				recipe.setManualImg19(rset.getString("manual_img19"));
				recipe.setManualImg20(rset.getString("manual_img20"));

				Recipes.add(recipe);
			}

		}catch (Exception e) {
			throw new HandlableException(ErrorCode.DATABASE_ACCESS_ERROR);
		}finally {
			template.close(rset,pstm);
		}
		return Recipes;
	}

}
