package com.codegym.productmanegement.service;

import com.codegym.productmanegement.model.Product;
import com.codegym.productmanegement.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Page<Product> getAllByKeyWord(String keywordVal, Pageable pageable) {
        return this.iProductRepository.findAllByNameContaining(keywordVal,pageable);
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return iProductRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Integer id) {
        this.iProductRepository.deleteById(id);
    }
}
