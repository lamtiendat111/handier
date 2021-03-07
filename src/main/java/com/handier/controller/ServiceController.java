package com.handier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.handier.entity.DanhMucSanPham;
import com.handier.service.DanhMucSanPhamService;


@Controller
@SessionAttributes(names = {"url"})
@RequestMapping("/service")
public class ServiceController {
	
	@Autowired DanhMucSanPhamService danhMucSanPhamService;
	@GetMapping
	public String defaultt(ModelMap m) {
		m.addAttribute("url", "service");
		m.addAttribute("title", "Service");
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAllDanhMuc();
		m.addAttribute("danhmucsanphams", danhMucSanPhams);
		return "service";
	}
}
