package com.project.watcha.domain.movie.enumType;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Genre {
    SF("sf"),
    ACTION("action"),
    COMEDY("comedy"),
    ROMANCE("romance"),
    FANTASY("fantasy"),
    HORROR("horror");

    private final String code;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public static Genre findByCode(String code) {
        return Stream.of(Genre.values())
                .filter(c -> c.code.equals(code))
                .findFirst()
                .orElse(null);
    }
}
