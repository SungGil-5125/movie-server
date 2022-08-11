package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.actor.Actor;
import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadMovieDto {

    private List<String> directorName;
    private List<String> actorName;
    private String title;
    private String content;
    private int time;
    private int spector;
    private int opening_date;
    private List<Genre> genre;

    public Movie toEntity(List<Director> directors, List<Actor> actors, String image, String movie) {
        return Movie.builder()
                .directors(directors)
                .actors(actors)
                .title(title)
                .content(content)
                .time(time)
                .spectator(spector)
                .opening_date(opening_date)
                .genre(genre)
                .image_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/movie_image/" + image)
                .movie_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/movie/" + movie)
                .build();
    }
}
