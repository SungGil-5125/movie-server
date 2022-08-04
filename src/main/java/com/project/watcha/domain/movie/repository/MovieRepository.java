package com.project.watcha.domain.movie.repository;

import com.project.watcha.domain.movie.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
