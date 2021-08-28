package thang.dev.data.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import thang.dev.data.DatabaseConnect;
import thang.dev.data.model.KhachHang;
import thang.dev.data.model.ThueTro;
import thang.dev.tools.DBConstant;

public class ThueTroDAO {
	private Connection conn;

	public ThueTroDAO() {
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

	public boolean save(ThueTro hireRoom) {
		String sql = "insert into " + DBConstant.TABLE_THUETRO + " values(?,?,?,?)";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, hireRoom.getId_kh());
			preparedStmt.setInt(2, hireRoom.getId_room());
			Date ngayden = hireRoom.getNgayDen();
			ngayden.setYear(ngayden.getYear() - 1901);
			preparedStmt.setDate(3, ngayden);
			Date ngaydi = hireRoom.getNgayDi();
			ngaydi.setYear(ngaydi.getYear() - 1901);
			preparedStmt.setDate(4, ngaydi);
			int x = preparedStmt.executeUpdate();
			if (x > 0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public int update(ThueTro hireRoom) {
		String sql = "update " + DBConstant.TABLE_PHONGTRO
				+ String.format(" set %s=?, %s=?, %s=? where id = ?", DBConstant.THUETRO_ID_KH,
						DBConstant.THUETRO_ID_PT, DBConstant.THUETRO_NGAYDEN, DBConstant.THUETRO_NGAYDI);
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			preparedStmt.setInt(1, hireRoom.getId_kh());
			preparedStmt.setInt(2, hireRoom.getId_room());
			preparedStmt.setDate(3, hireRoom.getNgayDen());
			preparedStmt.setDate(4, hireRoom.getNgayDi());
			return preparedStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}

	public boolean delete(int id) {
		String sql = "delete from " + DBConstant.TABLE_THUETRO + " where id = ?";
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

	public List<ThueTro> findAll() {
		List<ThueTro> rs = new ArrayList<>();
		String sql = "select * from " + DBConstant.TABLE_THUETRO;
		try {
			Statement stats = conn.createStatement();
			ResultSet resultSet = stats.executeQuery(sql);

			while (resultSet.next()) {
				ThueTro thuetro = new ThueTro();
				thuetro.setId_kh(resultSet.getInt(1));
				thuetro.setId_room(resultSet.getInt(2));
				thuetro.setNgayDen(resultSet.getDate(3));
				thuetro.setNgayDi(resultSet.getDate(4));
				rs.add(thuetro);

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return rs;
	}

	public ThueTro findById(int id) {
		String sql = "select * from " + DBConstant.TABLE_THUETRO + " where id_khachhang='" + id + "' or id_phongtro='"
				+ id + "'";
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(sql);
			ResultSet resultSet = preparedStmt.executeQuery(sql);

			while (resultSet.next()) {
				ThueTro hireRoom = new ThueTro();
				hireRoom.setId_kh(resultSet.getInt("id_khachhang"));
				hireRoom.setId_room(resultSet.getInt("id_phongtro"));
				hireRoom.setNgayDen(resultSet.getDate("ngayden"));
				hireRoom.setNgayDi(resultSet.getDate("ngaydi"));

				return hireRoom;

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
