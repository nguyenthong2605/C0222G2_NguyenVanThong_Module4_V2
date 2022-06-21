package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @GetMapping("")
    public String list(Model model) {
        List<Product> productList = this.iProductService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product, RedirectAttributes redirectAttributes) {
        System.out.println(product.getName());
        iProductService.save(product);
        redirectAttributes.addFlashAttribute("success", "Bạn đã thêm mới thành công!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, RedirectAttributes redirectAttributes) {
        iProductService.update(product.getId(), product);
        redirectAttributes.addFlashAttribute("success", "Bạn đã sửa thành công!");
        return "redirect:/product";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirectAttributes) {
        iProductService.remove(product.getId());
        redirectAttributes.addFlashAttribute("success", "Bạn đã xóa thành công!");
        return "redirect:/product";
    }
//
//    @GetMapping("/{id}/view")
//    public String view(@PathVariable int id, Model model) {
//        model.addAttribute("product", iProductService.findById(id));
//        return "view";
//    }
//    @GetMapping("/search")
//    public String search(@RequestParam String name, Model model){
//        model.addAttribute("product", iProductService.search(name));
//        return "redirect:/product";
//    }
}
