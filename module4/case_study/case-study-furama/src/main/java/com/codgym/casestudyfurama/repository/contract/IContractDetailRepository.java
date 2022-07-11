package com.codgym.casestudyfurama.repository.contract;

import com.codgym.casestudyfurama.model.contract.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
