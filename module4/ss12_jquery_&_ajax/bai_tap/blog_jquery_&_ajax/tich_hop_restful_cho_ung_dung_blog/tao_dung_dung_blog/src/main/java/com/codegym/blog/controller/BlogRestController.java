package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/blog")
public class BlogRestController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public ResponseEntity<Page<Blog>> getPageBlog(
            @PageableDefault(value = 3) Pageable pageable,
            @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        System.out.println(keywordVal);
        Page<Blog> blogPage = this.iBlogService.getAllBlog(keywordVal, pageable);
        if (!blogPage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("{id}/blog")
    public ResponseEntity<Blog> getBlogById(@PathVariable Integer id) {
        Blog blog = this.iBlogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
//    @PostMapping
//    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog){
//        return new ResponseEntity<>(iBlogService.save(blog), HttpStatus.CREATED);
//    }
}
