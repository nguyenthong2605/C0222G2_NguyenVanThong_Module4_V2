package com.codegym.demo.service;

import com.codegym.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    Product findById(Integer id);
}
