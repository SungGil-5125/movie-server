package com.project.watcha.domain.director;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column
    private String url;

}
