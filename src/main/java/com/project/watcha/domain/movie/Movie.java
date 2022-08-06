package com.project.watcha.domain.movie;

import com.project.watcha.domain.actor.Actor;
import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@Table(name = "movie")
public class Movie {

    @Id
    @GeneratedValue
    private Long movie_id;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Director> directors = new HashSet<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private Set<Actor> actors = new HashSet<>();

    /*
    director와 actor는 List로 저장해야 할듯
     */


    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int year;

    @Enumerated(STRING) @Column(name = "genre")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "genre", joinColumns = @JoinColumn(name = "movie_id"))
    private Set<Genre> genre = new HashSet<>();

    @Column
    private int spectator; // 관람가 등급

    @Column
    private String image_url;

    @Column
    private String movie_url;
}
