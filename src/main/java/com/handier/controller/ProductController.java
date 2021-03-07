package com.handier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.handier.entity.DanhMucSanPham;
import com.handier.entity.SanPham;
import com.handier.service.DanhMucSanPhamService;
import com.handier.service.SanPhamService;


@Controller
@RequestMapping("/product")
@SessionAttributes(names = {"url"})
public class ProductController {
	
	@Autowired DanhMucSanPhamService danhMucSanPhamService;
	@Autowired SanPhamService sanPhamService;
	@GetMapping
	public String defaultt(ModelMap m , @RequestParam int maDanhMuc) {
		m.addAttribute("url", "product?maDanhMuc="+maDanhMuc);
		m.addAttribute("title", "Product");
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAllDanhMuc();
		m.addAttribute("danhmucsanphams", danhMucSanPhams);
		m.addAttribute("danhmuc", maDanhMuc);
		List<SanPham> sanphams = sanPhamService.findSanPhamOfDanhMuc(maDanhMuc);
		m.addAttribute("sanphams", sanphams);
		return "product";
	}
}
