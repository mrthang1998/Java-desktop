package thang.dev.data.model;

public class PhongTro {
	private int id;
	private String moTa;
	private double gia;
	private int trangThai;
	
	public PhongTro() {
		super();
	}
	
	public PhongTro(String moTa, double gia, int trangThai) {
		super();
		this.moTa = moTa;
		this.gia = gia;
		this.trangThai = trangThai;
	}
	
	public PhongTro(int id, String moTa, double gia, int trangThai) {
		super();
		this.id = id;
		this.moTa = moTa;
		this.gia = gia;
		this.trangThai = trangThai;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
}
