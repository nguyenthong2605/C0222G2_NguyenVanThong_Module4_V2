package com.codgym.casestudyfurama.service.customer;

import com.codgym.casestudyfurama.model.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
