package com.codgym.casestudyfurama.repository.customer;

import com.codgym.casestudyfurama.model.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
}
