package com.handier.imp;

import com.handier.entity.NhanVien;

public interface NhanVienImp {
	NhanVien findByUserName(String tendangnhap);
	Boolean createUser(NhanVien nv);
	
}
