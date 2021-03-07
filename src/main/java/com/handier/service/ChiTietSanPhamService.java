package com.handier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handier.dao.ChiTietSanPhamDao;
import com.handier.entity.ChiTietSanPham;
import com.handier.imp.ChiTietSanPhamImp;
@Service
public class ChiTietSanPhamService implements ChiTietSanPhamImp {

	@Autowired ChiTietSanPhamDao chitietsanphamdao;
	
	@Override
	public List<ChiTietSanPham> getChiTietSanPham(int mamau, int masanpham) {

		return 		chitietsanphamdao.getChiTietSanPham(mamau, masanpham);
	}

	@Override
	public ChiTietSanPham getItemChiTietSanPham(int machitiet) {
		
		return chitietsanphamdao.getItemChiTietSanPham(machitiet);
	}

}
