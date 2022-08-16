package com.project.watcha.domain.people;

import com.project.watcha.domain.movie.enumType.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long people_id;

    @Column
    private String name;

    @Column @Enumerated(STRING)
    private Role role;
}
