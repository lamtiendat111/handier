package com.handier.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.handier.entity.SanPham;
import com.handier.imp.SanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional
public class SanPhamDao implements SanPhamImp {
	@Autowired
	SessionFactory sessionFactory;


	public List<SanPham> findSanPham(String term) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<SanPham> query = session.createQuery("from sanpham where tensanpham like:term ");
		List<SanPham> lists = query.setParameter("term", "%" + term + "%").getResultList();
		return lists;
	}


	@SuppressWarnings("unchecked")
	public List<SanPham> printAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery(" from " + SanPham.class.getName() + " s ").list();
	}


	@SuppressWarnings("unchecked")
	public List<SanPham> phanTrang(int soluong, int trang, int sapxep, String category,String sale) {
		Session session = sessionFactory.getCurrentSession();
		int rows = printAll().size();
		int totalPage = (int) Math.ceil(rows / ((double) soluong));
		int category1 = 0;
		if (trang < 1) {
			trang = 1;
		}
		if (trang > totalPage) {
			trang = totalPage;
		}
		int start = (trang - 1) * soluong;
		String queryString = "select s from sanpham s join fetch s.danhsachkhuyenmai d  ";
		String sqlcategory = "";
		if (!category.equals("all")) {
			sqlcategory = " where s.danhmucsanpham.madanhmuc = :category ";
			
		 category1 = Integer.parseInt(category);
		 
		}
		if(sale.equals("sale") & category.equals("all") ) {
			sqlcategory = "inner join fetch s.danhmucsanpham ds right join fetch s.danhsachkhuyenmai d    where d.makhuyenmai IS NOT NULL ";

		}
		else if(sale.equals("sale") & !category.equals("all")) {
			sqlcategory = "inner join fetch s.danhmucsanpham ds right join fetch s.danhsachkhuyenmai d    where ds.madanhmuc = :category and d.makhuyenmai IS NOT NULL ";
			
		}

		if (sapxep == 0) {
			queryString = "select s  from sanpham s join fetch s.danhsachkhuyenmai d " + sqlcategory;
		} else if (sapxep == 1) {
			queryString = "select s  from sanpham s " + sqlcategory + " ORDER BY s.giatien asc";
		} else if (sapxep == 2) {
			queryString = "select s  from sanpham s " + sqlcategory + " ORDER BY s.giatien desc";
		
		} else if (sapxep == 5) {
			queryString = "select s  from sanpham s " + sqlcategory + " order by s.ngaydang asc";

		} else if (sapxep == 6) {
			queryString = "select s  from sanpham s " + sqlcategory + " order by s.ngaydang desc";
		}
		List<SanPham> lists = null;
		if (!category.equals("all")) {
			Query<SanPham> query = session.createQuery(queryString);
			lists = query.setParameter("category", category1).setFirstResult(start).setMaxResults(soluong).getResultList();
		} else {
			lists = session.createQuery(queryString).setFirstResult(start).setMaxResults(soluong).getResultList();
		}

		return lists;
	}

	@Override
	public List<SanPham> findSanPhamOfDanhMuc(int maDanhMuc) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<SanPham> query = session.createQuery("select s from " + SanPham.class.getName() + " s inner join s.danhmucsanpham ds where ds.madanhmuc = :madanhmuc");
		query.setParameter("madanhmuc", maDanhMuc);
		
		return query.getResultList() ;
	}


	@Override
	public SanPham findSanPhamOfId(int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<SanPham> query = session.createQuery("from sanpham s where s.masanpham = :masanpham");
		query.setParameter("masanpham", masanpham);
		return (SanPham) query.getSingleResult();
	}


	@Override
	public SanPham findSanPhamOfName(String name) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<SanPham> query = session.createQuery("from sanpham s where s.tensanpham = :name");
		SanPham sp = new SanPham();
		try {
			query.setParameter("name", name);
			sp = query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e);
			sp = null;
		}
		return sp ;
	}

}
