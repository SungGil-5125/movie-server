package com.project.watcha.domain.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column
    private String url;
}
