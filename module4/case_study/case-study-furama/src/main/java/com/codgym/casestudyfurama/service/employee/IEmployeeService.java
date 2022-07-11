package com.codgym.casestudyfurama.service.employee;

import com.codgym.casestudyfurama.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> getAllEmployee(String keywordVal, Pageable pageable);
}
