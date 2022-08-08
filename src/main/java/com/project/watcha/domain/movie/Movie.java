package com.project.watcha.domain.movie;

import com.project.watcha.domain.actor.Actor;
import com.project.watcha.domain.director.Director;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Director> directors = new ArrayList<>();

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Actor> actors = new ArrayList<>();

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private int spectator; // 관람가 등급

    @Column
    private int year;

    @Enumerated(STRING) @Column(name = "genre")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "genre", joinColumns = @JoinColumn(name = "movie_id"))
    private Set<Genre> genre = new HashSet<>();

    @Column
    private String image_url;

    @Column
    private String movie_url;
}
