package com.project.watcha.domain.director.controller.admin;

import com.project.watcha.domain.director.dto.request.RegisterDirectorDto;
import com.project.watcha.domain.director.service.DirectorService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/")
public class AdminDirectorController {

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
