package com.project.watcha.domain.movie;

import com.project.watcha.domain.movie.enumType.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Movie {

    @Id
    @GeneratedValue
    private Long movie_id;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Director.class)
    @JoinColumn(name = "director_id")
    private Director director;

    @ManyToOne(cascade = CascadeType.MERGE, targetEntity = Actor.class)
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int year;

    @Enumerated(STRING) @Column(name = "genre")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "genre", joinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genre = new ArrayList<>();

    @Column
    private int spectator; // 관람가 등급

    @Column
    private String url;
}
