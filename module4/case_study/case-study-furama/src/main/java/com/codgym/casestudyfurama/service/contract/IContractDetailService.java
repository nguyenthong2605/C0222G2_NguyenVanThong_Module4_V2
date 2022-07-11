package com.codgym.casestudyfurama.service.contract;

import com.codgym.casestudyfurama.model.contract.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    void save(ContractDetail contractDetail);

    List<ContractDetail> findAll();
}
