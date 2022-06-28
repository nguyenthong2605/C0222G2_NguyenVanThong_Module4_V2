package com.codegym.muon_sach.service.impl;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.repository.IBookRepository;
import com.codegym.muon_sach.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository iBookRepository;

    @Override
    public List<Book> getAllBook() {
        return iBookRepository.findAll();
    }

    @Override
    public Book findById(Integer bookId) {
        return iBookRepository.findById(bookId).orElse(null);
    }

    @Override
    public void rent(Book book) {
        book.setQuantity(book.getQuantity() - 1);
        iBookRepository.save(book);
    }

    @Override
    public void back(Book book) {
        book.setQuantity(book.getQuantity() + 1);
        iBookRepository.save(book);
    }
}
