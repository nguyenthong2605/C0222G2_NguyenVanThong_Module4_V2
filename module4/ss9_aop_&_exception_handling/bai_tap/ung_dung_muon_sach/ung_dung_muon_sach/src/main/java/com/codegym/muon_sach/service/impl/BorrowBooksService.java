package com.codegym.muon_sach.service.impl;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.BorrowBooks;
import com.codegym.muon_sach.repository.IBorrowBooksRepository;
import com.codegym.muon_sach.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BorrowBooksService implements IBorrowBooksService {
    @Autowired
    IBorrowBooksRepository iBorrowBooksRepository;

    @Override
    public Integer create(Book book) {
        Integer random = Math.toIntExact(Math.round(Math.random() * 90000) + 10000);
        iBorrowBooksRepository.save(new BorrowBooks(random, book));
        return random;
    }

    @Override
    public BorrowBooks findById(Integer id) {
        return iBorrowBooksRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id) {
        iBorrowBooksRepository.deleteById(id);
    }
}
