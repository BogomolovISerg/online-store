package com.geekbrains.spring.web.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("com.geekbrains.spring.web")
@PropertySource("secrets.properties")
public class AppConfig {
}
