package com.example.myapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Spring MVCの特定の設定を行う。
 * @EnableWebMvcをつけてSpring MVCの機能を有効にしている。
 * @ComponentScanをつけてプレゼンテーション層のBeanをスキャンする。
 * 
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.example.myapp.controller")
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	/**
	 * ビューリゾルバー
	 */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	// WEB-INF/views配下のjspとマッピング
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

}
