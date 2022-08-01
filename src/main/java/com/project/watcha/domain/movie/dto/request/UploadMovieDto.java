package com.project.watcha.domain.movie.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.watcha.domain.movie.Actor;
import com.project.watcha.domain.movie.Director;
import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.Getter;

import java.util.Collections;

@Getter
public class UploadMovieDto {

    private String title;
    private String content;
    private int year;
    private Genre genre;

    @JsonCreator
    public UploadMovieDto(
            @JsonProperty("title") String title,
            @JsonProperty("content") String content,
            @JsonProperty("year") int year,
            @JsonProperty("genre") Genre genre) {
        this.title = title;
        this.content = content;
        this.year = year;
        this.genre = genre;
    }

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
