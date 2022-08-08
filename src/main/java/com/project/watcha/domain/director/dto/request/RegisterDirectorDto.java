package com.project.watcha.domain.director.dto.request;

import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.movie.enumType.Cast;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDirectorDto {

    private String name;

    public Director toEntity(String url) {
        return Director.builder()
                .name(name)
                .cast(Cast.DIRECTOR)
                .url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/director_image/" + url)
                .build();
    }
}
