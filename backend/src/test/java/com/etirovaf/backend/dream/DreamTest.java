package com.etirovaf.backend.dream;

import com.etirovaf.backend.auth.application.AuthService;
import com.etirovaf.backend.auth.model.dto.request.SignupRequest;
import com.etirovaf.backend.common.exception.ServiceException;
import com.etirovaf.backend.dream.application.DreamService;
import com.etirovaf.backend.dream.model.dto.request.DreamInfoRequest;
import com.etirovaf.backend.dream.model.entity.HashtagEntity;
import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.model.entity.Role;
import jakarta.transaction.Transactional;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@Testcontainers
@Slf4j
public class DreamTest {

    @Autowired
    private DreamService dreamService;

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
    void 회원가입() {
        Member member = new Member();
        member.setUserId("wogjs0911@example.com");
        member.setNickname("재헌느");
        member.setPassword("asd1234");
        member.setName("김재헌");
        member.setRole(Role.MEMBER);

        authService.signup(SignupRequest.of(member));
        System.out.println("회원가입 성공");
    }

    @Test
    @Transactional
    void 꿈글작성테스트() throws ServiceException {
        Optional<Member> member = memberService.getMemberByUserId("wogjs0911@example.com");

        List<HashtagEntity> hashtag = new ArrayList<>();
        hashtag.add(new HashtagEntity("서강대"));
        hashtag.add(new HashtagEntity("정문"));
        hashtag.add(new HashtagEntity("법"));

        dreamService.addDream(DreamInfoRequest.builder()
                .title("서강대에서 법 관련 공부할 사람?")
                .place("서강대 정문")
                .deadline("20240405")
                .organizer("서강대학교")
                .image("imag64_720p")
                .content("dreamContent")
                .hashtag(hashtag)
                .member(member.get())
                .build());

        System.out.println("꿈 글 작성 성공");
    }
}
