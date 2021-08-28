package thang.dev.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import thang.dev.data.DatabaseConnect;
import thang.dev.data.model.KhachHang;
import thang.dev.tools.DBConstant;

public class KhachHangDAO {
	private Connection conn;
	
	public KhachHangDAO() {
		try {
			conn = DatabaseConnect.getConnection();			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean save(KhachHang cus) {
		String sql = "insert into " + DBConstant.TABLE_KHACHHANG + " values(null,?,?,?)";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, cus.getTen());
			preparedStmt.setInt(2, cus.getTuoi());
			preparedStmt.setString(3, cus.getDiachi());
			return preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int update(KhachHang cus) {
		String sql = "update " + DBConstant.TABLE_KHACHHANG 
				+ String.format(" set %s=?, %s=?, %s=? where id = ?", DBConstant.KHACHHANG_TEN, DBConstant.KHACHHANG_TUOI, DBConstant.KHACHHANG_DIACHI);
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setString(1, cus.getTen());
			preparedStmt.setInt(2, cus.getTuoi());
			preparedStmt.setString(3, cus.getDiachi());
			preparedStmt.setInt(4, cus.getId());
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public boolean delete(int id) {
		String sql = "delete from " + DBConstant.TABLE_KHACHHANG + " where id = ?";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, id);
			return preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	
	public List<KhachHang> findAll(){
		List<KhachHang> rs = new ArrayList<>();
		String sql = "select * from " + DBConstant.TABLE_KHACHHANG;
		try {
			Statement stats = conn.createStatement();
			ResultSet resultSet = stats.executeQuery(sql);
			
			while(resultSet.next()) {
				KhachHang cus = new KhachHang(resultSet.getString(DBConstant.KHACHHANG_TEN), 
						resultSet.getInt(DBConstant.KHACHHANG_TUOI), 
						resultSet.getString(DBConstant.KHACHHANG_DIACHI));
				cus.setId(resultSet.getInt(DBConstant.KHACHHANG_ID));
				rs.add(cus);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	public KhachHang findById(int id) {
		String sql = "select * from " + DBConstant.TABLE_KHACHHANG + " where id = '"+id+"'";
		KhachHang cus=new KhachHang();
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
	
			ResultSet resultSet = preparedStmt.executeQuery(sql);
			
			while(resultSet.next()) {
				cus.setId(resultSet.getInt("id"));
				cus.setTen(resultSet.getString("ten"));
				cus.setTuoi(resultSet.getInt("tuoi"));
				cus.setDiachi(resultSet.getString("diachi"));
				return cus;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
