package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("product")
public class ProductController {
    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String list(Model model) {
        List<Product> productList = this.iProductService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        product.setId((int) (Math.random() * 1000));
        this.iProductService.save(product);
        redirectAttributes.addFlashAttribute("success", "successfully added new!");
        return "redirect:/product";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("product", this.iProductService.findById(id));
        System.out.println(this.iProductService.findById(id));
        return "edit";
    }

    @PostMapping("update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        this.iProductService.update(product.getId(),product);
        redirectAttributes.addFlashAttribute("success", "successful fix");
        return "redirect:/product";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, Model model){
        model.addAttribute("product", this.iProductService.findById(id));
        return "delete";
    }
    @PostMapping("delete")
    public String delete(Product product, RedirectAttributes redirectAttributes){
        this.iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Removed product successfully!");
        return "redirect:/product";
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute("product", this.iProductService.findById(id));
        return "view";
    }
}
