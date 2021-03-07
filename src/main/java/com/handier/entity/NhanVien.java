package com.handier.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="nhanvien")
public class NhanVien {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int manhanvien;
	private String hoten;
	private String diachi;
	private int phone;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="machucvu")
	private ChucVu chucvu;
	
	private String email;
	private String tendangnhap;
	private String matkhau;
	private boolean enabled;
	private int Point;
	public int getPoint() {
		return Point;
	}
	public void setPoint(int point) {
		Point = point;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public int getManhanvien() {
		return manhanvien;
	}
	public void setManhanvien(int manhanvien) {
		this.manhanvien = manhanvien;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int cmnd) {
		this.phone = cmnd;
	}
	public ChucVu getChucvu() {
		return chucvu;
	}
	public void setChucvu(ChucVu chucvu) {
		this.chucvu = chucvu;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
	public String getMatkhau() {
		return matkhau;
	}
	public void setMatkhau(String matkhau) {
		this.matkhau = matkhau;
	}
	public NhanVien(int manhanvien, String hoten, String diachi, int phone, ChucVu chucvu, String email,
			String tendangnhap, String matkhau, boolean enabled) {
		super();
		this.manhanvien = manhanvien;
		this.hoten = hoten;
		this.diachi = diachi;
		this.phone = phone;
		this.chucvu = chucvu;
		this.email = email;
		this.tendangnhap = tendangnhap;
		this.matkhau = matkhau;
		this.enabled = enabled;
	}
	public NhanVien() {
		super();
	}
	
}
