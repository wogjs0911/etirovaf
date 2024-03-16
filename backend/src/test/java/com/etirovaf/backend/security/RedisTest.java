package com.etirovaf.backend.security;

import com.etirovaf.backend.auth.model.dto.request.MemberRequest;
import com.etirovaf.backend.auth.presentation.AuthController;
import com.etirovaf.backend.auth.service.AuthService;
import com.etirovaf.backend.member.infrastructure.repository.MemberRepository;
import com.etirovaf.backend.member.model.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.DockerComposeContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.io.File;
import java.time.Duration;

@SpringBootTest
@Testcontainers
@Slf4j
public class RedisTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private AuthController authController;

    @Autowired
    private AuthService authService;

    @Autowired
    private PasswordEncoder encoder;

    public static final String MYSQL_DB = "mysqldb";
    public static final int MY_SQL_PORT = 3306;

    @ClassRule
    @Container
    static final DockerComposeContainer<?> dockerComposeContainer =
            new DockerComposeContainer<>(new File("src/test/java/resources/docker-compose.yml"))
                    .withExposedService(
                            MYSQL_DB,
                            MY_SQL_PORT,
                            Wait.forListeningPort().withStartupTimeout(Duration.ofSeconds(30))
                    );

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry dynamicPropertyRegistry) {

        final String host = dockerComposeContainer.getServiceHost(MYSQL_DB, MY_SQL_PORT);
        final Integer port = dockerComposeContainer.getServicePort(MYSQL_DB, MY_SQL_PORT);
        dynamicPropertyRegistry.add("spring.datasource.url",
                () -> "jdbc:mysql://%s:%d/test_container_test".formatted(host, port));
        dynamicPropertyRegistry.add("spring.datasource.username", () -> "root");
        dynamicPropertyRegistry.add("spring.datasource.password", () -> "password");
        dynamicPropertyRegistry.add("spring.jpa.hibernate.ddl-auto", () -> "create");

    }
    @BeforeEach
    void test1() {
        MemberRequest.SignUpRequest signUpRequest = new MemberRequest.SignUpRequest();
        signUpRequest.setUserId("wogjs0911@example.com");
        signUpRequest.setNickname("재헌느");
        signUpRequest.setPassword("asd1234");
        signUpRequest.setName("김재헌");
        signUpRequest.setRole(Role.MEMBER);

        authService.signup(signUpRequest);
        System.out.println("회원가입 테스트 성공");
    }

    @Test
    void test2(){
        MemberRequest.LoginRequest loginRequest = new MemberRequest.LoginRequest();
        loginRequest.setUserId("wogjs0911@example.com");
        loginRequest.setPassword("asd1234");

        authService.login(loginRequest);
        System.out.println("로그인 테스트 성공");
    }
}
