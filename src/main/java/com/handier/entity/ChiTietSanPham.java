package com.handier.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="chitietsanpham")
public class ChiTietSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int machitietsanpham;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="masanpham")
	SanPham sanpham;
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="masize")
	SizeSanPham sizesanpham; 
	
	@OneToOne(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="mamau")
	MauSanPham mausanpham;
	
	int soluong;
	Date ngaynhap;
	String hinh1;
	String hinh2;
	public String getHinh1() {
		return hinh1;
	}
	public void setHinh1(String hinh1) {
		this.hinh1 = hinh1;
	}
	public String getHinh2() {
		return hinh2;
	}
	public void setHinh2(String hinh2) {
		this.hinh2 = hinh2;
	}
	public int getMachitietsanpham() {
		return machitietsanpham;
	}
	public void setMachitietsanpham(int machitietsanpham) {
		this.machitietsanpham = machitietsanpham;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public SizeSanPham getSizesanpham() {
		return sizesanpham;
	}
	public void setSizesanpham(SizeSanPham sizesanpham) {
		this.sizesanpham = sizesanpham;
	}
	public MauSanPham getMausanpham() {
		return mausanpham;
	}
	public void setMausanpham(MauSanPham mausanpham) {
		this.mausanpham = mausanpham;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public Date getNgaynhap() {
		return ngaynhap;
	}
	public void setNgaynhap(Date ngaynhap) {
		this.ngaynhap = ngaynhap;
	}
}
