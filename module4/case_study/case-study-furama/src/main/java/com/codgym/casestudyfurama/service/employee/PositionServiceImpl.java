package com.codgym.casestudyfurama.service.employee;

import com.codgym.casestudyfurama.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionServiceImpl implements IPosotionService{
    @Autowired
    private IPositionRepository iPositionRepository;
}
