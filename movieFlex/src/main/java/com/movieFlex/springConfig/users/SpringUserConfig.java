package com.movieFlex.springConfig.users;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan({"com.movieFlex"})
@EnableWebMvc
public class SpringUserConfig {
	
}
