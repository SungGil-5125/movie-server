package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.actor.Actor;
import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadMovieDto {

    private List<String> directorName;
    private List<String> actorName;
    private String title;
    private String content;
    private int spector;
    private int year;
    private Genre genre;

    public Movie toEntity(List<Director> directors, List<Actor> actors, String image, String movie) {
        return Movie.builder()
                .directors(directors)
                .actors(actors)
                .title(title)
                .content(content)
                .spectator(spector)
                .year(year)
                .genre(Set.of(genre))
                .image_url(image)
                .movie_url(movie)
                .build();
    }
}
