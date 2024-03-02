package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Transactional
@CrossOrigin("*")
@Slf4j
@Tag(name = "02.testList2")
public class TestController {
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    @Operation(summary="테스트 리스트1", description = "테스트인데 리스트 목록을 받아온다.", tags={"02.testList2",})
    public ResponseEntity<List<Member>> getMember(){
        List<Member> member = memberRepository.findByUsername("member1");

        if(member.isEmpty())
                log.error("log Error level test");


        return new ResponseEntity<>(member, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping ("/save")
    @Operation(summary="테스트 세이브2", description = "테스트인데 리스트 목록을 저장한다.", tags={"02.testList2",})
    public ResponseEntity<?> addMember(){
        Member member = new Member();
        member.setUsername("member1");
        Integer count = memberRepository.save(member);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
