package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBook();

    Book findById(Integer bookId);

    void rent(Book book);

    void back(Book book);
}
