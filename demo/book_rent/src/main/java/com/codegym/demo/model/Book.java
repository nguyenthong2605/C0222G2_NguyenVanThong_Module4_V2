package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    private Integer amount;

    @OneToMany(mappedBy = "book")
    private List<BookRent> bookRentList;

    public Book() {
    }

    public Book(Integer id, String name, String author, Integer amount, List<BookRent> bookRentList) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.amount = amount;
        this.bookRentList = bookRentList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public List<BookRent> getBookRentList() {
        return bookRentList;
    }

    public void setBookRentList(List<BookRent> bookRentList) {
        this.bookRentList = bookRentList;
    }
}
