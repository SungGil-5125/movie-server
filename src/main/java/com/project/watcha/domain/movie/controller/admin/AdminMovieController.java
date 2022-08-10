package com.project.watcha.domain.movie.controller.admin;

import com.project.watcha.domain.movie.dto.request.UploadMovieDto;
import com.project.watcha.domain.movie.dto.response.MovieResponseDto;
import com.project.watcha.domain.movie.service.MovieService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/")
public class AdminMovieController {

    private final MovieService movieService;
    private final ResponseService responseService;

    @PostMapping("upload/movie")
    public CommonResultResponse uploadMovie(
            @RequestPart(value = "movieDto") UploadMovieDto uploadMovieDto,
            @RequestParam(value = "image", required = false) MultipartFile imageFile,
            @RequestParam(value = "movie", required = false) MultipartFile movieFile) {
        movieService.uploadMovie(uploadMovieDto, imageFile, movieFile);
        return responseService.getSuccessResult();
    }

    @PostMapping("")

    @GetMapping("contents/{movie_id}")
    public CommonResultResponse contentMovie(@PathVariable Long movie_id) {
        MovieResponseDto data = movieService.contentMovie(movie_id);
        return responseService.getSingleResult(data);
    }

    @GetMapping("watch/{movie_id}")
    public CommonResultResponse watchMovie(@PathVariable Long movie_id) {
        String data = movieService.watchMovie(movie_id);
        return responseService.getSingleResult(data);
    }

}
