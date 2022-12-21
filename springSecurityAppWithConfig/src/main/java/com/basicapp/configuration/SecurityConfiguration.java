package com.basicapp.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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


    @Bean
    InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.withDefaultPasswordEncoder().username("abc").password("abc").authorities("admin").build();
        UserDetails user2 = User.withDefaultPasswordEncoder().username("xyz").password("xyz").authorities("admin").build();

        InMemoryUserDetailsManager serviceDetailsManager = new InMemoryUserDetailsManager();
        serviceDetailsManager.createUser(user1);
        serviceDetailsManager.createUser(user2);

        return serviceDetailsManager;

    }
    
    

}
