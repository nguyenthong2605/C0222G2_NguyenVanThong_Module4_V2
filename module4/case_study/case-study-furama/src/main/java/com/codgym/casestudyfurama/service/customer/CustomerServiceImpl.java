package com.codgym.casestudyfurama.service.customer;

import com.codgym.casestudyfurama.model.customer.Customer;
import com.codgym.casestudyfurama.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> getAllByKeyWord(String keywordVal, Pageable pageable) {
        return iCustomerRepository.findAllByNameContaining(keywordVal, pageable);
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteFacilityById(Customer customer) {
        this.iCustomerRepository.delete(customer);
    }
}
