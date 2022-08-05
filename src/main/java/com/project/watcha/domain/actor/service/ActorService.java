package com.project.watcha.domain.actor.service;

import com.project.watcha.domain.actor.dto.request.RegisterActorDto;
import org.springframework.web.multipart.MultipartFile;

public interface ActorService {

    Long registerActor(RegisterActorDto registerActorDto, MultipartFile file);
}
