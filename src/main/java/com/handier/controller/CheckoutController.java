package com.handier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.handier.entity.DanhMucSanPham;
import com.handier.entity.GioHang;
import com.handier.service.DanhMucSanPhamService;

@Controller
@SessionAttributes(names = { "giohang","url" })
@RequestMapping("/checkout")
public class CheckoutController {
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@GetMapping
	public String defaultt(ModelMap m) {
		int total = 0;
		m.addAttribute("url", "checkout");
		m.addAttribute("title", "Check Out");
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAllDanhMuc();
		m.addAttribute("danhmucsanphams", danhMucSanPhams);
		try {
			if (m.getAttribute("giohang") != null) {
				HashMap<Integer, GioHang> giohangs = (HashMap<Integer, GioHang>) m.getAttribute("giohang");

				for (Entry<Integer, GioHang> giohang : giohangs.entrySet()) {
				System.out.println("gia tien" +giohang.getValue().getGiatien());
					total += Integer.parseInt(giohang.getValue().getGiatien()) * giohang.getValue().getSoluong();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(total);
		m.addAttribute("total", total);
		return "checkout";
	}
}
