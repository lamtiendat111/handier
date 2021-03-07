package com.handier.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity(name="chitiethoadon")
public class ChiTietHoaDon implements Serializable {
	@EmbeddedId
	ChiTietHoaDonId chiTietHoaDonId;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="manhanvien")
	NhanVien nhanvien;
	int soluong;
	String giatien;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manguoidung", referencedColumnName = "manhanvien")
	NhanVien nguoidung;
	int tinhtrang;
	Date ngaytao;
	Date ngayxacnhan;
	Date ngaygiaohang;
	
	public ChiTietHoaDonId getChiTietHoaDonId() {
		return chiTietHoaDonId;
	}
	public void setChiTietHoaDonId(ChiTietHoaDonId chiTietHoaDonId) {
		this.chiTietHoaDonId = chiTietHoaDonId;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getGiatien() {
		return giatien;
	}
	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}
	
	
}
