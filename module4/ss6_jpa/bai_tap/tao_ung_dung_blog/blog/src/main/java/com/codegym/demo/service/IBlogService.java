package com.codegym.demo.service;

import com.codegym.demo.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void deleteBlogById(Blog blog);
}
