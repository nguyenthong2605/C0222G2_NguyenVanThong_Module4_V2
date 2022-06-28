package com.codegym.muon_sach.service;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.BorrowBooks;

public interface IBorrowBooksService {
    Integer create(Book book);

    BorrowBooks findById(Integer id);

    void deleteById(Integer id);
}
