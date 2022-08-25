package com.project.watcha.domain.people.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.watcha.domain.people.dto.RegisterPeopleDto;
import com.project.watcha.domain.people.enumType.Cast;
import com.project.watcha.global.util.S3Service;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
class PeopleServiceTest {

    @Autowired
    PeopleService peopleService;

    @Autowired
    S3Service s3Service;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    @DisplayName("배우 올리기 테스트")
    void registerPeople() throws Exception {

        //given
        MockMultipartFile mockMultipartFile = new MockMultipartFile("image", "jpeg.jpeg", "image/jpeg",
                new FileInputStream("C:\\Users\\user\\source\\repos\\sex\\SpringBoot-watcha\\src\\test\\java\\com\\project\\watcha\\image\\jpeg.jpeg"));
        RegisterPeopleDto registerPeopleDto = RegisterPeopleDto.builder()
                .name("톰 크루즈")
                .cast(Cast.ACTOR)
                .build();
        String registerPeopleDtoToJson = objectMapper.writeValueAsString(registerPeopleDto);
        MockMultipartFile registerPeople = new MockMultipartFile("registerPeople", "registerPeople", "application/json", registerPeopleDtoToJson.getBytes(StandardCharsets.UTF_8));

        //when
        ResultActions resultActions = mockMvc.perform(
                multipart("/v1/admin/register/people")
                        .file("image", mockMultipartFile.getBytes())
//                        .content(registerPeople.getBytes())
                        .file("peopleDto", registerPeople.getBytes())
                        .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJzMjEwMjJAZ3NtLmNvbSIsInRva2VuVHlwZSI6ImFjY2Vzc1Rva2VuIiwiaWF0IjoxNjYxMzkyMDU1LCJleHAiOjE2NjE0MDI4NTV9.59dx3dL-55GErHM6vlUSQvuSWe5AWR2YSTPLfU1WVU0")
        );

        //then
        Assertions.assertThat(resultActions.andExpect(status().isOk())).isEqualTo(OK);
    }
}