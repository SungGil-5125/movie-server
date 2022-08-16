package com.project.watcha.domain.movie;

import com.project.watcha.domain.people.People;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MoviePeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moviePeople_id;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column
    private String character_name;

    @OneToOne
    @JoinColumn(name = "people")
    private People people;
}
