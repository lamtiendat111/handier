package com.handier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handier.dao.NhanVienDao;
import com.handier.entity.NhanVien;
import com.handier.imp.NhanVienImp;

@Service
public class NhanVienService implements NhanVienImp {

	@Autowired
	NhanVienDao nhanviendao;
	@Override
	public NhanVien findByUserName(String tendangnhap) {
		return nhanviendao.findByUserName(tendangnhap);
	}

	@Override
	public Boolean createUser(NhanVien nv) {
		return nhanviendao.createUser(nv);
	}

}
