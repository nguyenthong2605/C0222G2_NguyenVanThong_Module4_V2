package com.codgym.casestudyfurama.repository.facility;

import com.codgym.casestudyfurama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    Page<Facility> findAllByNameContaining(String name, Pageable pageable);
}
