package com.etirovaf.backend.dream.presentation;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dream")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "03.드림목록")
public class DreamController {
}
