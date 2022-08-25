package com.project.watcha.domain.people.dto;

import com.project.watcha.domain.people.enumType.Cast;
import com.project.watcha.domain.people.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterPeopleDto {

    private String name;
    private Cast cast;

    public People toEntity(String image_url) {
        return People.builder()
                .name(name)
                .image_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/people_image/" + image_url)
                .cast(cast)
                .build();
    }
}
