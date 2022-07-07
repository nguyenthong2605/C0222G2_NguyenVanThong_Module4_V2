package com.codgym.casestudyfurama.repository.customer;

import com.codgym.casestudyfurama.model.customer.Customer;
import com.codgym.casestudyfurama.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);

}
