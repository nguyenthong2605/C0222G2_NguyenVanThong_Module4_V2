package com.codgym.casestudyfurama.service.facility;

import com.codgym.casestudyfurama.model.facility.FacilityType;
import com.codgym.casestudyfurama.repository.facility.IFacilityTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeServiceImpl implements IFacilityTypeService{
    @Autowired
    private IFacilityTypeRepository iFacilityTypeRepository;
    @Override
    public List<FacilityType> findAll() {
        return iFacilityTypeRepository.findAll();
    }
}
