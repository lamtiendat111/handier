package com.handier.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.handier.entity.DanhMucSanPham;
import com.handier.entity.SanPham;
import com.handier.service.DanhMucSanPhamService;
import com.handier.service.SanPhamService;
import com.mysql.cj.x.protobuf.MysqlxCrud.Limit;

@Controller
@RequestMapping("/shop")
public class ShopController {
private int limit = 6;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;
	@GetMapping
	public String defaultt(Model m) {
		int page =1;
		List<SanPham> lists = sanPhamService.phanTrang(limit, page,0,"all");
		m.addAttribute("sanphams", lists);
		m.addAttribute("tongsotrang", Math.ceil(   sanPhamService.printAll().size() / Double.parseDouble(String.valueOf(limit)) )     );
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAll();
		m.addAttribute("danhmucsanphams", danhMucSanPhams);
		return "shop";
	}

	@GetMapping("/phantrang")
	@ResponseBody
	public JSONObject phanTrang(@RequestParam int page , @RequestParam int sapxep , @RequestParam String category) throws UnsupportedEncodingException {
		String html = "";
		List<SanPham> lists = sanPhamService.phanTrang(limit, page,sapxep,category);
		
			for (Object sanPham : lists) {
				System.out.println(1);
				sanPham.toString();
				if(sanPham instanceof SanPham) {
					System.out.println(2);
					html += "<div class='col-lg-4 col-md-6 col-sm-6 product-men women_two'>";
					html += " <div class='product-toys-info'>";
					html += "  <div class='men-pro-item'>";
					html += "  <div class='men-thumb-item'>";
					html += " <img src='./resource/images/" +  ((SanPham) sanPham).getHinhsanpham() + "' class='img-thumbnail' alt=''>";

					html += "  <div class='men-cart-pro'>";
					html += "  <div class='inner-men-cart-pro'>";
					html += "    <a href='single.html' class='link-product-add-cart'>QuickView</a>";
					html += " </div>";
					html += "   </div>";
					html += "   <span class='product-new-top'>New</span>";
					html += "    </div>";
					html += "  <div class='item-info-product'>";
					html += "   <div class='info-product-price'>";
					html += "   <div class='grid_meta'>";
					html += "    <div class='product_price'>";
					html += "  <h4><a href='single.html'>" +  ((SanPham) sanPham).getTensanpham() + "</a></h4>";

					html += "  <div class='grid-price mt-2'>";
					html += "   <span class='money '>" +  ((SanPham) sanPham).getGiatien() + " VND </span>";
					html += "   </div>";
					html += " </div>";
					html += "  <ul class='stars'>  <li><a href='#'> <i class='fas fa-star'></i> </a></li>";
					html += "  <li><a href='#'> <i class='fas fa-star'></i>             </a></li>";
					html += " <li><a href='#'> <i class='fas fa-star'></i>		                            </a></li>";
					html += "   <li><a href='#'> <i class='fas fa-star'></i>	                            </a></li>";
					html += " <li><a href='#'> <i class='far fa-star-half-o'></i>		                            </a></li>";
					html += "</ul> </div>";
					html += " <div class='toys single-item hvr-outline-out'>";
					html += "  <form action='#' method='post'>";
					html += "  <input type='hidden' name='cmd' value='_cart'> ";
					html += "<input type='hidden' name='add' value='1'> <input type='hidden' name='toys_item' value='"
							+ ((SanPham) sanPham).getTensanpham() + "'> ";
					html += "<input type='hidden' name='amount' value='" +  ((SanPham) sanPham).getGiatien() + "'>";
					html += " <button type='submit' class='toys-cart ptoys-cart'>";
					html += "      <i class='fas fa-cart-plus'></i>  </button>   </form>         </div>   </div>";
					html += " <div class='clearfix'></div>";
					html += "    </div>		        </div>		    </div>		</div>";
				}
			}
		
		
		JSONObject array =new JSONObject();
		array.put("content", html);
		return array;
	}
}
