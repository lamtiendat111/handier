package com.handier.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class Bean {
	@org.springframework.context.annotation.Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configurer = new  TilesConfigurer();
		configurer.setDefinitions("classpath:tiles.xml");
		configurer.setCheckRefresh(true);
		return configurer;	
	}
@org.springframework.context.annotation.Bean
	public ViewResolver viewResolver() {
		TilesViewResolver resolver = new TilesViewResolver();
		return resolver;
	}
}
