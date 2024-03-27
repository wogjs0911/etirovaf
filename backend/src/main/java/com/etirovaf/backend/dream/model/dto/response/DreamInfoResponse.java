package com.etirovaf.backend.dream.model.dto.response;

import com.etirovaf.backend.dream.model.entity.Dream;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DreamInfoResponse {
    private Long id;
    private String title;
    private String place;
    private String deadline;
    private String organizer;
    private String content;
    private String image;
    private List<String> hashtag;

    public static DreamInfoResponse of(Dream entity){
        return DreamInfoResponse.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .place(entity.getPlace())
                .deadline(entity.getDeadline())
                .organizer(entity.getOrganizer())
                .content(entity.getContent())
                .image(entity.getImage())
                .hashtag(entity.getHashtag())
                .build();
    }
}
