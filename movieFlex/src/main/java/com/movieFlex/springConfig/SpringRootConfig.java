package com.movieFlex.springConfig;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration//Tells that this class has some bean definitions that need to be processed 
@ComponentScan({"com.movieFlex.sprig"})
public class SpringRootConfig {

}
