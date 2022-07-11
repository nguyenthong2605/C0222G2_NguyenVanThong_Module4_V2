package com.codgym.casestudyfurama.controller;

import com.codgym.casestudyfurama.model.employee.Employee;
import com.codgym.casestudyfurama.service.employee.IDivisionService;
import com.codgym.casestudyfurama.service.employee.IEducationDegreeService;
import com.codgym.casestudyfurama.service.employee.IEmployeeService;
import com.codgym.casestudyfurama.service.employee.IPosotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/api/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IEducationDegreeService iEducationDegreeService;
    @Autowired
    private IPosotionService iPosotionService;
    @GetMapping("")
    public ResponseEntity<Page<Employee>> getPageEmployee(
            @PageableDefault(value = 3) Pageable pageable,
            @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        System.out.println(keywordVal);
        Page<Employee> employeePage = this.iEmployeeService.getAllEmployee(keywordVal, pageable);
        if (!employeePage.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }
}
