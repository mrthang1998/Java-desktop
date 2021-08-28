package thang.dev.data.model;


import java.sql.Date;

public class ThueTro {
	private int id_kh;
	private int id_room;
	private Date ngayDen;
	private Date ngayDi;
	
	public ThueTro(int idKhach, int idRoom, Date ngayDen, Date ngayDi) {
		this.id_kh = idKhach;
		this.id_room = idRoom;
		this.ngayDen = ngayDen;
		this.ngayDi = ngayDi;
	}
	
	public ThueTro() {
		super();
	}

	public int getId_kh() {
		return id_kh;
	}

	public void setId_kh(int id_kh) {
		this.id_kh = id_kh;
	}

	public int getId_room() {
		return id_room;
	}

	public void setId_room(int id_room) {
		this.id_room = id_room;
	}

	public Date getNgayDen() {
		return ngayDen;
	}

	public void setNgayDen(Date ngayDen) {
		this.ngayDen = ngayDen;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	@Override
	public String toString() {
		return "ThueTro [id_kh=" + id_kh + ", id_room=" + id_room + ", ngayDen=" + ngayDen + ", ngayDi=" + ngayDi + "]";
	}
  
	
	

}
