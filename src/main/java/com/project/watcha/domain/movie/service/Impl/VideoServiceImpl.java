package com.project.watcha.domain.movie.service.Impl;

import com.project.watcha.domain.movie.Video;
import com.project.watcha.domain.movie.VideoPeople;
import com.project.watcha.domain.movie.dto.request.UploadVideoDto;
import com.project.watcha.domain.movie.dto.request.VideoPeopleDto;
import com.project.watcha.domain.movie.dto.response.VideoResponseDto;
import com.project.watcha.domain.movie.repository.VideoPeopleRepository;
import com.project.watcha.domain.movie.repository.VideoRepository;
import com.project.watcha.domain.movie.service.VideoService;
import com.project.watcha.domain.people.People;
import com.project.watcha.domain.people.repository.PeopleRepository;
import com.project.watcha.global.exception.exceptions.PeopleNotFoundException;
import com.project.watcha.global.exception.exceptions.VideoNotFoundException;
import com.project.watcha.global.util.S3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static com.project.watcha.global.exception.ErrorCode.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class VideoServiceImpl implements VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;
    private final VideoPeopleRepository moviePeopleRepository;
    private final PeopleRepository peopleRepository;

    @Transactional
    @Override
    public void uploadVideo(UploadVideoDto uploadVideoDto, MultipartFile imageFile, MultipartFile movieFile) {

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

        Video video = uploadVideoDto.toEntity(imageUrl, movieUrl);
        videoRepository.save(video);

        List<VideoPeopleDto> moviePeoples = uploadVideoDto.getMoviePeople();
        moviePeoples.forEach(Peoples -> {

            log.info(Peoples.getName());

            People people = peopleRepository.findByName(Peoples.getName())
                    .orElseThrow(() -> new PeopleNotFoundException(PEOPLE_NOT_FOUND));

            VideoPeople videoPeople = VideoPeople.builder()
                    .character_name(Peoples.getCractor_name())
                    .video(video)
                    .people(people)
                    .build();
            moviePeopleRepository.save(videoPeople);
        });

    }

    @Transactional
    @Override
    public VideoResponseDto contentVideo(Long movie_id) {
        Video video = videoRepository.findById(movie_id)
                .orElseThrow(() -> new VideoNotFoundException(VIDEO_NOT_FOUND));

        VideoResponseDto videoResponseDto = VideoResponseDto.builder()
                .title(video.getTitle())
                .content(video.getSummary())
                .spector(video.getSpectator())
                .genre(video.getGenre())
                .image_url(video.getImage_url())
                .build();

        return videoResponseDto;
    }

    @Transactional
    @Override
    public String watchVideo(Long movie_id) {
        Video video = videoRepository.findById(movie_id)
                .orElseThrow(() -> new VideoNotFoundException(VIDEO_NOT_FOUND));

        return video.getMovie_url();
    }
}
