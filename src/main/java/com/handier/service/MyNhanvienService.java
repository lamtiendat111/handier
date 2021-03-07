package com.handier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.handier.dao.NhanVienDao;
import com.handier.entity.CustomUserDetails;
import com.handier.entity.NhanVien;

@Service
public class MyNhanvienService implements UserDetailsService {

	@Autowired
	NhanVienDao nhanviendao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		 BCryptPasswordEncoder encoder = passwordEncoder();
		System.out.println(username);
		NhanVien nhanvien = nhanviendao.findByUserName(username);
		System.out.println("nhanvien=" + nhanvien);
		System.out.println("ten dang nhap:" + nhanvien.getTendangnhap());
		System.out.println("1 "+nhanvien.isEnabled());
		if (nhanvien.isEnabled() == false) {
			System.out.println("tai khoan da bi khóa");
			throw new UsernameNotFoundException("User " + username + " was block");
			
		}
		// ROLE_USER, ROLE_ADMIN,..
//		GrantedAuthority authority = new SimpleGrantedAuthority(nhanvien.getChucvu().getMachucvu());
//
//		UserDetails userDetails = (UserDetails) new User(nhanvien.getTendangnhap(), encoder.encode(nhanvien.getMatkhau()),true,true,true,true,
//				Arrays.asList(authority));

		return new CustomUserDetails(nhanvien) ;
	}
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
}
