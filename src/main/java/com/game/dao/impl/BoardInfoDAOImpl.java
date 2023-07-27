package com.game.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.game.common.DBCon;
import com.game.dao.BoardInfoDAO;

public class BoardInfoDAOImpl implements BoardInfoDAO {

	@Override
	public List<Map<String, String>> selectBoardInfoList(Map<String, String> board) {
		String sql= "SELECT BI_NUM,BI_TITLE,BI_CONTENT,UI_NUM,CREDAT,CRETIM,LMODAT,LMOTIM, ACTIVE FROM board_info";
		List<Map<String,String>> boardList=new ArrayList<>();
		
		try(Connection con=DBCon.getCon()){
			try(PreparedStatement ps=con.prepareStatement(sql)){
				try(ResultSet rs=ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map=new HashMap<>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						boardList.add(map);
						
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return boardList;
		
	}

	@Override
	public Map<String, String> selectBoardInfo(String biNum) {
		String sql="SELECT BI_NUM,BI_TITLE,BI_CONTENT,UI_NUM,"
				+ "CREDAT,CRETIM,LMODAT,LMOTIM, ACTIVE FROM board_info WHERE BI_NUM=?";
		try(Connection con=DBCon.getCon()){
			try(PreparedStatement ps=con.prepareStatement(sql)){
				ps.setString(1, biNum);
				try(ResultSet rs=ps.executeQuery()){
					while(rs.next()) {
						Map<String,String> map= new HashMap<>();
						map.put("biNum", rs.getString("BI_NUM"));
						map.put("biTitle", rs.getString("BI_TITLE"));
						map.put("biContent", rs.getString("BI_CONTENT"));
						map.put("uiNum", rs.getString("UI_NUM"));
						map.put("credat", rs.getString("CREDAT"));
						map.put("cretim", rs.getString("CRETIM"));
						map.put("lmodat", rs.getString("LMODAT"));
						map.put("lmotim", rs.getString("LMOTIM"));
						map.put("active", rs.getString("ACTIVE"));
						return map;
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertBoardInfo(Map<String, String> board) {
		String sql="INSERT INTO BOARD_INFO(BI_TITLE,BI_CONTENT,UI_NUM,CREDAT,CRETIM,LMODAT,LMOTIM)\r\n"
				+ "VALUES(?,?,?,DATE_FORMAT(NOW(),'%Y%m%d'),"
				+ "DATE_FORMAT(NOW(),'%H%i%s'),DATE_FORMAT(NOW(),'%Y%m%d'),DATE_FORMAT(NOW(),'%H%i%s'))";
		try(Connection con=DBCon.getCon()){
			try(PreparedStatement ps=con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				return ps.executeUpdate();
			}
			}

		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateBoardInfo(Map<String, String> board) {
		String sql="UPDATE board_info SET BI_TITLE=?,\r\n"
				+ "BI_CONTENT=?,UI_NUM=?,LMODAT=DATE_FORMAT(NOW(),'%Y%m%d'),\r\n"
				+ "LMOTIM=DATE_FORMAT(NOW(),'%H%i%s') WHERE BI_NUM=?";
		try(Connection con = DBCon.getCon()){
			try(PreparedStatement ps = con.prepareStatement(sql)){
				ps.setString(1, board.get("biTitle"));
				ps.setString(2, board.get("biContent"));
				ps.setString(3, board.get("uiNum"));
				ps.setString(4, board.get("biNum"));
				return ps.executeUpdate();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteBoardInfo(String biNum) {
		String sql = "DELETE FROM BOARD_INFO WHERE BI_NUM=?";
	try(Connection con = DBCon.getCon()){
		try(PreparedStatement ps = con.prepareStatement(sql)){
			ps.setString(1,biNum);
			return ps.executeUpdate();
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
	return 0;
	}
	public static void main(String[] args) {
		BoardInfoDAO biDAO=new BoardInfoDAOImpl();
		Map<String,String> biMock=new HashMap<>();
		biMock.put("biTitle","test");
		biMock.put("biContent","test");
		biMock.put("uiNum","2");
		int result=biDAO.insertBoardInfo(biMock);
		System.out.println("결과 : "+result);
		Map<String,String> boardInfo = biDAO.selectBoardInfo("4");
		System.out.println(boardInfo);
		result = biDAO.deleteBoardInfo("8");
		System.out.println(result);
		boardInfo.put("biTitle", "updateTest");
		result = biDAO.updateBoardInfo(boardInfo);
		System.out.println(result);
	}

}
