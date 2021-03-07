package com.handier.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OrderBy;

@Entity(name = "sanpham")
public class SanPham {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int masanpham;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "madanhmuc")
	DanhMucSanPham danhmucsanpham;
	String tensanpham;
	@OrderBy(clause = "giatien")
	String giatien;
	String mota;

	String gianhcho;
	Date ngaydang;

	String hinhsanpham;
	
	

	public SanPham(int masanpham, DanhMucSanPham danhmucsanpham, String tensanpham, String giatien, String mota,
			String gianhcho, Date ngaydang, String hinhsanpham, Set<ChiTietSanPham> chitietsanpham,
			Set<HinhSanPham> hinhsanphams, Set<KhuyenMai> danhsachkhuyenmai) {
		super();
		this.masanpham = masanpham;
		this.danhmucsanpham = danhmucsanpham;
		this.tensanpham = tensanpham;
		this.giatien = giatien;
		this.mota = mota;
		this.gianhcho = gianhcho;
		this.ngaydang = ngaydang;
		this.hinhsanpham = hinhsanpham;
		this.chitietsanpham = chitietsanpham;
		this.hinhsanphams = hinhsanphams;
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}

	public SanPham(int masanpham, DanhMucSanPham danhmucsanpham, String tensanpham, String giatien, String mota,
			String gianhcho, Date ngaydang, String hinhsanpham) {
		super();
		this.masanpham = masanpham;
		this.danhmucsanpham = danhmucsanpham;
		this.tensanpham = tensanpham;
		this.giatien = giatien;
		this.mota = mota;
		this.gianhcho = gianhcho;
		this.ngaydang = ngaydang;
		this.hinhsanpham = hinhsanpham;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "masanpham")
	Set<ChiTietSanPham> chitietsanpham;

	public Date getNgaydang() {
		return ngaydang;
	}

	public void setNgaydang(Date ngaydang) {
		this.ngaydang = ngaydang;
	}

	

	public void setHinhsanpham(Set<HinhSanPham> hinhsanphams) {
		this.hinhsanphams = hinhsanphams;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "masanpham")				
	Set<HinhSanPham> hinhsanphams;

	public Set<HinhSanPham> getHinhsanphams() {
		return hinhsanphams;
	}

	public void setHinhsanphams(Set<HinhSanPham> hinhsanphams) {
		this.hinhsanphams = hinhsanphams;
	}

	public void setHinhsanpham(String hinhsanpham) {
		this.hinhsanpham = hinhsanpham;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "chitietkhuyenmai", joinColumns = {
			@JoinColumn(name = "masanpham", referencedColumnName = "masanpham") }, inverseJoinColumns = {
					@JoinColumn(name = "makhuyenmai", referencedColumnName = "makhuyenmai") })
	Set<KhuyenMai> danhsachkhuyenmai;



	public SanPham() {
	
	}

	public int getMasanpham() {
		return masanpham;
	}

	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}

	public DanhMucSanPham getDanhmucsanpham() {
		return danhmucsanpham;
	}

	public void setDanhmucsanpham(DanhMucSanPham danhmucsanpham) {
		this.danhmucsanpham = danhmucsanpham;
	}

	public String getTensanpham() {
		return tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public String getGiatien() {
		return giatien;
	}

	public void setGiatien(String giatien) {
		this.giatien = giatien;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getGianhcho() {
		return gianhcho;
	}

	public void setGianhcho(String gianhcho) {
		this.gianhcho = gianhcho;
	}

	public Set<ChiTietSanPham> getChitietsanpham() {
		return chitietsanpham;
	}

	public void setChitietsanpham(Set<ChiTietSanPham> chitietsanpham) {
		this.chitietsanpham = chitietsanpham;
	}

	public Set<KhuyenMai> getDanhsachkhuyenmai() {
		return danhsachkhuyenmai;
	
	}

	public String getHinhsanpham() {
		return hinhsanpham;
	}

	public void setDanhsachkhuyenmai(Set<KhuyenMai> danhsachkhuyenmai) {
		this.danhsachkhuyenmai = danhsachkhuyenmai;
	}

}
