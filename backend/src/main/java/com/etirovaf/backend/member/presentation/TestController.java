package com.etirovaf.backend.member.presentation;

import com.etirovaf.backend.member.model.entity.Member;
import com.etirovaf.backend.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class TestController {
    private final MemberRepository memberRepository;

    @GetMapping("/test")
    public List<Member> getMember(){
        return memberRepository.findAll();
    }

    @GetMapping ("/add")
    public Member addMember(Member member){
        member.setUsername("jaejae1223322");
        return memberRepository.save(member);
    }
}
