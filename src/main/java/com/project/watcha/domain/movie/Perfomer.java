package com.project.watcha.domain.movie;

import com.project.watcha.domain.movie.enumType.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.EnumType.STRING;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Perfomer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long perfomer_id;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column
    private String performer_name;

    @Column
    private String casting;

    @Column @Enumerated(STRING)
    private Role role;
}
