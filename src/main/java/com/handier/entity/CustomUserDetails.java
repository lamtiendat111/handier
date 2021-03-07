package com.handier.entity;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomUserDetails implements UserDetails {
	private NhanVien nhanVien;
	public CustomUserDetails(NhanVien nv) {
		this.nhanVien = nv;
	}
	private String fullname;
	private String email;
	private int phone;
	private String diachi;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority authority = new SimpleGrantedAuthority(this.nhanVien.getChucvu().getMachucvu());
		return Arrays.asList(authority);
	}
	@Override
	public String getPassword() {
		System.out.println("mat khau -----"+nhanVien.getMatkhau());
		 BCryptPasswordEncoder encoder = passwordEncoder();
		return encoder.encode(this.nhanVien.getMatkhau());
	}
	@Override
	public String getUsername() {
		return this.nhanVien.getTendangnhap();
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
			return true;
	}
	@Override
	public boolean isEnabled() {
		return nhanVien.isEnabled();
	}
	public String getEmail() {
		return this.email = nhanVien.getEmail();
	}
	public String getDiachi() {
		return this.diachi =  nhanVien.getDiachi();
	}
	public int getPhone() {
		return this.phone =  nhanVien.getPhone();
	}
	public String getFullname() {
		return this.fullname =  nhanVien.getHoten();
	}
}
