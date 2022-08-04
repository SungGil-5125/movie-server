package com.project.watcha.domain.movie.repository;

import com.project.watcha.domain.movie.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
//    String findByName(String name);
}
