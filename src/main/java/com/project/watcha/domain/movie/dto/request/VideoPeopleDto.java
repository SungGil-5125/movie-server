package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.movie.Video;
import com.project.watcha.domain.movie.VideoPeople;
import com.project.watcha.domain.movie.enumType.Role;
import com.project.watcha.domain.people.People;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class VideoPeopleDto {

    private String name;
    private Role role;
    private String cractor_name;

    public VideoPeople toEntity(People people, Video video) {
        return VideoPeople.builder()
                .character_name(name)
                .people(people)
                .video(video)
                .build();
    }
}
