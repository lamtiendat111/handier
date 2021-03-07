package com.handier.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.handier.entity.ChiTietSanPham;
import com.handier.entity.GioHang;
import com.handier.entity.NhanVien;
import com.handier.entity.SanPham;
import com.handier.service.ChiTietSanPhamService;
import com.handier.service.GioHangService;
import com.handier.service.NhanVienService;
import com.handier.service.SanPhamService;

@RestController
@RequestMapping(value = "/api")
@SessionAttributes(names = { "giohang" })
public class ApiController {

	@Autowired
	SanPhamService sanphamService;
	@Autowired
	ChiTietSanPhamService chitietsanphamservice;
	@Autowired
	GioHangService giohangservice;
	@Autowired NhanVienService nhanvienservice;

	@SuppressWarnings("unchecked")
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

	@SuppressWarnings("unchecked")
	@GetMapping("/single")
	@ResponseBody
	public JSONObject single(@RequestParam int mamau, @RequestParam int masanpham) {
		JSONObject jsonObject = new JSONObject();
		List<ChiTietSanPham> ctsps = chitietsanphamservice.getChiTietSanPham(mamau, masanpham);
		ChiTietSanPham ctsp = ctsps.get(0);
		StringBuilder html = new StringBuilder("");

		html.append("<ul class='slides'>");
		html.append("<li data-thumb='./resource/images/" + ctsp.getHinh1() + "'>");
		html.append(" <div class='thumb-image'> <img src='./resource/images/" + ctsp.getHinh1()
				+ "' data-imagezoom='true' class='img-fluid' alt=' '> </div>");
		html.append("</li>");
		html.append("<li data-thumb='./resource/images/" + ctsp.getHinh2() + "'>");
		html.append(" <div class='thumb-image'> <img src='./resource/images/" + ctsp.getHinh2()
				+ "' data-imagezoom='true' class='img-fluid' alt=' '> </div>");
		html.append("</li>");
		html.append("</ul>");

		jsonObject.put("0", html);
		html = new StringBuilder(" ");

		for (ChiTietSanPham ctsp1 : ctsps) {
			html.append(
					"<div class='row  mt-3' style='padding: 10px 0px; margin-bottom: -1px; background-color: #fff;border-top: 1px solid #ddd'>");
			html.append("<div class='col-4 mt-1'>" + ctsp1.getSizesanpham().getSize());
			html.append("</div>");

			html.append("<div class='col-4 mt-1'>" + ctsp1.getSoluong());
			html.append(" </div>");
			html.append("<div class='col-2 '>");
			html.append(" <button class='btn-info add-card' data-machitiet='" + ctsp1.getMachitietsanpham()
					+ "' data-tensp='" + ctsp1.getSanpham().getTensanpham() + "' data-giatien='"
					+ ctsp1.getSanpham().getGiatien() + "' data-tenmau='" + ctsp1.getMausanpham().getTenmau()
					+ "' data-tensize='" + ctsp1.getSizesanpham().getSize() + "' data-soluong='" + ctsp1.getSoluong()
					+ "' data-toggle='modal' data-target='#myModal'>Add</button>");
			html.append(" </div>");
			html.append("</div>");

		}
		jsonObject.put("1", html);
		html = new StringBuilder(" ");
		html.append("./resource/images/" + ctsp.getHinh1());
		jsonObject.put("2", html);
		html = new StringBuilder(" ");
		html.append("./resource/images/" + ctsp.getHinh2());
		jsonObject.put("3", html);
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("searchSanPham")
	@ResponseBody
	public JSONObject searchSanPham(@RequestParam String name) {
		JSONObject jsonObject = new JSONObject();
		SanPham sp = sanphamService.findSanPhamOfName(name);
		StringBuilder html = new StringBuilder(" ");
		if (sp != null) {
			html.append("<input type='hidden' name='masanpham' value='" + sp.getMasanpham() + "'>");
		}

		jsonObject.put("id", html);
		return jsonObject;

	}

	@SuppressWarnings("unchecked")
	@PostMapping("Giohang")
	@ResponseBody
	public JSONObject addGioHang(@ModelAttribute GioHang gioHang, Model m) {

		JSONObject jsonObject = new JSONObject();
		HashMap<Integer, GioHang> giohangs = (HashMap<Integer, GioHang>) m.getAttribute("giohang");
		;
		System.out.println(giohangs);
		try {
			if (gioHang.getSoluong() > 0) {
				giohangs = giohangservice.create(gioHang, giohangs);
				System.out.println(giohangs);
			} else {
				System.out.println("sl: " + gioHang.getSoluong());
				System.out.println("het hang");
				giohangs = (HashMap<Integer, GioHang>) m.getAttribute("giohang");
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		m.addAttribute("giohang", giohangs);
		jsonObject.put("1", giohangs.size());
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("EditGiohang")
	public JSONObject editGioHang(@ModelAttribute GioHang gioHang, Model m) {

		JSONObject jsonObject = new JSONObject();
		HashMap<Integer, GioHang> giohangs = (HashMap<Integer, GioHang>) m.getAttribute("giohang");
		;

		try {
			giohangs = giohangservice.edit(gioHang, giohangs);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}

		m.addAttribute("giohang", giohangs);
		jsonObject.put("1", giohangs.get(gioHang.getMachitiet()).getSoluong());
		StringBuilder html = new StringBuilder(" ");
		int total = 0;
		if (giohangs.size() != 0) {
			for (Entry<Integer, GioHang> item : giohangs.entrySet()) {
				total += Integer.parseInt(item.getValue().getGiatien()) * item.getValue().getSoluong();
				html.append("<li>" + item.getValue().getTensp() + "(" + item.getValue().getTenmau() + ")<i>-</i> <span>"
						+ Integer.parseInt(item.getValue().getGiatien()) * item.getValue().getSoluong()+ "</span></li>");
			}
		}
		html.append("<li>Total <i>-</i> <span>" + total + "</span></li>");
		jsonObject.put("2", html);
		return jsonObject;
	}

	@SuppressWarnings("unchecked")
	@PostMapping("DeleteGiohang")
	public JSONObject deleteGioHang(@RequestParam int machitiet, Model m) {
		JSONObject jsonObject = new JSONObject();
		HashMap<Integer, GioHang> giohangs = (HashMap<Integer, GioHang>) m.getAttribute("giohang");
		System.out.println(giohangs);
		Boolean status = false;
		try {
			status = giohangservice.delete(machitiet, giohangs);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());

		}
		jsonObject.put("1", status);
		StringBuilder html = new StringBuilder(" ");
		int total = 0;
		if (giohangs.size() != 0) {
			for (Entry<Integer, GioHang> item : giohangs.entrySet()) {
				total += Integer.parseInt(item.getValue().getGiatien()) * item.getValue().getSoluong();
				html.append("<li>" + item.getValue().getTensp() + "(" + item.getValue().getTenmau() + ")<i>-</i> <span>"
						+ Integer.parseInt(item.getValue().getGiatien()) * item.getValue().getSoluong() + "</span></li>");
			}
		}

		html.append("<li>Total <i>-</i> <span>" + total + "</span></li>");
		jsonObject.put("2", html);
		return jsonObject;
	}
	
	@PostMapping("CreateTaiKhoan")
	public JSONObject User(@ModelAttribute NhanVien nv, Model m) {
		JSONObject jsonObject = new JSONObject();
	
		Boolean status = nhanvienservice.createUser(nv);
//		try {
//			status = giohangservice.delete(machitiet, giohangs);
//
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println(e.getMessage());
//
//		}
//		jsonObject.put("1", status);
		StringBuilder html = new StringBuilder(" ");
		if(status) {
			html.append("ok");
		}
		else {
			html.append("false");
		}
		
//		if (giohangs.size() != 0) {
//			for (Entry<Integer, GioHang> item : giohangs.entrySet()) {
//				total += Integer.parseInt(item.getValue().getGiatien()) * item.getValue().getSoluong();
//				html.append("<li>" + item.getValue().getTensp() + "(" + item.getValue().getTenmau() + ")<i>-</i> <span>"
//						+ Integer.parseInt(item.getValue().getGiatien()) * item.getValue().getSoluong() + "</span></li>");
//			}
//		}
//
//		html.append("<li>Total <i>-</i> <span>" + total + "</span></li>");
		jsonObject.put("1", html);
		return jsonObject;
		
	}
}
