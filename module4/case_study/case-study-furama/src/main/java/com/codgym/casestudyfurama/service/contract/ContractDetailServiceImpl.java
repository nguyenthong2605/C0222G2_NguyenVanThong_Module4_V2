package com.codgym.casestudyfurama.service.contract;

import com.codgym.casestudyfurama.model.contract.ContractDetail;
import com.codgym.casestudyfurama.repository.contract.IContractDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailServiceImpl implements IContractDetailService{
    @Autowired
    private IContractDetailRepository iContractDetailRepository;
    @Override
    public void save(ContractDetail contractDetail) {
        this.iContractDetailRepository.save(contractDetail);
    }

    @Override
    public List<ContractDetail> findAll() {
        return this.iContractDetailRepository.findAll();
    }
}
