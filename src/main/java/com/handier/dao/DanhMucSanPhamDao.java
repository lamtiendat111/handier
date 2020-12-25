package com.handier.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import com.handier.entity.DanhMucSanPham;
import com.handier.imp.DanhMucSanPhamImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class DanhMucSanPhamDao implements DanhMucSanPhamImp {
	@Autowired
	SessionFactory sessionFactory;
	@Transactional
	public List<DanhMucSanPham> showAll() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from danhmucsanpham").getResultList();
	}

}
