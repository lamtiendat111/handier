//package com.handier.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.SessionAttributes;
//
//import com.handier.entity.DanhMucSanPham;
//import com.handier.service.DanhMucSanPhamService;
//
//
//@Controller
//@RequestMapping("/")
//@SessionAttributes(names = {"url"})
//public class TrangChuController {
//	
//	@Autowired DanhMucSanPhamService danhMucSanPhamService;
//	@GetMapping
//	public String defaultt(ModelMap m) {
//		m.addAttribute("url", "home");
//		m.addAttribute("title", "Home");
//		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAllDanhMuc();
//		m.addAttribute("danhmucsanphams", danhMucSanPhams);
//	
//		return "trangchu";
//	}
//}
