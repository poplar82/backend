package com.topolski.backend.week8.repo;

import com.topolski.backend.week8.model.Temp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TempRepo extends JpaRepository<Temp, Long> {
}
