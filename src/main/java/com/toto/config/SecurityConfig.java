/** 출처 : https://tmdrl5779.tistory.com/72 */
package com.toto.config;

import com.toto.config.auth.PrincipalDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity // Security Filter 등록
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public final PrincipalDetailService principalDetailService;
    /*
    private PrincipalDetailService principalDetailService;

    @Autowired
    public SecurityConfig(PrincipalDetailService principalDetailService) {
        this.principalDetailService = principalDetailService;
    }
*/
    @Bean
    public BCryptPasswordEncoder encodePWD() { //비밀번호 암호화를 위해 사용 시큐리티는 비밀번호가 암호화 되있어야 사용가능하다
        return new BCryptPasswordEncoder();
    }

    // 시큐리티가 대신 로그인해주는데 password를 가로채는데
    // 해당 password가 뭘로 해쉬화해서 회원가입이 되었는지 알아야
    // 같은 해쉬로 암호화해서 DB에 있는 해쉬랑 비교가능
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(principalDetailService).passwordEncoder(encodePWD());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()//csrf토큰 비활성화(테스트시 걸어두는게 좋음) 시큐리티는 csrf토큰이 있어야 접근가능함
                .authorizeRequests() //인가 요청이 오면
                .antMatchers("/","/auth/**","/js/**","/css/**","/image/**", "/toto/**") //해당 경로들은
                .permitAll() //접근을 허용한다.
                .anyRequest() //다른 모든 요청은
                .authenticated() //인증이 되야 들어갈 수 있다.
                .and() // 그리고
                .formLogin() //로그인 폼은
                .loginPage("/auth/loginForm") //로그인 페이지를 우리가 만든 페이지로 등록한다.
                .loginProcessingUrl("/auth/loginProc")//스프링 시큐리티가 해당 주소로 요청오는 로그인을 가로채서 대신 로그인해줌(서비스의 loadUserByName로 알아서)
                .defaultSuccessUrl("/"); //정상일떄

        //중복 로그인
        http.sessionManagement()
                .maximumSessions(1) //세션 최대 허용 수
                .maxSessionsPreventsLogin(false); // false이면 중복 로그인하면 이전 로그인이 풀린다.

    }


}
