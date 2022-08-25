package com.project.watcha.domain.movie.controller.user;

import com.project.watcha.domain.movie.dto.response.VideoResponseDto;
import com.project.watcha.domain.movie.service.VideoService;
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
public class UserVideoController {

    private final VideoService videoService;
    private final ResponseService responseService;

    @GetMapping("contents/{movie_id}")
    public CommonResultResponse contentMovie(@PathVariable Long movie_id) {
        VideoResponseDto result = videoService.contentVideo(movie_id);
        return responseService.getSingleResult(result);
    }

    @GetMapping("watch/{movie_id}")
    public CommonResultResponse watchMovie(@PathVariable Long movie_id) {
        String result = videoService.watchVideo(movie_id);
        return responseService.getSingleResult(result);
    }
}
