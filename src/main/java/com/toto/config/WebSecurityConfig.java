package com.toto.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

public class WebSecurityConfig {
    private final ObjectMapper objectMapper;

   public WebSecurityConfig(ObjectMapper objectMapper) {
       this.objectMapper = objectMapper;
   }

    @Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().mvcMatchers(
                "/v3/api-docs/**",
                "/swagger-ui/**",
                "/api/v1/login" // 임시
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.antMatcher("/**")
                .authorizeRequests() // 요청에 대한 권한 지정. Security 처리에 HttpServletRequest를 이용한다는 것을 의미한다.
                .antMatchers("/api/v1/**") // 특정 경로를 지정합니다. 보통 뒤에 다른 메서드가 붙습니다.
                // .antMatchers("/api/v1/**").authenticated() "/api/v1/**" URL에 대해서 로그인을 요청한다.
                .hasAuthority("DODORIAN") //  : 특정 권한을 가지고 있는 사람만 접근할 수 있습니다. hasRole과 비슷하다고 볼 수 있습니다.
                .and()
                .httpBasic().disable() // Basic Authentication을 정의할 때 사용한다.
                .formLogin().disable() //  form 기반의 로그인을 할 수 있습니다.
                .cors().disable() // REST API를 개발할 때 백엔드와 프론트엔드를 연결하기 위하여 사용한다.
                .csrf().disable() // SRF 보안에 대한 설정입니다. 아무 설정도 하지 않으면 CSRF 보안을 하도록 설정됩니다.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                // .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }
/**
    @Bean
    public DataSource dataSource() {
        return new EmbeddedDatabaseBuilder()
                .setType(EmbeddedDatabaseType.H2)
                .addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
                .build();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        UserDetails userDetails = User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(userDetails);
        return jdbcUserDetailsManager;




    }
*/


}
