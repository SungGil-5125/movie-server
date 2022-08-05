package com.project.watcha.domain.director.repository;

import com.project.watcha.domain.director.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepository extends JpaRepository<Director, Long> {
    Director findByName(String name);
}
