package com.codegym.controller;

import com.codegym.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {

    @Autowired
    private ICalculatorService iCalculatorService;

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/calculator")
    public String goCalculator(@RequestParam String calculator, @RequestParam Double numberOne, @RequestParam Double numberTwo, Model model) {
        model.addAttribute("result", this.iCalculatorService.Calculator(numberOne, numberTwo, calculator));
        return "home";
    }

}
