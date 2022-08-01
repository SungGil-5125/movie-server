package com.project.watcha.domain.movie;

import com.project.watcha.domain.movie.enumType.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Actor {

    @Id
    @GeneratedValue
    private Long actor_id;

    @Column
    private String name;

    @Enumerated(STRING) @Column(name = "genre")
    @ElementCollection(fetch = FetchType.EAGER) // 바로 가져오기
    @CollectionTable(name = "actor_gender", joinColumns = @JoinColumn(name = "actor_id"))
    private List<Gender> gender = new ArrayList<>();
}
