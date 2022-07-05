package com.codgym.casestudyfurama.service.facility;

import com.codgym.casestudyfurama.model.facility.Facility;
import com.codgym.casestudyfurama.repository.facility.IFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FacilityServiceImpl implements IFacilityService {
    @Autowired
    private IFacilityRepository iFacilityRepository;

    @Override
    public Page<Facility> getAllByKeyWord(String keywordVal, Pageable pageable) {
        return this.iFacilityRepository.findAllByNameContaining(keywordVal,pageable);
    }
}
