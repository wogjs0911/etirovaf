package com.etirovaf.backend.config.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Etirovaf API 명세서",
                description = "Etirovaf API 명세서 입니다.",
                version = "v1"
        ),
        tags = {
                @Tag(name="01.로그인", description = "로그인 기능"),
                @Tag(name="02.회원", description = "회원 기능"),
                @Tag(name="03.드림목록", description = "드림글 기능"),
        }
)
@Configuration
public class SpringDocConfig {
}
