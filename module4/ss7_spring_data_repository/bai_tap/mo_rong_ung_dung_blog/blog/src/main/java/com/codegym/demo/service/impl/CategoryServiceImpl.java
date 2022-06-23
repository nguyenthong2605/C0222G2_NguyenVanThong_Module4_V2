package com.codegym.demo.service.impl;

import com.codegym.demo.model.Category;
import com.codegym.demo.repository.IBlogRepository;
import com.codegym.demo.repository.ICategoryRepository;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }
}
