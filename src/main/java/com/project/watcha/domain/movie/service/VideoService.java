package com.project.watcha.domain.movie.service;

import com.project.watcha.domain.movie.dto.request.UploadVideoDto;
import com.project.watcha.domain.movie.dto.response.AllVideoDto;
import com.project.watcha.domain.movie.dto.response.VideoResponseDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface VideoService {

    void uploadVideo(UploadVideoDto uploadVideoDto, MultipartFile imageFile, MultipartFile movieFile);
    VideoResponseDto contentVideo(Long movie_id);
    String watchVideo(Long movie_id);
    List<AllVideoDto> browseVideo();
}
