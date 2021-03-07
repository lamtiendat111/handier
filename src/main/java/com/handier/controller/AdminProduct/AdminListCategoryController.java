package com.handier.controller.AdminProduct;
//package com.handier.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.handier.entity.DanhMucSanPham;
//import com.handier.service.DanhMucSanPhamService;
//
//@Controller
//public class AdminListCategoryController {
//	@Autowired
//	DanhMucSanPhamService danhmucsanphamservice;
//	 @RequestMapping(value = "admin/product", method = RequestMethod.GET)
//	   public String adminPage(Model model) {
//		
//		 model.addAttribute("danhmucsanphams", danhmucsanphamservice.showAllDanhMuc());
//		
//	       return "body-admin-list-category-product";
//	   }
//}
