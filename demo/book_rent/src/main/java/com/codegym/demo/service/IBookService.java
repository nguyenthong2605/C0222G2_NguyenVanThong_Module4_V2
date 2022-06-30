package com.codegym.demo.service;

import com.codegym.demo.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
}
