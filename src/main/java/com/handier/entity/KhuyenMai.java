package com.handier.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity(name="khuyenmai")
public class KhuyenMai {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int makhuyenmai;
	int giagiam;
	String tenkhuyenmai;
	Date thoigianbatdau;
	Date thoigianketthuc;
	String mota;
	String hinhkhuyenmai;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="chitietkhuyenmai",
	joinColumns={@JoinColumn(name="makhuyenmai",referencedColumnName="makhuyenmai")},
	inverseJoinColumns={@JoinColumn(name="masanpham",referencedColumnName="masanpham")})
	Set<SanPham> danhsachsanpham;

	public int getMakhuyenmai() {
		return makhuyenmai;
	}

	public void setMakhuyenmai(int makhuyenmai) {
		this.makhuyenmai = makhuyenmai;
	}

	public int getGiagiam() {
		return giagiam;
	}

	public void setGiagiam(int giagiam) {
		this.giagiam = giagiam;
	}

	public String getTenkhuyenmai() {
		return tenkhuyenmai;
	}

	public void setTenkhuyenmai(String tenkhuyenmai) {
		this.tenkhuyenmai = tenkhuyenmai;
	}

	public Date getThoigianbatdau() {
		return thoigianbatdau;
	}

	public void setThoigianbatdau(Date thoigianbatdau) {
		this.thoigianbatdau = thoigianbatdau;
	}

	public Date getThoigianketthuc() {
		return thoigianketthuc;
	}

	public void setThoigianketthuc(Date thoigianketthuc) {
		this.thoigianketthuc = thoigianketthuc;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getHinhkhuyenmai() {
		return hinhkhuyenmai;
	}

	public void setHinhkhuyenmai(String hinhkhuyenmai) {
		this.hinhkhuyenmai = hinhkhuyenmai;
	}

	public Set<SanPham> getDanhsachsanpham() {
		return danhsachsanpham;
	}

	public void setDanhsachsanpham(Set<SanPham> danhsachsanpham) {
		this.danhsachsanpham = danhsachsanpham;
	}
	
	
}
