package com.project.watcha.domain.movie.controller.admin;

import com.project.watcha.domain.movie.dto.request.UploadVideoDto;
import com.project.watcha.domain.movie.dto.response.AllVideoDto;
import com.project.watcha.domain.movie.dto.response.VideoResponseDto;
import com.project.watcha.domain.movie.service.VideoService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/")
public class AdminVideoController {

    private final VideoService videoService;
    private final ResponseService responseService;

    @PostMapping("upload/movie")
    public CommonResultResponse uploadMovie(
            @RequestPart(value = "movieDto") UploadVideoDto uploadVideoDto,
            @RequestPart(value = "image", required = false) MultipartFile imageFile,
            @RequestPart(value = "movie", required = false) MultipartFile movieFile) {
        videoService.uploadVideo(uploadVideoDto, imageFile, movieFile);
        return responseService.getSuccessResult();
    }

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

    @GetMapping("browse/video")
    public CommonResultResponse browseVideo() {
        List<AllVideoDto> result = videoService.browseVideo();
        return responseService.getSingleResult(result);
    }
}
