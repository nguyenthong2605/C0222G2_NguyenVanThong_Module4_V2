package com.codegym.demo.model;

import javax.persistence.*;

@Entity
public class BookRent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    @Column(name = "book_code")
    private Integer bookCode;

    public BookRent() {
    }

    public BookRent(Integer id, Book book, Integer bookCode) {
        this.id = id;
        this.book = book;
        this.bookCode = bookCode;
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

    public Integer getBookCode() {
        return bookCode;
    }

    public void setBookCode(Integer bookCode) {
        this.bookCode = bookCode;
    }
}
