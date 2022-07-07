package com.codgym.casestudyfurama.service.customer;

import com.codgym.casestudyfurama.model.customer.CustomerType;
import com.codgym.casestudyfurama.repository.customer.ICustomerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository iCustomerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.iCustomerTypeRepository.findAll();
    }
}
