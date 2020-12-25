package com.handier.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.handier.entity.SanPham;
import com.handier.service.SanPhamService;


@Controller
@RequestMapping("/api")
public class ApiController {

	
	@Autowired
	SanPhamService sanphamService;
	
	@GetMapping("search")
	@ResponseBody
	public JSONArray Search(@RequestParam String term) {
	
		
		List<SanPham> lists = sanphamService.findSanPham(term);

		JSONArray array = new JSONArray();
		for (SanPham sp : lists) {
			array.add(sp.getTensanpham());
		}
		;
		return array;
	}
	
	

	
	
}
