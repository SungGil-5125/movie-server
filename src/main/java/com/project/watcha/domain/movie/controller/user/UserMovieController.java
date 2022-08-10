package com.project.watcha.domain.movie.controller.user;

import com.project.watcha.domain.movie.dto.response.MovieResponseDto;
import com.project.watcha.domain.movie.service.MovieService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/user/")
@RequiredArgsConstructor
public class UserMovieController {

    private final MovieService movieService;
    private final ResponseService responseService;

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
