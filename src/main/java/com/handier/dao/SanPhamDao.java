package com.handier.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.handier.entity.ChiTietSanPham;
import com.handier.entity.SanPham;
import com.handier.imp.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SanPhamDao implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<SanPham> findSanPham(String term) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from sanpham where tensanpham like:term ");
		List<SanPham> lists = query.setParameter("term", "%" +term + "%").getResultList();
		return lists;
	}
	@Transactional
	public List<SanPham> printAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from sanpham").getResultList();
	}
	@Transactional
	public List<SanPham> phanTrang(int soluong, int trang,int sapxep,String category) {
		Session session = sessionFactory.getCurrentSession();
		int rows  =  printAll().size();
		int totalPage =  (int) Math.ceil(rows / ((double) soluong) );
		
		if(trang < 1) {
			trang = 1;
		}
		if(trang > totalPage) {
			trang = totalPage;
		}
		int start = (trang - 1)* soluong;
		String queryString = " from sanpham s " ;
		String sqlcategory ="";
		if(!category.equals("all")) {
			sqlcategory ="where madanhmuc =:category";
		}
	
			if(sapxep == 0) {
				 queryString = " from sanpham "+ sqlcategory;
			}
			else if(sapxep == 1) {
				 queryString = " from sanpham "+ sqlcategory+" ORDER BY giatien asc";
			}
			else if(sapxep == 2) {
				 queryString = " from sanpham "+ sqlcategory+" ORDER BY giatien desc";
				
			}
			else if(sapxep == 3) {
				 queryString = " from sanpham "+ sqlcategory+" ORDER BY tensanpham asc";
			}
			else if(sapxep == 4) {
				 queryString = " from sanpham "+ sqlcategory+" ORDER BY tensanpham desc";
			}
			else if(sapxep == 5) {
				 queryString = " from sanpham "+ sqlcategory+" order by ngaydang asc";
		
			}
			else if(sapxep == 6) {
				 queryString = " from sanpham "+ sqlcategory+" order by ngaydang desc";
			}
			
			List<SanPham> lists = null;
			if(!category.equals("all")) {
			Query query = session.createQuery(queryString);
			 lists = query.setParameter("category", category).setFirstResult(start).setMaxResults(soluong).getResultList();
			}
			else {
			 lists = session.createQuery(queryString).setFirstResult(start).setMaxResults(soluong).getResultList();
			}
		
		
		
		return lists;
	}
	
}
