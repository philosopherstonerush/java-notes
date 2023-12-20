package com.luv2code.springboot.cruddemo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class employeeSecurityConfig {

    // This mentions where our employees data lives.

    // Data that lives only till the server runs

    /**
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails suvarna = User.builder()
                .username("suvarna")
                .password("{noop}test123")
                .roles("MANAGER", "EMPLOYEE")
                .build();

        UserDetails swarna = User.builder()
                .username("swarna")
                .password("{noop}test123")
                .roles("ADMIN", "MANAGER", "EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(john, mary, suvarna, swarna);
    }
     */

    // default spring security user table
    /**
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        //Datasource is used to get the connection object of our JDBC vendor.

        // Spring security automatically looks for our default schema table.
        return new JdbcUserDetailsManager(dataSource);
    }
    */

    // custom table
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        //Datasource is used to get the connection object of our JDBC vendor.

        // Spring security automatically looks for our default schema table.
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id, pw, active from members where user_id = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role from roles where user_id = ?");

        return jdbcUserDetailsManager;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        // restrict api access based on roles

        // URLs like /api/employees/** match to the subdomains as well since that way we can pass id etc.
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // Use basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable csrf
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }

}
