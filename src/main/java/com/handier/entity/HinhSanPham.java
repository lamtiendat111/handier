package com.handier.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name = "hinhsanpham")
public class HinhSanPham {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="masanpham")
	private SanPham sanpham;
	private String hinh;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="mamau")
	private MauSanPham mausanpham;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SanPham getSanpham() {
		return sanpham;
	}
	public void setSanpham(SanPham sanpham) {
		this.sanpham = sanpham;
	}
	public String getHinh() {
		return hinh;
	}
	public void setHinh(String hinh) {
		this.hinh = hinh;
	}
	public MauSanPham getMausanpham() {
		return mausanpham;
	}
	public void setMausanpham(MauSanPham mausanpham) {
		this.mausanpham = mausanpham;
	}
	public HinhSanPham(int id, SanPham sanpham, String hinh, MauSanPham mausanpham) {
		super();
		this.id = id;
		this.sanpham = sanpham;
		this.hinh = hinh;
		this.mausanpham = mausanpham;
	}
	public HinhSanPham() {
		super();
	}
	
}
