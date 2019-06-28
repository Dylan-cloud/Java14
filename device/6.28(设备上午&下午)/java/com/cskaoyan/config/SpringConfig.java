package com.cskaoyan.config;

import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;
import java.util.Properties;

/**
 * Created by little Stone
 * Date 2019/6/27 Time 10:18
 */
@Configuration
@ComponentScan(basePackages = "com.cskaoyan",
		excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = {Controller.class,EnableWebMvc.class})})
public class SpringConfig {

	@Bean
	public LocalValidatorFactoryBean localValidatorFactoryBean(ReloadableResourceBundleMessageSource messageSource){
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setProviderClass(HibernateValidator.class);
		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}

	@Bean
	public ReloadableResourceBundleMessageSource messageSource(){
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		//最核心
		messageSource.setBasenames("classpath:mymessage");
		Properties properties = new Properties();
		properties.setProperty("fileEncoding","utf-8");
		messageSource.setFileEncodings(properties);
		//最核心
		messageSource.setDefaultEncoding("utf-8");
		return messageSource;
	}

	@Bean("localeResolver")
	public CookieLocaleResolver cookieLocaleResolver(){
		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(Locale.US);
		cookieLocaleResolver.setCookieName("resource");
		return cookieLocaleResolver;
	}
}
