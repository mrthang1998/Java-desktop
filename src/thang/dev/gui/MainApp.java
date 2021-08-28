package thang.dev.gui;

import java.sql.Timestamp;
import java.util.Scanner;

import thang.dev.data.dao.KhachHangDAO;
import thang.dev.data.dao.PhongTroDAO;
import thang.dev.data.dao.ThueTroDAO;
import thang.dev.data.model.KhachHang;
import thang.dev.data.model.PhongTro;
import thang.dev.data.model.ThueTro;

public class MainApp {
	public static void main(String[] args) {
		KhachHangDAO cus = new KhachHangDAO();
		KhachHang kh = new KhachHang(23,"Minh", 20, "NGuyen Hue");
		cus.update(kh);
		cus.findById(23);
		
		
	}
}
