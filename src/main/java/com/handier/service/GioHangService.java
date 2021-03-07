package com.handier.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handier.dao.GioHangDao;
import com.handier.entity.GioHang;
import com.handier.imp.GioHangImp;
@Service
public class GioHangService implements GioHangImp {
	@Autowired GioHangDao giohangdao;

	@Override
	public HashMap<Integer, GioHang> create(GioHang item, HashMap<Integer, GioHang> giohangs) {
		
		return giohangdao.create(item, giohangs);
	}

	@Override
	public HashMap<Integer, GioHang> edit(GioHang item, HashMap<Integer, GioHang> giohangs) {
		
		return giohangdao.edit(item, giohangs);
	}

	public Boolean delete(int machitiet, HashMap<Integer, GioHang> giohangs) {
		return giohangdao.delete(machitiet, giohangs);
	}

}
