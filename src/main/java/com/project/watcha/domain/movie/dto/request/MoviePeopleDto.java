package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.movie.enumType.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MoviePeopleDto {

    private String name;
    private Role role;
    private String cractor_name;

}
