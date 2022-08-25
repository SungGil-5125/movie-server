package com.project.watcha.domain.people.controller.admin;

import com.project.watcha.domain.people.dto.RegisterPeopleDto;
import com.project.watcha.domain.people.service.PeopleService;
import com.project.watcha.global.response.ResponseService;
import com.project.watcha.global.response.result.CommonResultResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/")
public class AdminPeopleController {

    private final PeopleService peopleService;
    private final ResponseService responseService;

    @PostMapping("register/people")
    public CommonResultResponse registerPeople(
            @RequestPart(name = "peopleDto") RegisterPeopleDto registerPeopleDto,
            @RequestPart(name = "image", required = false) MultipartFile file) {
        peopleService.registerPeople(registerPeopleDto, file);
        return responseService.getSuccessResult();
    }
}
