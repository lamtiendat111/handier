package com.handier.imp;

import java.util.HashMap;

import com.handier.entity.GioHang;

public interface GioHangImp {
	public HashMap<Integer, GioHang> create(GioHang item, HashMap<Integer, GioHang> giohangs);
	public HashMap<Integer, GioHang> edit(GioHang item, HashMap<Integer, GioHang> giohangs);
	public Boolean delete(int machitiet, HashMap<Integer, GioHang> giohangs);
}
