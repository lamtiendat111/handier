package com.handier.dao;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.handier.entity.GioHang;
import com.handier.imp.GioHangImp;
import com.handier.service.ChiTietSanPhamService;

@Repository
@Transactional
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GioHangDao implements GioHangImp {

	@Autowired
	ChiTietSanPhamService chitietsanpham;

	@Override
	public HashMap<Integer, GioHang> create(GioHang item, HashMap<Integer, GioHang> giohangs) {

		try {
			int soluongmax = chitietsanpham.getItemChiTietSanPham(item.getMachitiet()).getSoluong();
			if (giohangs == null) {
				giohangs = new HashMap<Integer, GioHang>();
			}
			if (!giohangs.containsKey(item.getMachitiet())) {
				item.setSoluong(1);
				giohangs.put(item.getMachitiet(), item);
			} else {
				
				item = giohangs.get(item.getMachitiet());
				if(item.getSoluong() < soluongmax) {
					item.setSoluong(item.getSoluong() + 1);
					giohangs.put(item.getMachitiet(), item);
				}
				else {
					item.setSoluong(soluongmax);
					giohangs.put(item.getMachitiet(), item);
				}
			
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return giohangs;
	}

	@Override
	public Boolean delete(int machitiet, HashMap<Integer, GioHang> giohangs) {
		Boolean status = true;
		try {
			if(giohangs.remove(machitiet) == null) {
				status = false;
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		System.out.println(status);
		return status;
	}

	@Override
	public HashMap<Integer, GioHang> edit(GioHang item, HashMap<Integer, GioHang> giohangs) {

		try {
			System.out.println("machitietsanpham cua gio hang" + item.getMachitiet());
			int soluong1 = chitietsanpham.getItemChiTietSanPham(item.getMachitiet()).getSoluong();
			System.out.println("soluong cua gio hang" + soluong1);
			if (soluong1 <= 0) {
				 delete(item.getMachitiet(), giohangs);
			} else {
				int soluongEdit = item.getSoluong();
				if (soluongEdit <= soluong1) {
					item = giohangs.get(item.getMachitiet());
					item.setSoluong(soluongEdit);
					giohangs.put(item.getMachitiet(), item);
				} else {
					item = giohangs.get(item.getMachitiet());
					item.setSoluong(soluong1);
					giohangs.put(item.getMachitiet(), item);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return giohangs;
	}

}
