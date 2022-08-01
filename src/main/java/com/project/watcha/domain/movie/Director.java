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
public class Director {

    @Id
    @GeneratedValue
    private Long director_id;

    @Column
    private String name;

    @Enumerated(STRING) @Column(name = "genre")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "director_gender", joinColumns = @JoinColumn(name = "director_id"))
    private List<Gender> gender = new ArrayList<>();


}
