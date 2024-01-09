package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Transactional
@CrossOrigin("*")
public class TestController {
    private final MemberRepository memberRepository;

    @GetMapping("/list")
    public ResponseEntity<List<Member>> getMember(){
        List<Member> member = memberRepository.findByUsername("member1");
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
