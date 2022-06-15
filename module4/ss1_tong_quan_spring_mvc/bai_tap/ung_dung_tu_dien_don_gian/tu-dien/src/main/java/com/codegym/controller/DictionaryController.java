package com.codegym.controller;

import com.codegym.service.IDictionaryService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private IDictionaryService iDictionaryService;

    @GetMapping("/home")
    public String goHome() {
        return "home";
    }
    @GetMapping("/dictionary")
    public String translate(@RequestParam String search, Model model){
        model.addAttribute("result", this.iDictionaryService.translateDictionary(search));
        return "home";
    }
}
