package com.codgym.casestudyfurama.controller;

import com.codgym.casestudyfurama.model.customer.Customer;
import com.codgym.casestudyfurama.model.facility.Facility;
import com.codgym.casestudyfurama.service.customer.ICustomerService;
import com.codgym.casestudyfurama.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private ICustomerTypeService iCustomerTypeService;
    @GetMapping("")
    public String goToCustomerList(Model model,
                                   @PageableDefault(value = 4) Pageable pageable,
                                   @RequestParam Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("customerList", this.iCustomerService.getAllByKeyWord(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "customer_list";
    }
    @GetMapping("create")
    public String createCustomer(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer_create";
    }

    @PostMapping("save")
    public String save(Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "successfully added new!");
        return "redirect:/customer";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("customer", this.iCustomerService.findById(id));
        model.addAttribute("customerTypeList", this.iCustomerTypeService.findAll());
        return "customer_edit";
    }

    @PostMapping("update")
    public String update(Customer customer, RedirectAttributes redirectAttributes) {
        this.iCustomerService.save(customer);
        redirectAttributes.addFlashAttribute("success", "successful fix");
        return "redirect:/customer";
    }
    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Customer customer = this.iCustomerService.findById(id);
        this.iCustomerService.deleteFacilityById(customer);
        redirectAttributes.addFlashAttribute("success", "successfully!");
        return "redirect:/customer";
    }

}
