package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.MoviePeople;
import com.project.watcha.domain.movie.enumType.Role;
import com.project.watcha.domain.people.People;
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

    public MoviePeople toEntity(People people, Movie movie) {
        return MoviePeople.builder()
                .character_name(name)
                .people(people)
                .movie(movie)
                .build();
    }
}
