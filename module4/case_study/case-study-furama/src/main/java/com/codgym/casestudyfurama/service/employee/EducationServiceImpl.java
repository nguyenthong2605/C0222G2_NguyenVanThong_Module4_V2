package com.codgym.casestudyfurama.service.employee;

import com.codgym.casestudyfurama.repository.employee.IEducationDegreeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationServiceImpl implements IEducationDegreeService {
    @Autowired
    private IEducationDegreeRepository iEducationDegreeRepository;
}
