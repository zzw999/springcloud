package com.zzw.feign.security;

import com.zzw.feign.security.handler.LoginFailureHandler;
import com.zzw.feign.security.handler.LoginSuccessHandler;
import com.zzw.feign.security.handler.LogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author Created by zzw on 2018/5/4.
 * @desc
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    UserDetailsService customUserService() {
        return new CustomUserService();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login").successHandler(new LoginSuccessHandler()).failureHandler(new LoginFailureHandler()).permitAll().and()
                .logout().invalidateHttpSession(false).logoutUrl("/logout").logoutSuccessHandler(new LogoutSuccessHandler()).permitAll();
    }

}
