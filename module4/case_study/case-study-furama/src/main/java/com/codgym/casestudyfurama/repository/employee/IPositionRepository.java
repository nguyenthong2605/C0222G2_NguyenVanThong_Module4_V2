package com.codgym.casestudyfurama.repository.employee;

import com.codgym.casestudyfurama.model.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Integer> {
}
