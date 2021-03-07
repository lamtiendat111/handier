package com.handier.entity;

public class GioHang {
	int machitiet;
	int masanpham;
	int mamau;
	String tensp;
	String giatien;
	String tenmau;
	String tensize;
	int soluong;
	public int getMachitiet() {
		return machitiet;
	}
	public void setMachitiet(int machitiet) {
		this.machitiet = machitiet;
	}
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public int getMamau() {
		return mamau;
	}
	public void setMamau(int mamau) {
		this.mamau = mamau;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	public String getTenmau() {
		return tenmau;
	}
	public void setTenmau(String tenmau) {
		this.tenmau = tenmau;
	}
	public String getTensize() {
		return tensize;
	}
	public void setTensize(String tensize) {
		this.tensize = tensize;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public GioHang() {
		super();
	}
	public GioHang(int machitiet, int masanpham, int mamau, String tensp, String giatien, String tenmau, String tensize,
			int soluong) {
		super();
		this.machitiet = machitiet;
		this.masanpham = masanpham;
		this.mamau = mamau;
		this.tensp = tensp;
		this.giatien = giatien;
		this.tenmau = tenmau;
		this.tensize = tensize;
		this.soluong = soluong;
	}
	
	
}
