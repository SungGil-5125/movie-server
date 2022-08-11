package com.project.watcha.domain.actor.controller.admin;

import com.project.watcha.domain.actor.dto.request.RegisterActorDto;
import com.project.watcha.domain.actor.service.ActorService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/")
public class AdmainActorController {

    private final ActorService actorService;
    private final ResponseService responseService;

    @PostMapping("register/actor")
    public CommonResultResponse registerActor(
            @RequestPart(value = "actorDto") RegisterActorDto registerActorDto,
            @RequestParam(required = false, value = "image") MultipartFile file) {
        actorService.registerActor(registerActorDto, file);
        return responseService.getSuccessResult();
    }
}
