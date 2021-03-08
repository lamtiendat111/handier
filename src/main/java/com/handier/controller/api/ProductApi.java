package com.handier.controller.api;

import java.util.List;

import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.handier.entity.SanPham;
import com.handier.service.SanPhamService;

@RestController
@RequestMapping(value = "/api")
public class ProductApi {
	@Autowired
	SanPhamService sanphamService;
	
	@SuppressWarnings("unchecked")
	@GetMapping("search")
	@ResponseBody
	public Boolean checkNameProduct(@RequestParam String name) {

		try {
			SanPham sp =  sanphamService.findSanPhamOfName(name);
			if(sp != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return false;
	}
}
