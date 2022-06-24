package com.codegym.productmanegement.service;

import com.codegym.productmanegement.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService {
    Page<Product> getAllByKeyWord(String keywordVal, Pageable pageable);

    void save(Product product);

    Product findById(Integer id);

    void remove(Integer id);
}
