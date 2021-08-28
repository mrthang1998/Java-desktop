package thang.dev.data.model;

public class KhachHang {
	private int id;
	private String ten;
	private int tuoi;
	private String diachi;
	
	
	public KhachHang() {
		super();
	}

	public KhachHang( String ten, int tuoi, String diachi) {
		super();
		
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
	}
	
	public KhachHang(int id, String ten, int tuoi, String diachi) {
		super();
		this.id = id;
		this.ten = ten;
		this.tuoi = tuoi;
		this.diachi = diachi;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	@Override
	public String toString() {
		return id+""+ten+""+tuoi+""+diachi+"";
	}
	
}
