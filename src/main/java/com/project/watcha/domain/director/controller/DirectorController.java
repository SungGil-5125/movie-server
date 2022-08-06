package com.project.watcha.domain.director.controller;

import com.project.watcha.domain.director.dto.request.RegisterDirectorDto;
import com.project.watcha.domain.director.service.DirectorService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;
    private final ResponseService responseService;

    @PostMapping("register/director")
    public CommonResultResponse registerDirector(
            @RequestPart(value = "directorDto") RegisterDirectorDto registerDirectorDto,
            @RequestParam(required = false, value = "image") MultipartFile file) {
        directorService.registerDirector(registerDirectorDto, file);
        return responseService.getSuccessResult();
    }
}
