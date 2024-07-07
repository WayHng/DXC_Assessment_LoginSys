/**
 * Author: Chew Wei-Hoong
 * Date: 2024 Jul 7
 */

package com.dxc.loginApp.spring;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {
        registry.addViewControllers("/anonymous.html");
        registry.addViewControllers("/login.html");
        registry.addViewControllers("/homepage.html");
        registry.addViewControllers("/manager/managerpage.html");
        registry.addViewControllers("/accessDenied.html");
    }

    @Bean
    public ViewResolver viewResolver() {
        final InternalResourceViewResolver bean = new InternalResourceViewResolver();

        bean.setViewClass(JstlView.class);
        bean.setPrefix("/WEB-INF/view");
        bean.setSuffix(".jsp");

        return bean;
    }
}