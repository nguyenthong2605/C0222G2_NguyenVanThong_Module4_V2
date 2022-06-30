package com.codegym.demo.controller;

import com.codegym.demo.model.Product;
import com.codegym.demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
@SessionAttributes(value = {"productAddList"})
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute(value = "productAddList")
    public List<Product> createProductAddList(){
        return new ArrayList<>();
    }
    @GetMapping("")
    public String listProduct(Model model) {
        List<Product> productList = this.iProductService.findAll();
        model.addAttribute("productList", productList);
        return "home";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        return "view";
    }

    @GetMapping("/{id}/add")
    public String addProduct(@PathVariable Integer id, RedirectAttributes redirectAttributes,
                             @SessionAttribute List<Product> productAddList) {
        Product productObj = this.iProductService.findById(id);
        productAddList.add(productObj);
        redirectAttributes.addFlashAttribute("msg", "Đã thêm " + productObj.getName() + " vào giỏ hàng thành công!");
        return "redirect:/product/{id}/view";
    }
}
