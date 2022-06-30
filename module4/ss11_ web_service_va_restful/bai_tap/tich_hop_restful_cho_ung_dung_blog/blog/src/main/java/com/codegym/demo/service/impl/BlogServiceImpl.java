package com.codegym.demo.service.impl;

import com.codegym.demo.model.Blog;
import com.codegym.demo.repository.IBlogRepository;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository iBlogRepository;
    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
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
    public void deleteBlogById(Blog blog) {
        iBlogRepository.delete(blog);
    }

    @Override
    public Page<Blog> getAllByKeyWord(String keywordVal, Pageable pageable) {
        return this.iBlogRepository.findAllByNameContaining(keywordVal,pageable);
    }


}
