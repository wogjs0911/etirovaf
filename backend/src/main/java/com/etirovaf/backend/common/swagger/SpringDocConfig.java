package com.etirovaf.backend.common.swagger;

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
                @Tag(name="01.testList1", description = "테스트 1 : 리스트"),
                @Tag(name="02.testList2", description = "테스트 2 : 세이브"),
                @Tag(name="03.testList3", description = "테스트 3 : 파이널"),

        }
)
@Configuration
public class SpringDocConfig {
}
