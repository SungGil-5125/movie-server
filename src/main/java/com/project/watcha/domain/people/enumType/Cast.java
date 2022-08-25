package com.project.watcha.domain.people.enumType;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Cast {

    DIRECTOR("director"),
    ACTOR("actor");

    private final String code;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Cast findByCode(String code) {
        return Stream.of(Cast.values())
                .filter(c -> c.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
