package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryRestController {
    @Autowired
    ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<List<Category>> getListCategory() {
        return new ResponseEntity<>(this.iCategoryService.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}/category")
    public ResponseEntity<List<Blog>> getListBlogIdCategory(@PathVariable Integer id) {
        Category category = this.iCategoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category.getBlogList(), HttpStatus.OK);
    }
}
