package com.codgym.casestudyfurama.service.contract;

import com.codgym.casestudyfurama.model.contract.Contract;
import com.codgym.casestudyfurama.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractServiceImpl implements IContractService {
    @Autowired
    private IContractRepository iContractRepository;
    @Override
    public Page<Contract> getAllByKeyWord(Pageable pageable) {
        return iContractRepository.findAll(pageable);
    }

    @Override
    public void save(Contract contract) {
        this.iContractRepository.save(contract);
    }
}
