package com.handier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.handier.entity.ChiTietSanPham;
import com.handier.entity.DanhMucSanPham;
import com.handier.entity.SanPham;
import com.handier.service.DanhMucSanPhamService;
import com.handier.service.SanPhamService;


@Controller
@RequestMapping("/single")
@SessionAttributes(names = {"url"})
public class SingleController {
	@Autowired SanPhamService sanphamService;
	@Autowired DanhMucSanPhamService danhMucSanPhamService;
	@GetMapping
	public String defaultt(ModelMap m,@RequestParam int masanpham) {
		m.addAttribute("url", "single?masanpham="+masanpham);
		m.addAttribute("title", "Single Product");
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAllDanhMuc();
		m.addAttribute("danhmucsanphams", danhMucSanPhams);
		SanPham sanpham = sanphamService.findSanPhamOfId(masanpham);
	
		Map<String, String> danhsachmau = new HashMap<String, String>();
		for (ChiTietSanPham ctsp : sanpham.getChitietsanpham()) {
			danhsachmau.put(String.valueOf(ctsp.getMausanpham().getMamau()), ctsp.getMausanpham().getTenmau());
		}
		m.addAttribute("masanpham", masanpham);
		m.addAttribute("sanpham", sanpham);
		m.addAttribute("danhsachmau", danhsachmau);
		
		return "single";
	}
}
