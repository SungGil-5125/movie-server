package com.project.watcha.domain.director.service;

import com.project.watcha.domain.director.dto.request.RegisterDirectorDto;
import org.springframework.web.multipart.MultipartFile;

public interface DirectorService {

    Long registerDirector(RegisterDirectorDto registerDirectorDto, MultipartFile file);
}
