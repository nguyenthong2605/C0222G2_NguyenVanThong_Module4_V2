package com.codgym.casestudyfurama.repository.employee;

import com.codgym.casestudyfurama.model.employee.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDivisionRepository extends JpaRepository<Division, Integer> {
}
