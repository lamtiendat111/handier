package com.handier.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.annotation.Transactional;

import com.handier.service.MyNhanvienService;
@Configuration
@EnableWebSecurity
@Transactional
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	@Autowired private MyNhanvienService mynhanvienservice;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 // Users in memory.
		BCryptPasswordEncoder passwordEncoder = passwordEncoder();
		auth.inMemoryAuthentication().withUser("user1").password("12345").roles("USER");
        auth.inMemoryAuthentication().withUser("admin1").password("12345").roles("ADMIN");
        // For User in database.
		auth.userDetailsService(mynhanvienservice).passwordEncoder(passwordEncoder);
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//chong tan cong
		  http.csrf().disable();
		  
		  http.authorizeRequests().antMatchers("/userInfo").access("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
		  .and().authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
		 .anyRequest().permitAll();
		  http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		  http.authorizeRequests().and().formLogin()//
		  // Submit URL of login page.
          // Submit URL
          .loginPage("/login")
          .loginProcessingUrl("/j_spring_security_check").successHandler(customSuccessHandler)
          .usernameParameter("username")
          .passwordParameter("password")
          .failureUrl("/login?error=true")//
          
          // Config for Logout Page
          .and().logout().logoutUrl("/logout").logoutSuccessUrl("/");
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resource/**");
	}
	
}
