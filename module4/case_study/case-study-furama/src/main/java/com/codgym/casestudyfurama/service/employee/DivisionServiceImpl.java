package com.codgym.casestudyfurama.service.employee;

import com.codgym.casestudyfurama.repository.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DivisionServiceImpl implements IDivisionService{
    @Autowired
    private IDivisionRepository iDivisionRepository;
}
