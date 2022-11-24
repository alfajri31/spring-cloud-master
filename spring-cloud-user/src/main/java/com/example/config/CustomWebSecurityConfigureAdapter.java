package com.example.config;

import com.example.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {

    private final ILoginService iLoginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private Environment environment;

    private final PerRequestFilter perRequestFilter;

    @Autowired
    CustomWebSecurityConfigureAdapter(ILoginService iLoginService, BCryptPasswordEncoder bCryptPasswordEncoder, PerRequestFilter perRequestFilter) {
        this.iLoginService = iLoginService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.perRequestFilter = perRequestFilter;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests().antMatchers(environment.getProperty("user.check.url.path")).permitAll().
        and().addFilter(getAuthenticationFilter()).addFilterBefore(perRequestFilter,getAuthenticationFilter().getClass());
    }

    private AuthenticationFilter getAuthenticationFilter() throws Exception {
        AuthenticationFilter authenticationFilter = new AuthenticationFilter(environment,iLoginService);
        authenticationFilter.setAuthenticationManager(authenticationManager());
        return authenticationFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(iLoginService).passwordEncoder(bCryptPasswordEncoder);
    }



}
