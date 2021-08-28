package thang.dev.tools;

public class DBConstant {
	//For Mysql connect
	public static String HOSTNAME = "localhost";
	public static String DB_NAME = "quanlyphongtro";
	public static String DB_USER = "root";
	public static String DB_PASS = "";
	
	//Tables
	public static String TABLE_KHACHHANG = "khachhang";
	public static String KHACHHANG_ID = "id";
	public static String KHACHHANG_TEN = "ten";
	public static String KHACHHANG_TUOI = "tuoi";
	public static String KHACHHANG_DIACHI = "diachi";
	
	public static String TABLE_PHONGTRO = "phongtro";
	public static String PHONGTRO_ID = "id";
	public static String PHONGTRO_GIA = "gia";
	public static String PHONGTRO_MOTA = "mota";
	public static String PHONGTRO_TRANGTHAI = "trangthai";
	
	public static String TABLE_THUETRO= "thuetro";
	public static String THUETRO_ID_KH = "id_khachhang";
	public static String THUETRO_ID_PT = "id_phongtro";
	public static String THUETRO_NGAYDEN = "ngayden";
	public static String THUETRO_NGAYDI = "ngaydi";
}
