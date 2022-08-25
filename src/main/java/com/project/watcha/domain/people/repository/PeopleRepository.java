package com.project.watcha.domain.people.repository;

import com.project.watcha.domain.people.People;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PeopleRepository extends JpaRepository<People, Long> {
    Optional<People> findByName(String name);
}
