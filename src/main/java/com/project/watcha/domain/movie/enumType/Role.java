package com.project.watcha.domain.movie.enumType;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
public enum Role {
    DIRECTOR("director"),
    MAIN_ACTOR("main_actor"),
    SUPPORTING_ACTOR("supporting_actor");

    private final String code;

    Role(String code) {
        this.code = code;
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Role findByCode(String code) {
        return Stream.of(Role.values())
                .filter(c -> c.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
