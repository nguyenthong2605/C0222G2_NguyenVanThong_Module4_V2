package com.codgym.casestudyfurama.service.facility;

import com.codgym.casestudyfurama.model.facility.RentType;
import com.codgym.casestudyfurama.repository.facility.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository iRentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.iRentTypeRepository.findAll();
    }
}
