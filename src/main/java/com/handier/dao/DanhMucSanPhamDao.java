package com.handier.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.handier.entity.DanhMucSanPham;
import com.handier.imp.DanhMucSanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDao implements DanhMucSanPhamImp {
	@Autowired
	SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	@Transactional
	public List<DanhMucSanPham> showAllDanhMuc() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from danhmucsanpham").getResultList();
	}

}
