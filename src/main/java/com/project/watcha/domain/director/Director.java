package com.project.watcha.domain.director;

import com.project.watcha.domain.movie.Movie;
import com.project.watcha.domain.movie.enumType.Cast;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Director {

    @Id
    @GeneratedValue
    private Long director_id;

    @Column
    private String name;

    @Enumerated(STRING) @Column(name = "cast")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "casts", joinColumns = @JoinColumn(name = "actor_id"))
    private List<Cast> cast;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column
    private String url;

}
