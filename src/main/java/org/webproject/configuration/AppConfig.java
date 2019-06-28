package org.webproject.configuration;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.webproject.controller.CheckOutController;
import org.webproject.controller.ProductController;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.webproject")
public class AppConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Bean
	public ThreadPoolTaskExecutor taskExecutor() {
		ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
		pool.setCorePoolSize(1);// only one thread run
		pool.setMaxPoolSize(1);
		pool.setWaitForTasksToCompleteOnShutdown(true);
		return pool;
	}
	
//	@Bean
//    public CheckOutController accController() {
//        return Mockito.mock(CheckOutController.class);
//    }
	@Bean
	public ProductController productController() {
		return Mockito.mock(ProductController.class);
	}
//	@Bean
//	public MessageSource messageSource() {
//		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
//		messageSource.setBasename("messages");
//		return messageSource;
//	}
}