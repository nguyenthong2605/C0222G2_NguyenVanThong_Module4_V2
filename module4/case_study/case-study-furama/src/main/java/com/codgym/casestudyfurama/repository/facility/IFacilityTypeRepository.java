package com.codgym.casestudyfurama.repository.facility;

import com.codgym.casestudyfurama.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType, Integer> {
}
