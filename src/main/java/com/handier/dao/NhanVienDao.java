package com.handier.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.handier.entity.NhanVien;
import com.handier.imp.NhanVienImp;

@Repository
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class NhanVienDao implements NhanVienImp{

	@Autowired SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public NhanVien findByUserName(String tendangnhap) throws UsernameNotFoundException {
	
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<NhanVien> query = session.createQuery("from nhanvien where tendangnhap = :tendangnhap");
		query.setParameter("tendangnhap", tendangnhap);
		NhanVien n = query.getSingleResult();
		System.out.println("boolean "+n.isEnabled());
		return n;
	}

	@Override
	public Boolean createUser(NhanVien nv) {
		Session session = sessionFactory.getCurrentSession();
		Boolean status = true;
		try {
			session.save(nv);
			session.flush();
			session.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			status = false;
		}
		
		return status;
	}
	

}
