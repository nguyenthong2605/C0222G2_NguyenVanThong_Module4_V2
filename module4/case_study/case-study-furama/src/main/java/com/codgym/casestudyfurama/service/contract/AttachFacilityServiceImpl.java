package com.codgym.casestudyfurama.service.contract;

import com.codgym.casestudyfurama.model.contract.AttachFacility;
import com.codgym.casestudyfurama.repository.contract.IAttachFacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityServiceImpl implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository iAttachFacilityRepository;
    @Override
    public List<AttachFacility> findAll() {
        return iAttachFacilityRepository.findAll();
    }
}
