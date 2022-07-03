package com.codegym.blog.service.impl;

import com.codegym.blog.model.Blog;
import com.codegym.blog.repository.IBlogRepository;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> getAllBlog(String keywordVal, Pageable pageable) {
        return iBlogRepository.findAllByNameContaining(keywordVal, pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog);
    }

    @Override
    public Blog findById(Integer id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public Page<Blog> finAllPaging(Pageable pageable) {
        return iBlogRepository.findAll(pageable);
    }
}
