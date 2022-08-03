package com.project.watcha.domain.movie.controller;

import com.project.watcha.domain.movie.dto.request.UploadMovieDto;
import com.project.watcha.domain.movie.service.MovieService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;
    private final ResponseService responseService;

    @PostMapping("/upload/movie")
    public CommonResultResponse uploadMovie(
            @RequestParam(value = "movieDto") UploadMovieDto uploadMovieDto,
            @RequestParam(value = "file", required = false) MultipartFile file) {
        movieService.uploadMovie(uploadMovieDto, file);
        return responseService.getSuccessResult();
    }
}
