package com.codegym.blog.dto;

import com.codegym.blog.model.Category;

import javax.persistence.*;

public class BlogDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String content;

    private String author;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

}
