package com.etirovaf.backend.dream.model.dto.request;

import com.etirovaf.backend.dream.model.entity.Dream;
import com.etirovaf.backend.dream.model.entity.HashtagEntity;
import com.etirovaf.backend.member.model.entity.Member;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DreamInfoRequest {
    private Long id;
    private String title;
    private String place;
    private String deadline;
    private String organizer;
    private String content;
    private String image;
    private List<HashtagEntity> hashtag;
    private Member member;

    public static DreamInfoRequest of(Dream entity){
        return DreamInfoRequest.builder()
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
