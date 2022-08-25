package com.project.watcha.domain.movie.repository;

import com.project.watcha.domain.movie.VideoPeople;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoPeopleRepository extends JpaRepository<VideoPeople, Long> {
}
