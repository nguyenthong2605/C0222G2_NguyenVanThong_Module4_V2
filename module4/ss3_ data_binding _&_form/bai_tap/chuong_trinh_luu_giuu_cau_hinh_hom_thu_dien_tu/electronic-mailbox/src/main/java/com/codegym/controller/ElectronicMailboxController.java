package com.codegym.controller;

import com.codegym.model.ElectronicMailbox;
import com.codegym.service.IElectronicMailboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ElectronicMailboxController {
    @Autowired
    private IElectronicMailboxService iElectronicMailboxService;

    @GetMapping("home")
    public String goHome(Model model) {
        model.addAttribute("electronicMailbox", new ElectronicMailbox());
        return "home";
    }

    @PostMapping("save")
    public String saveMail(@ModelAttribute ElectronicMailbox electronicMailbox, RedirectAttributes redirectAttributes) {
        this.iElectronicMailboxService.save(electronicMailbox);
        redirectAttributes.addFlashAttribute("msg", "Thành công!");
        return "redirect:/home";
    }
}
