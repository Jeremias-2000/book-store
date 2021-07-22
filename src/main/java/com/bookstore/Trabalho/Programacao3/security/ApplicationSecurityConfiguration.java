package com.bookstore.Trabalho.Programacao3.security;


import com.bookstore.Trabalho.Programacao3.jwt.AuthJWT;
import com.bookstore.Trabalho.Programacao3.jwt.JwtValidationFilter;
import com.bookstore.Trabalho.Programacao3.security.auth.ApplicationUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@EnableWebSecurity
@Configuration
@AllArgsConstructor(onConstructor = @__(@Autowired))

public class ApplicationSecurityConfiguration  extends WebSecurityConfigurerAdapter {


    private ApplicationUserService applicationUserService;
    private PasswordEncoder passwordEncoder;
    private AuthJWT authJWT;


    @Bean
    public JwtValidationFilter validationFilter(){
        return new JwtValidationFilter();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }




    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationUserService).passwordEncoder(passwordEncoder);
    }

    @Override //por enquanto
    protected void configure(HttpSecurity http) throws Exception {
     http
            .csrf().disable()
                .exceptionHandling().authenticationEntryPoint(authJWT).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .anyRequest().authenticated();

        http.addFilterBefore(validationFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Override // para poder mostrar o swagger ou documentação qualquer
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }


}
