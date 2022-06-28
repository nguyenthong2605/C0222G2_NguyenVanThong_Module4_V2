package com.codegym.muon_sach.model;

import javax.persistence.*;

@Entity
public class BorrowBooks {
    @Id
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "bookId", referencedColumnName = "bookId")
    private Book book;

    public BorrowBooks(Integer id, Book book) {
        this.id = id;
        this.book = book;
    }

    public BorrowBooks() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
