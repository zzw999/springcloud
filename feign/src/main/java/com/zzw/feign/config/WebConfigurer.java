package com.zzw.feign.config;

import com.zzw.interfaces.exception.ExecptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author Created by yuyidi on 2017/6/27.
 * @desc
 */
@Configuration
public class WebConfigurer extends WebMvcConfigurerAdapter {

//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        super.addFormatters(registry);
//        registry.addConverterFactory(new UniversalEnumConverterFactory());
//        registry.addConverter(new DateConverter());
//    }

	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(new ExecptionHandler());
		super.configureHandlerExceptionResolvers(exceptionResolvers);
	}
	
	@Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
    	configurer.setUseSuffixPatternMatch(false);
    }

}
