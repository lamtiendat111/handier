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

import com.handier.entity.ChiTietSanPham;
import com.handier.imp.ChiTietSanPhamImp;
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Repository
@Transactional
public class ChiTietSanPhamDao implements ChiTietSanPhamImp {

	@Autowired SessionFactory sessionFactory;
	
	@Override
	public List<ChiTietSanPham> getChiTietSanPham(int mamau, int masanpham) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<ChiTietSanPham> query = session.createQuery("select c from chitietsanpham c inner join c.mausanpham m inner join c.sanpham s where m.mamau = :mamau and s.masanpham =:masanpham");
		 query.setParameter("mamau", mamau);
		 query.setParameter("masanpham", masanpham);
		 List<ChiTietSanPham> lists = query.getResultList();
		return lists;
	}
	
	public ChiTietSanPham getItemChiTietSanPham(int machitiet) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<ChiTietSanPham> query = session.createQuery("select c from chitietsanpham c where c.machitietsanpham =:machitiet");
		 query.setParameter("machitiet", machitiet);
		ChiTietSanPham ct =  query.getSingleResult();
		return ct;
	}

}
