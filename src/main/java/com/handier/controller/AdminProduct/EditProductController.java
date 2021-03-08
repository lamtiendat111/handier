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

public class EditProductController {
	
	@Autowired SanPhamService sps;
	
	@Autowired DanhMucSanPhamService danhmucs;

	 @RequestMapping(value = "admin/editproduct/{id}", method = RequestMethod.GET)
	   public String edit(Model m,@PathVariable int id) {
			m.addAttribute("sanpham", sps.findSanPhamOfId(id));
			
			m.addAttribute("danhmucs",  danhmucs.showAllDanhMuc() );
			return "body-admin-edit-product";
	   }
}
