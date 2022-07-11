package com.codgym.casestudyfurama.service.contract;

import com.codgym.casestudyfurama.model.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<Contract> getAllByKeyWord(Pageable pageable);

    void save(Contract contract);
}
