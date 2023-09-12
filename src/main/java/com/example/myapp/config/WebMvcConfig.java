package com.example.myapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
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

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
    	// WEB-INF/views配下のjspとマッピング
        registry.jsp("/WEB-INF/views/", ".jsp");
    }
    
	/**
	 * Beanバリデーションメッセージ等を制御する。
	 * MessageSourceはメッセージの格納先を抽象化する。
	 * 
	 * @return
	 */
	@Bean
	public MessageSource messageSource() {
	    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	    messageSource.setBasenames("application-message", "message");
	    return messageSource;
	}

}
