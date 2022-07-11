package com.codgym.casestudyfurama.controller;

import com.codgym.casestudyfurama.service.employee.IDivisionService;
import com.codgym.casestudyfurama.service.employee.IEducationDegreeService;
import com.codgym.casestudyfurama.service.employee.IEmployeeService;
import com.codgym.casestudyfurama.service.employee.IPosotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IPosotionService iPosotionService;
    @GetMapping("")
    public String goToEmployeeList(){
        return "employee_list";
    }
}
