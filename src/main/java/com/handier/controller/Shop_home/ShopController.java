package com.handier.controller.Shop_home;

import java.io.UnsupportedEncodingException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.handier.entity.DanhMucSanPham;
import com.handier.entity.SanPham;

import com.handier.service.DanhMucSanPhamService;
import com.handier.service.SanPhamService;

@Controller
@RequestMapping("/")
@SessionAttributes(names = {"url"})
public class ShopController {
	// phan trang so luong san pham LIMIT
	private int limit = 15;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	DanhMucSanPhamService danhMucSanPhamService;

	
	@GetMapping
	public String defaultt(Model m) {
		m.addAttribute("url", "shop");
		m.addAttribute("title", "Shop Now");
		int page = 1;
		List<SanPham> lists = sanPhamService.phanTrang(limit, page, 0, "all", "underfine");
		m.addAttribute("sanphams", lists);
	
		m.addAttribute("tongsotrang",
				Math.ceil(sanPhamService.printAll().size() / Double.parseDouble(String.valueOf(limit))));
		List<DanhMucSanPham> danhMucSanPhams = danhMucSanPhamService.showAllDanhMuc();
		m.addAttribute("danhmucsanphams", danhMucSanPhams);
		

		
		
		return "shop";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/phantrang")
	@ResponseBody
	public JSONObject phanTrang(@RequestParam int page, @RequestParam int sapxep, @RequestParam String category,
			@RequestParam String sale) throws UnsupportedEncodingException {
		StringBuilder html = new StringBuilder(" ");
		List<SanPham> lists = sanPhamService.phanTrang(limit, page, sapxep, category, sale);
		Locale lc = new Locale("nv", "VN");

		NumberFormat nf = NumberFormat.getInstance(lc);
		for (SanPham sanPham : lists) {

			html.append("<div class='col-lg-4 col-md-6 col-sm-6 product-men women_two'>");
			html.append(" <div class='product-toys-info wow zoomIn'>");
			html.append("  <div class='men-pro-item'>");
			html.append("  <div class='men-thumb-item'>");
			html.append( " <img src='./resource/images/" + sanPham.getHinhsanpham() + "' class='img-thumbnail' alt=''>");

			html.append( "  <div class='men-cart-pro'>");
			html.append( "  <div class='inner-men-cart-pro'>");
			html.append( "    <a href='single?masanpham="+sanPham.getMasanpham()+"' class='link-product-add-cart'>QuickView</a>");
			html.append( " </div>");
			html.append( "   </div>");
			html.append( "   <span class='product-new-top'>New</span>");
			html.append( "    </div>");
			html.append( "  <div class='item-info-product'>");
			html.append( "   <div class='info-product-price'>");
			html.append( "   <div class='grid_meta'>");
			html.append( "    <div class='product_price'>");
			html.append( "  <h4><a href='single?masanpham="+sanPham.getMasanpham()+"'>" + sanPham.getTensanpham() + "</a></h4>");

			html.append( "  <div class='grid-price mt-2'>");
			html.append( "   <span class='money '>");

			if (sanPham.getDanhsachkhuyenmai().size() > 0) {
				html.append( "<span style='text-decoration: line-through;'> "
						+ nf.format(Integer.parseInt(sanPham.getGiatien())) + " VND</span>");
				html.append( "</br>" + nf.format((int) (Double.parseDouble(sanPham.getGiatien()) * 0.2)) + " VND ");
			}

			else {
				html.append( nf.format(Integer.parseInt(sanPham.getGiatien())) + " VND <p> &nbsp;</p>");
			}

			html.append( "</span>   </div>");
			html.append( " </div>");
			html.append( " </div>");
			html.append( " <div class='toys single-item hvr-outline-out'>");
			html.append( "  <form action='#' method='post'>");
			html.append( "  <input type='hidden' name='cmd' value='_cart'> ");
			html.append( "<input type='hidden' name='add' value='1'> <input type='hidden' name='toys_item' value='"
					+ sanPham.getTensanpham() + "'> ");
			html.append( "<input type='hidden' name='amount' value='" + sanPham.getGiatien() + "'>");

			html.append( "     </form>         </div>   </div>");
			html.append( " <div class='clearfix'></div>");
			html.append( "    </div>		        </div>		    </div>		</div>");
		}

		JSONObject array = new JSONObject();
		array.put("content", html);
		return array;
	}
}
