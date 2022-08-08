package com.project.watcha.domain.director.dto.request;

import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.movie.enumType.Cast;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDirectorDto {

    private String name;

    public Director toEntity(String url) {
        return Director.builder()
                .name(name)
                .cast(Cast.DIRECTOR)
                .url(url)
                .build();
    }
}
