package com.codgym.casestudyfurama.repository.employee;

import com.codgym.casestudyfurama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    Page<Employee> findAllByNameContaining(String keywordVal, Pageable pageable);
}
