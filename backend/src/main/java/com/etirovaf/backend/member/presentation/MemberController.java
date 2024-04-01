package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.member.application.MemberService;
import com.etirovaf.backend.member.model.dto.request.MemberInfo;
import com.etirovaf.backend.member.model.entity.Role;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "02.회원")
public class MemberController {
    private final MemberService service;

    @PostMapping
    @Operation(summary="회원가입", description = "회원을 목록에 저장한다.", tags={"02.회원",})
    public boolean addMember(@RequestBody MemberInfo memberInfo){
//    public boolean addMember(){
        log.info("addMember");
        return service.addMember(memberInfo);
//        return service.addMember(MemberInfo.builder()
//                .userId("wogjs0911")
//                .nickname("회원1")
//                .password("23423asdad")
//                .role(Role.MEMBER)
//                .build());
    }
}