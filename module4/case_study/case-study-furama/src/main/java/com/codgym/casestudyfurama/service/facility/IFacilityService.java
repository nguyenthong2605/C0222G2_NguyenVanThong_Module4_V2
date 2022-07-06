package com.codgym.casestudyfurama.service.facility;

import com.codgym.casestudyfurama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    Page<Facility> getAllByKeyWord(String keywordVal, Pageable pageable);

    void save(Facility facility);

    Facility findById(Integer id);

    void deleteFacilityById(Facility facility);
}
