package com.handier.imp;

import java.util.List;

import com.handier.entity.ChiTietSanPham;

public interface ChiTietSanPhamImp {
	List<ChiTietSanPham> getChiTietSanPham(int mamau , int masanpham);
	ChiTietSanPham getItemChiTietSanPham(int machitiet) ;
}
