package com.codegym.demo.controller;

import com.codegym.demo.model.Book;
import com.codegym.demo.service.IBookRentService;
import com.codegym.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private IBookService iBookService;

    @Autowired
    private IBookRentService iBookRentService;

    @GetMapping("")
    public String list(Model model){
        List<Book> bookList = iBookService.findAll();
        model.addAttribute("bookList", bookList);
        return "list";
    }
    @GetMapping("{id}/view")
public String view(@PathVariable Integer id, Model model){
        model.addAttribute("book", this.iBookService.findById(id));
    }
}
