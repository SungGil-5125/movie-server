package com.project.watcha.domain.movie.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.watcha.domain.movie.Actor;
import com.project.watcha.domain.movie.Director;
import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadMovieDto {

    private List<String> director_name;
    private List<String> actor_name;
    private String title;
    private String content;
    private int year;
    private Genre genre;

    public Movie toEntity(Director director, Actor actor, String url) {
        return Movie.builder()
                .director(director)
                .actor(actor)
                .title(title)
                .content(content)
                .year(year)
                .genre(Collections.singletonList(genre))
                .url(url)
                .build();
    }
}
