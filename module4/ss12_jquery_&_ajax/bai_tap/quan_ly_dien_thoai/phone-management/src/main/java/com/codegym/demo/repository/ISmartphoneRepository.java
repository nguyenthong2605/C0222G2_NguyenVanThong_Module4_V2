package com.codegym.demo.repository;

import com.codegym.demo.model.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
