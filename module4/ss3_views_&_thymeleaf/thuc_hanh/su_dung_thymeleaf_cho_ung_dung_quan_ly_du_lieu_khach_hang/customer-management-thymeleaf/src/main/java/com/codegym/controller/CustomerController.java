package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.ICustomerService;
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
@RequestMapping("customer")
public class CustomerController {
    @Autowired

    private ICustomerService iCustomerService;

    @GetMapping("")
    public String index(Model model) {
        List<Customer> customerList = this.iCustomerService.findAll();
        model.addAttribute("customers", customerList);
        return "index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        customer.setId((int) Math.random()*10000);
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success","Saved product successfully!");
        return "redirect:/customer";
    }
    @GetMapping("{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("customer", this.iCustomerService.findById(id));
        return "edit";
    }
    @PostMapping("update")
    public String update(Customer customer, RedirectAttributes redirectAttributes){
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "Update product successfully!");
        return "redirect:/customer";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("customer", this.iCustomerService.findById(id));
        return "delete";
    }
    @PostMapping("delete")
    public String delete(Customer customer, RedirectAttributes redirectAttributes){
        this.iCustomerService.remove(customer.getId());
        redirectAttributes.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/customer";
    }
    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("customer", this.iCustomerService.findById(id));
        return "view";
    }
}
