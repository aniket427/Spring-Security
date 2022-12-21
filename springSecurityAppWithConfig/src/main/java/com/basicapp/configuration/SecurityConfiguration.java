package com.basicapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration{

	/*
		/showproducts - Not secure
		/showoffers - Not secure
		/makepurchase - Secure
		/userprofile - Secure
		/addnewproduct - Secure
	*/
	
	
    @Bean
    SecurityFilterChain securityconfig(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/showproducts").permitAll()
                .antMatchers("/showoffers").permitAll()
                .antMatchers("/makepurchase").authenticated()
                .antMatchers("/userprofile").authenticated()
                .antMatchers("/addnewproduct").authenticated()
                .and().formLogin().and().httpBasic();

        return http.build();

    }

}
