package com.codegym.blog.service;

import com.codegym.blog.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> getAllBlog(String keywordVal, Pageable pageable);

    void save(Blog blog);

    Blog findById(Integer id);

    void deleteById(Blog blog);

    Page<Blog> finAllPaging(Pageable pageable);

//     search(String nameSearch);
}
