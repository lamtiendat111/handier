package com.handier.imp;

import java.util.List;

import com.handier.entity.SanPham;

public interface SanPhamImp {
	public List<SanPham> findSanPham(String term);
	public List<SanPham> printAll();
	public List<SanPham> phanTrang(int soluong, int trang,int sapxep,String category);
}
