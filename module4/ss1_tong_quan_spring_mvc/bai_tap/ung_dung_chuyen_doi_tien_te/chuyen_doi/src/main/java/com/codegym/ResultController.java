package com.codegym;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class ResultController {
    @GetMapping("/result")
    public String result(@RequestParam int usd, Model model){
        int vnd = usd*24000;
        model.addAttribute("vnd", vnd);
        return "result";
    }
}
