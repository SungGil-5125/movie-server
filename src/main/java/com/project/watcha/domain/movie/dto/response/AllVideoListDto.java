package com.project.watcha.domain.movie.dto.response;

import com.project.watcha.domain.movie.Video;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class AllVideoListDto {

    List<Video> videoList;
}
