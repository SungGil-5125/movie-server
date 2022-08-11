package com.project.watcha.domain.movie.service;

import com.project.watcha.domain.movie.dto.request.UploadMovieDto;
import com.project.watcha.domain.movie.dto.response.MovieResponseDto;
import org.springframework.web.multipart.MultipartFile;

public interface MovieService {

    void uploadMovie(UploadMovieDto uploadMovieDto, MultipartFile imageFile, MultipartFile movieFile);
    MovieResponseDto contentMovie(Long movie_id);
    String watchMovie(Long movie_id);

}
