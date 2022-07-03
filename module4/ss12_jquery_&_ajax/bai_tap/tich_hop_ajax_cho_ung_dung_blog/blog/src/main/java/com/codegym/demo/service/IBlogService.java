package com.codegym.demo.service;

import com.codegym.demo.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    Blog findById(Integer id);

    void deleteBlogById(Blog blog);

    Page<Blog> getAllByKeyWord(String keywordVal, Pageable pageable);

    List<Blog> findAllByName(String keyword);
}
