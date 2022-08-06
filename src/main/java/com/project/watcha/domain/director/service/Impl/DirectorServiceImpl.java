package com.project.watcha.domain.director.service.Impl;

import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.director.dto.request.RegisterDirectorDto;
import com.project.watcha.domain.director.repository.DirectorRepository;
import com.project.watcha.domain.director.service.DirectorService;
import com.project.watcha.domain.movie.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final S3Service s3Service;
    private final DirectorRepository directorRepository;

    @Override
    public Long registerDirector(RegisterDirectorDto registerDirectorDto, MultipartFile file) {
        String url = s3Service.upload(file, "director_image/");
        Director director = registerDirectorDto.toEntity(url);
        return directorRepository.save(director).getDirector_id();
    }
}
