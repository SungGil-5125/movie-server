package com.project.watcha.domain.people.service;

import com.project.watcha.domain.people.dto.RegisterPeopleDto;
import org.springframework.web.multipart.MultipartFile;

public interface PeopleService {

    Long registerPeople(RegisterPeopleDto registerPeopleDto, MultipartFile file);
}
