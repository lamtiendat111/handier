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

	public List<SanPham> phanTrang(int soluong, int trang,int sapxep,String category) {
		
		return sanPhamDao.phanTrang(soluong, trang,sapxep,category);
	}
	
	

}
