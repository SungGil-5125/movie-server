package com.project.watcha.domain.movie.repository;

import com.project.watcha.domain.movie.MoviePeople;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MoviePeopleRepository extends JpaRepository<MoviePeople, Long> {
}
