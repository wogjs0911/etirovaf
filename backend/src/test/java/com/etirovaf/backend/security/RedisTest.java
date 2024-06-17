package com.etirovaf.backend.security;

import com.etirovaf.backend.auth.model.dto.request.LoginRequest;
import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.dto.request.SignupRequest;
import com.etirovaf.backend.auth.application.AuthService;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;
import lombok.extern.slf4j.Slf4j;
import org.junit.ClassRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
    private AuthService authService;

    @Autowired
    private MemberService memberService;


    public static final String MYSQL_DB = "mysqldb";
    public static final int MY_SQL_PORT = 3306;

    @ClassRule
    @Container
    public static final DockerComposeContainer<?> dockerComposeContainer =
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
        Member member = new Member();
        member.setIdentifier("wogjs0911@example.com");
        member.setNickname("재헌느");
        member.setPassword("asd1234");
        member.setName("김재헌");
        member.setRole(Role.MEMBER);

        memberService.addMember(SignupRequest.of(member));
        System.out.println("회원가입 테스트 성공");
    }

    @Test
    void test2(){
        Member member = new Member();
        member.setIdentifier("wogjs0911@example.com");
        member.setPassword("asd1234");

        authService.login(LoginRequest.of(member));
        System.out.println("로그인 테스트 성공");
    }
}
