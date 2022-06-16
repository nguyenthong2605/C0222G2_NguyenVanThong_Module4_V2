package com.codegym.service.impl;

import com.codegym.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public String Calculator(Double soHangDau, Double soHangSau, String calculator) {
        String result = null;
        String massage = "không thể chia 1 số cho 0";
        switch (calculator) {
            case "+":
                result = String.valueOf(soHangDau + soHangSau);
                break;
            case "-":
                result = String.valueOf(soHangDau - soHangSau);
                break;
            case "*":
                result = String.valueOf(soHangDau * soHangSau);
                break;
            case "/":
                if (soHangSau != 0) {
                    result = String.valueOf(soHangDau / soHangSau);
                } else {
                    result = massage;
                }
                break;
            default:
                break;
        }
        return result;
    }
}
