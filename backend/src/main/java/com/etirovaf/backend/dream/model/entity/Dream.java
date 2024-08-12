package com.etirovaf.backend.dream.model.entity;

import com.etirovaf.backend.common.exception.BaseResDto;
import com.etirovaf.backend.dream.model.dto.request.DreamInfoRequest;
import com.etirovaf.backend.member.model.entity.Member;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Dream extends BaseResDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, length = 50)
    private String place;

    @Column(nullable = false, length = 50)
    private String deadline;

    @Column(nullable = false, length = 50)
    private String organizer;

    @Column(nullable = false, length = 200)
    private String content;

    @Column(nullable = true)
    private String image;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dream_id")
    private List<HashtagEntity> hashtag = new ArrayList<>(); // 테이블 따로 빼기(다대일 vs 일대다)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "member_id")  // xtoOne은 Fk쪽에 LAZY 설정
    private Member member;

    public static Dream of(DreamInfoRequest entity){
        return Dream.builder()
                .title(entity.getTitle())
                .place(entity.getPlace())
                .deadline(entity.getDeadline())
                .organizer(entity.getOrganizer())
                .content(entity.getContent())
                .image(entity.getImage())
                .hashtag(entity.getHashtag())
                .member(entity.getMember())
                .build();
    }

    public static Dream saveDream(DreamInfoRequest entity){
        return Dream.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .place(entity.getPlace())
                .deadline(entity.getDeadline())
                .organizer(entity.getOrganizer())
                .content(entity.getContent())
                .image(entity.getImage())
                .hashtag(entity.getHashtag())
                .member(entity.getMember())
                .build();
    }
}
