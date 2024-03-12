package com.etirovaf.backend.member.model.entity;

import com.etirovaf.backend.common.exception.BaseResDto;
import com.etirovaf.backend.member.model.dto.request.MemberInfo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter @Setter @Builder
@NoArgsConstructor(access= AccessLevel.PROTECTED)
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
}
