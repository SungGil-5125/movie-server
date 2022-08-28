package com.project.watcha.domain.movie;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
public class VideoPeople {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moviePeople_id;

    @JsonIgnore // jackson이 json으로 변환하는걸 무시하게 만들어줌 그래서 수환참조가 안일어남
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Video video;

    @Column
    private String character_name;

    @OneToOne
    @JoinColumn(name = "people_id")
    private People people;

}
