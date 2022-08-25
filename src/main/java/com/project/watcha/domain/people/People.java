package com.project.watcha.domain.people;

import com.project.watcha.domain.people.enumType.Cast;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long people_id;

    @Column
    private String name;

    @Column @Enumerated(STRING)
    private Cast cast;

    @Column
    private String image_url;
}
