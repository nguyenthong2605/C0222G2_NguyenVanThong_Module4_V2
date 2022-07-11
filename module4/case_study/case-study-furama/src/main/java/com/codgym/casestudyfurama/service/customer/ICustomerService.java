package com.codgym.casestudyfurama.service.customer;

import com.codgym.casestudyfurama.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> getAllByKeyWord(String keywordVal, Pageable pageable);

    void save(Customer customer);

    Customer findById(Integer id);

    void deleteFacilityById(Customer customer);

    List<Customer> findAll();
}
