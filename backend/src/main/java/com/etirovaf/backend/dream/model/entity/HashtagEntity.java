package com.etirovaf.backend.dream.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hashtag")
public class HashtagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Hashtag hashtag;    // Hashtag 엔티티를 매핑

    public HashtagEntity(Hashtag hashtag) {
        this.hashtag = hashtag;
    }
}
