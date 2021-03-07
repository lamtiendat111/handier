package com.handier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handier.dao.SanPhamDao;
import com.handier.entity.SanPham;
import com.handier.imp.SanPhamImp;

@Service
public class SanPhamService implements SanPhamImp {
	
	@Autowired
	SanPhamDao sanPhamDao;

	public List<SanPham> findSanPham(String term) {
		return sanPhamDao.findSanPham(term);
	}

	public List<SanPham> printAll() {
		return sanPhamDao.printAll();
	}

	public List<SanPham> phanTrang(int soluong, int trang,int sapxep,String category,String sale) {
		
		return sanPhamDao.phanTrang(soluong, trang,sapxep,category, sale);
	}

	@Override
	public List<SanPham> findSanPhamOfDanhMuc(int maDanhMuc) {
		return sanPhamDao.findSanPhamOfDanhMuc(maDanhMuc);
	}

	@Override
	public SanPham findSanPhamOfId(int masanpham) {
		
		return sanPhamDao.findSanPhamOfId(masanpham);
	}

	@Override
	public SanPham findSanPhamOfName(String name) {
		
		return sanPhamDao.findSanPhamOfName(name);
	}
	
	

}
