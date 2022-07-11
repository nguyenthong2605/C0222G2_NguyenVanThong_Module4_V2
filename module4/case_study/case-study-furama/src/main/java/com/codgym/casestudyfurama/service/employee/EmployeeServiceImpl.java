package com.codgym.casestudyfurama.service.employee;

import com.codgym.casestudyfurama.model.employee.Employee;
import com.codgym.casestudyfurama.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> getAllEmployee(String keywordVal, Pageable pageable) {
        return this.iEmployeeRepository.findAllByNameContaining(keywordVal, pageable);
    }
}
