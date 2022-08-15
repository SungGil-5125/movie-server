package com.project.watcha.domain.actor.service.Impl;

import com.project.watcha.domain.actor.Actor;
import com.project.watcha.domain.actor.dto.request.RegisterActorDto;
import com.project.watcha.domain.actor.repository.ActorRepository;
import com.project.watcha.domain.actor.service.ActorService;
import com.project.watcha.domain.movie.service.S3Service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ActorServiceImpl implements ActorService {

    private final S3Service s3Service;
    private final ActorRepository actorRepository;

    @Transactional
    @Override
    public Long registerActor(RegisterActorDto registerActorDto, MultipartFile file) {
        String url = s3Service.upload(file, "actor_image/");
        Actor actor = registerActorDto.toEntity(url);
        return actorRepository.save(actor).getActor_id();
    }
}
