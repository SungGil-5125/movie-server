package com.project.watcha.domain.movie.dto.request;

import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.MoviePeople;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UploadMovieDto {

    private String title;
    private String content;
    private ArrayList<ArrayList<MoviePeopleDto>> moviePeople;
    private int time;
    private int spector;
    private int opening_date;
    private List<Genre> genre;

    public Movie toEntity(MoviePeople moviePeople, String image, String movie) {
        return Movie.builder()
                .title(title)
                .content(content)
                .moviePeople(moviePeople)
                .time(time)
                .spectator(spector)
                .opening_date(opening_date)
                .genre(genre)
                .image_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/movie_image/" + image)
                .movie_url("https://watcha-s3-bucket.s3.ap-northeast-2.amazonaws.com/movie/" + movie)
                .build();
    }
}
