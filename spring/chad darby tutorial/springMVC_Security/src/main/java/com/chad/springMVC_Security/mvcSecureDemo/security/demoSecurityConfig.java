package com.chad.springMVC_Security.mvcSecureDemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class demoSecurityConfig {

    /*

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}mary123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}susan123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

     */

    // This authenticates the user if you happen to use the default database schema
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(
                configurer ->
                        configurer.requestMatchers("/").hasRole("EMPLOYEE")
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/leaders").hasRole("MANAGER")
                                .requestMatchers("/admin").hasRole("ADMIN")
                                .anyRequest().authenticated()
        )
                // Making use of custom login page
                .formLogin(
                        form ->
                                form
                                        .loginPage("/login")
                                        .loginProcessingUrl("/process-login")
                )

                .logout(logout -> logout.permitAll())

                .exceptionHandling(configurer ->
                        configurer
                                .accessDeniedPage("/accessDenied"));

        return http.build();
    }

}
