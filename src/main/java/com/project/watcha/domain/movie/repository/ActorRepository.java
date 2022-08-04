package com.project.watcha.domain.movie.repository;

import com.project.watcha.domain.movie.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
//    String findByNames(String name);
}
