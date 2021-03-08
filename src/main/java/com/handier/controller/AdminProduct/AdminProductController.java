package com.handier.controller.AdminProduct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.handier.service.DanhMucSanPhamService;
import com.handier.service.SanPhamService;

@Controller

public class AdminProductController {
	
	@Autowired SanPhamService sps;
	
	@Autowired DanhMucSanPhamService danhmucs;
	
	
	
	//loc san pham theo the loai

	 @RequestMapping(value = "admin/product/{category}", method = RequestMethod.GET)
	   public String adminPage(Model m, @PathVariable int category) {
		 m.addAttribute("sanphams", sps.findSanPhamOfDanhMuc(category));
		 
		 m.addAttribute("danhmucs", danhmucs.showAllDanhMuc() );
	       return "body-admin-product";
	   }

	 @RequestMapping(value = "admin/product/", method = RequestMethod.GET)
	   public String defaultt(Model m) {
		 
		 m.addAttribute("sanphams", sps.printAll());
		 m.addAttribute("danhmucs", danhmucs.showAllDanhMuc() );
		
	       return "body-admin-product";
	   }
}
