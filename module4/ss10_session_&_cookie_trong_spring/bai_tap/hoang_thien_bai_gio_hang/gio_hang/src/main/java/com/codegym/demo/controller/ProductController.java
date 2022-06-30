package com.codegym.demo.controller;

import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private IProductService iProductService;
    @GetMapping("")
    public String listProduct(Model model){
        List<Product> productList = this.iProductService.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }
}
