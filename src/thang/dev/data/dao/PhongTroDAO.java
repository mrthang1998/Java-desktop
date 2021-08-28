package thang.dev.data.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import thang.dev.data.DatabaseConnect;
import thang.dev.data.model.PhongTro;
import thang.dev.tools.DBConstant;

public class PhongTroDAO {
	private Connection conn;
	
	public PhongTroDAO() {
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
	
	public boolean save(PhongTro room) {
		String sql = "insert into " + DBConstant.TABLE_PHONGTRO + " values(null,?,?,?)";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setDouble(1, room.getGia());
			preparedStmt.setInt(2, room.getTrangThai());
			preparedStmt.setString(3, room.getMoTa());
			return preparedStmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public int update(PhongTro room) {
		String sql = "update " + DBConstant.TABLE_PHONGTRO 
				+ String.format(" set %s=?, %s=?, %s=? where id = ?", DBConstant.PHONGTRO_GIA, DBConstant.PHONGTRO_TRANGTHAI, DBConstant.PHONGTRO_MOTA, DBConstant.PHONGTRO_ID);
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setDouble(1, room.getGia());
			preparedStmt.setInt(2, room.getTrangThai());
			preparedStmt.setString(3, room.getMoTa());
			preparedStmt.setInt(4, room.getId());
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public boolean delete(int id) {
		String sql = "delete from " + DBConstant.TABLE_PHONGTRO + " where id = ?";
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
	
	public List<PhongTro> findAll(){
		List<PhongTro> rs = new ArrayList<>();
		String sql = "select * from " + DBConstant.TABLE_PHONGTRO;
		try {
			Statement stats = conn.createStatement();
			ResultSet resultSet = stats.executeQuery(sql);
			
			while(resultSet.next()) {
				PhongTro room = new PhongTro(resultSet.getString(DBConstant.PHONGTRO_MOTA),
						resultSet.getDouble(DBConstant.PHONGTRO_GIA), 
						resultSet.getInt(DBConstant.PHONGTRO_TRANGTHAI));
				room.setId(resultSet.getInt(DBConstant.PHONGTRO_ID));
				rs.add(room);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}
	
	public PhongTro findById(int id) {
		String sql = "select * from " + DBConstant.TABLE_PHONGTRO + " where id = '"+id+"'";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStmt.executeQuery(sql);
			
			while(resultSet.next()) {
//				PhongTro room = new PhongTro(resultSet.getString(DBConstant.PHONGTRO_MOTA),
//						resultSet.getDouble(DBConstant.PHONGTRO_GIA), 
//						resultSet.getInt(DBConstant.PHONGTRO_TRANGTHAI));
//				room.setId(resultSet.getInt(DBConstant.PHONGTRO_ID));
				PhongTro phongTro=new PhongTro();
				phongTro.setId(resultSet.getInt("id"));
				phongTro.setGia(resultSet.getDouble("gia"));
				phongTro.setTrangThai(resultSet.getInt("trangthai"));
				phongTro.setMoTa(resultSet.getString("mota"));
				return phongTro;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
