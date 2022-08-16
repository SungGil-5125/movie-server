package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.movie.enumType.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MoviePeopleDto {

    private String name;
    private Role role;
    private String cractor_name;
}
