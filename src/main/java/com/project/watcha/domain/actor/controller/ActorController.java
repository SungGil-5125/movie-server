package com.project.watcha.domain.actor.controller;

import com.project.watcha.domain.actor.dto.request.RegisterActorDto;
import com.project.watcha.domain.actor.service.ActorService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ActorController {

    private final ActorService actorService;
    private final ResponseService responseService;

    @PostMapping("register/actor")
    public CommonResultResponse registerActor(
            @RequestPart @Valid RegisterActorDto registerActorDto,
            @RequestParam(required = false)MultipartFile file) {
        actorService.registerActor(registerActorDto, file);
        return responseService.getSuccessResult();
    }
}
