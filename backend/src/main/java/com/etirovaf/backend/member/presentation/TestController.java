package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.repository.MemberRepository;
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
public class TestController {
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Member>> getMember(){
        List<Member> member = memberRepository.findByUsername("34534");

        if(member.isEmpty())
                log.error("log Error level test");


        return new ResponseEntity<>(member, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping ("/save")
    public ResponseEntity<?> addMember(){
        Member member = new Member();
        member.setUsername("member1");
        Integer count = memberRepository.save(member);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
}
