package ru.shaldnikita.auth.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.shaldnikita.auth.service.security.SecurityUserDetailsService;

/**
 * @author n.shaldenkov on 18.08.2018
 */
@Configuration
@Order(1)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .formLogin().loginPage("/login")
        .and()
                .authorizeRequests().antMatchers("/login", "/logout", "/users/me").permitAll()
        .and()
                .authorizeRequests().anyRequest().authenticated()
        .and()
                .requestMatchers().antMatchers("/login", "/logout", "/oauth/authorize", "/users/me")
        .and()
                .csrf().disable();
        //@formatter:on
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    protected static class LoginPageConfiguration implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/login").setViewName("login");
        }

    }
}
