package com.handier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handier.dao.DanhMucSanPhamDao;
import com.handier.entity.DanhMucSanPham;
import com.handier.imp.DanhMucSanPhamImp;

@Service
public class DanhMucSanPhamService implements  DanhMucSanPhamImp {
	@Autowired
	DanhMucSanPhamDao danhMucSanPhamDao;
	
	public List<DanhMucSanPham> showAll() {
	
		return danhMucSanPhamDao.showAll();
	}
	
	
}
