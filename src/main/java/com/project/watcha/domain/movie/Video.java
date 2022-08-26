package com.project.watcha.domain.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.watcha.domain.movie.enumType.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
@Builder
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long movie_id;

    @JsonProperty
    @OneToMany(mappedBy = "video")
    private List<VideoPeople> videoPeople = new ArrayList<>();

    @Column
    private String title;

    @Column
    private String summary;

    @Column
    private int spectator; // 관람가 등급

    @Column
    private int opening_date;

    @Enumerated(STRING)
    @Column(name = "genre")
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "genre", joinColumns = @JoinColumn(name = "movie_id"))
    private List<Genre> genre = new ArrayList<>();

    @Column
    private int time;

    @Column
    private String image_url;

    @Column
    private String movie_url;

}
