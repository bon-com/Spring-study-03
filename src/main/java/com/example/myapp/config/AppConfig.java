package com.example.myapp.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Bean定義を行う
 */
@Configuration
public class AppConfig {
    
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