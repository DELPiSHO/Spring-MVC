package com.example.Projekt2.Web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/login").setViewName("loginForm");
        registry.addViewController("/registration").setViewName("registrationForm");
        registry.addViewController("/account").setViewName("account");
		registry.addViewController("/adminPanel").setViewName("adminPanel");
        registry.addViewController("/messages").setViewName("messages");
    }
}
