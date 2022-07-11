package com.codgym.casestudyfurama.repository.contract;

import com.codgym.casestudyfurama.model.contract.Contract;
import com.codgym.casestudyfurama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllById(String name, Pageable pageable);
}
