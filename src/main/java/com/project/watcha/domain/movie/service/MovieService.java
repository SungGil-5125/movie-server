package com.project.watcha.domain.movie.service;

import com.project.watcha.domain.movie.dto.request.UploadMovieDto;
import org.springframework.web.multipart.MultipartFile;

public interface MovieService {
    Long uploadMovie(UploadMovieDto uploadMovieDto, MultipartFile imageFile, MultipartFile movieFile);
}
