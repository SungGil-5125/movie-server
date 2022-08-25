package com.project.watcha.domain.movie.service.Impl;

import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.MoviePeople;
import com.project.watcha.domain.movie.dto.request.MoviePeopleDto;
import com.project.watcha.domain.movie.dto.request.UploadMovieDto;
import com.project.watcha.domain.movie.dto.response.MovieResponseDto;
import com.project.watcha.domain.movie.repository.MoviePeopleRepository;
import com.project.watcha.domain.movie.repository.MovieRepository;
import com.project.watcha.domain.movie.service.MovieService;
import com.project.watcha.domain.people.People;
import com.project.watcha.domain.people.repository.PeopleRepository;
import com.project.watcha.global.exception.exceptions.MovieNotFoundException;
import com.project.watcha.global.exception.exceptions.PeopleNotFoundException;
import com.project.watcha.global.util.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.project.watcha.global.exception.ErrorCode.MOVIE_NOT_FOUND;
import static com.project.watcha.global.exception.ErrorCode.PEOPLE_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieServiceImpl implements MovieService {

    private final S3Service s3Service;
    private final MovieRepository movieRepository;
    private final MoviePeopleRepository moviePeopleRepository;
    private final PeopleRepository peopleRepository;

    @Transactional
    @Override
    public void uploadMovie(UploadMovieDto uploadMovieDto, MultipartFile imageFile, MultipartFile movieFile) {

        /*
        배우 이름을 list로 넣는데 그에 맞는 캐릭터 이름을 어떻게 넣냐
        이중 list? ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ

       [
            [ "name" : "톰 크루즈", "role" : "주연", "cractor_name" : "매버릭" ],
            [ "name" : "발 킬머", "role" : "조연", "cractor_name" : "아이스맨" ]
       ]

        ArrayList<ArrayList<MoviePeople>> moviePeople;

        이거까진 성공했는데 moviePeople를 database에 어떻게 넣냐..

        movie -> moviePeople 순서대로잖아

        배우랑 감독을 먼저 등록
        근데 배우랑 감독인건 어캐 아는거냐


         */

        String imageUrl = s3Service. upload(imageFile, "movie_image/");
        String movieUrl = s3Service.upload(movieFile, "movie/");

        Movie movie = uploadMovieDto.toEntity(imageUrl, movieUrl);
        movieRepository.save(movie);

        List<MoviePeopleDto> moviePeoples = uploadMovieDto.getMoviePeople();
        moviePeoples.forEach(Peoples -> {

            log.info(Peoples.getName());

            People people = peopleRepository.findByName(Peoples.getName())
                    .orElseThrow(() -> new PeopleNotFoundException(PEOPLE_NOT_FOUND));

            MoviePeople moviePeople = MoviePeople.builder()
                    .character_name(Peoples.getCractor_name())
                    .movie(movie)
                    .people(people)
                    .build();
            moviePeopleRepository.save(moviePeople);
        });

    }

    @Transactional
    @Override
    public MovieResponseDto contentMovie(Long movie_id) {
        Movie movie = movieRepository.findById(movie_id)
                .orElseThrow(() -> new MovieNotFoundException(MOVIE_NOT_FOUND));

        MovieResponseDto movieResponseDto = MovieResponseDto.builder()
                .title(movie.getTitle())
                .content(movie.getContent())
                .spector(movie.getSpectator())
                .genre(movie.getGenre())
                .image_url(movie.getImage_url())
                .build();

        return movieResponseDto;
    }

    @Transactional
    @Override
    public String watchMovie(Long movie_id) {
        Movie movie = movieRepository.findById(movie_id)
                .orElseThrow(() -> new MovieNotFoundException(MOVIE_NOT_FOUND));

        return movie.getMovie_url();
    }
}
