package com.project.watcha.domain.actor.dto.request;

import com.project.watcha.domain.actor.Actor;
import com.project.watcha.domain.movie.enumType.Cast;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collections;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterActorDto {

    private String name;

    public Actor toEntity(String url){
        return Actor.builder()
                .name(name)
                .cast(Cast.ACTOR)
                .url(url)
                .build();
    }

}
