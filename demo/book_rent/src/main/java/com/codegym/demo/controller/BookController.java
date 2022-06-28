package com.codegym.demo.controller;

import com.codegym.demo.service.IBookRentService;
import com.codegym.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        List<>
    }
}
