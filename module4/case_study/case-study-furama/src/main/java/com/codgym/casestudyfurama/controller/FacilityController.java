package com.codgym.casestudyfurama.controller;

import com.codgym.casestudyfurama.model.facility.Facility;
import com.codgym.casestudyfurama.service.facility.IFacilityService;
import com.codgym.casestudyfurama.service.facility.IFacilityTypeService;
import com.codgym.casestudyfurama.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("facility")
public class FacilityController {
    @Autowired
    private IFacilityService iFacilityService;
    @Autowired
    private IFacilityTypeService iFacilityTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;
    @GetMapping("")
    public String goToFacilityList(Model model,
                                   @PageableDefault(value = 4) Pageable pageable,
                                   @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("facilityList", this.iFacilityService.getAllByKeyWord(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "facility_list";
    }
    @GetMapping("create")
    public String createFacility(Model model){
        model.addAttribute("facility", new Facility());
        model.addAttribute("facilityTypeList", this.iFacilityTypeService.findAll());
        model.addAttribute("rentTypeList", this.iRentTypeService.findAll());
        return "facility_create";
    }
}
