package com.etirovaf.backend.config;

import com.etirovaf.backend.common.security.handler.JwtAccessDeniedHandler;
import com.etirovaf.backend.common.security.handler.JwtAuthenticationEntryPoint;
import com.etirovaf.backend.common.security.jwt.JwtTokenFilter;
import com.etirovaf.backend.common.security.jwt.JwtTokenUtil;
import com.querydsl.core.annotations.Config;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(
        securedEnabled = true,
        jsr250Enabled = true
)
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;
    private final JwtTokenFilter jwtTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        //CSRF(Cross-Site Request Forgery) 보호 비활성화
        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.cors(Customizer.withDefaults());

        //HTTP 기본 인증 비활성화
        httpSecurity.formLogin(AbstractHttpConfigurer::disable);
        httpSecurity.httpBasic(AbstractHttpConfigurer::disable);

        httpSecurity.headers(headers -> headers.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        //세션 관리 상태 없음으로 구성, Spring Security가 세션 생성 or 사용 X
        httpSecurity.sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS));

        httpSecurity.exceptionHandling((exceptionHandling) -> exceptionHandling
                .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                .accessDeniedHandler(jwtAccessDeniedHandler)
        );

        //JwtTokenFilter를 UsernamePasswordAuthenticationFilter 앞에 추가
        httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        //권한 규칙 구성 시작
        httpSecurity.authorizeHttpRequests(
                authorize -> authorize
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/login").permitAll()
                        .anyRequest().authenticated()
        );
        return httpSecurity.build();
    }
}
