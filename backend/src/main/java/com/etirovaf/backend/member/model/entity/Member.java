package com.etirovaf.backend.member.model.entity;

import com.etirovaf.backend.auth.model.dto.request.SignUpRequest;
import com.etirovaf.backend.common.exception.BaseResDto;
import com.etirovaf.backend.member.model.dto.request.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter @Setter @Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member extends BaseResDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String userId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 100)
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static Member of(MemberInfo info){
        return Member.builder()
                .userId(info.getUserId())
                .nickname(info.getNickname())
                .password(info.getPassword())
                .role(info.getRole())
                .build();
    }

    // 저장 시, Entity에 저장하므로 Entity 내부 구현을 숨기고자 DTO로 저장할 수 있다.
    // 조회 시, Entity를 사용하지 않아도 되어서 DTO 자체에 정적 팩토리 메서드를 만든다.
    public static Member saveMember(SignUpRequest entity){
        return Member.builder()
                .id(entity.getId())
                .userId(entity.getUserId())
                .password(entity.getPassword())
                .nickname(entity.getNickname())
                .name(entity.getName())
                .role(entity.getRole())
                .build();
    }
}
