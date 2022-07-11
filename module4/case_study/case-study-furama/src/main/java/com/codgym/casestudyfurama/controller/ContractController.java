package com.codgym.casestudyfurama.controller;

import com.codgym.casestudyfurama.model.contract.AttachFacility;
import com.codgym.casestudyfurama.model.contract.Contract;
import com.codgym.casestudyfurama.model.contract.ContractDetail;
import com.codgym.casestudyfurama.service.contract.IAttachFacilityService;
import com.codgym.casestudyfurama.service.contract.IContractDetailService;
import com.codgym.casestudyfurama.service.contract.IContractService;
import com.codgym.casestudyfurama.service.customer.ICustomerService;
import com.codgym.casestudyfurama.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;

    @Autowired
    private IContractDetailService iContractDetailService;

    @Autowired
    private IAttachFacilityService iAttachFacilityService;

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private IFacilityService iFacilityService;

    @ModelAttribute("attachFacilityList")
    public List<AttachFacility> getAllAF() {
        return this.iAttachFacilityService.findAll();
    }

    @GetMapping("")
    public String goToContractList(Model model,
                                   @PageableDefault(value = 4) Pageable pageable,
                                   @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        model.addAttribute("contractList", this.iContractService.getAllByKeyWord(pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "contract_list";
    }

    @GetMapping("createContract")
    public String createContract(Model model) {
        model.addAttribute("contract", new Contract());
        model.addAttribute("contractDetail", new ContractDetail());
        model.addAttribute("facilityList", this.iFacilityService.findAll());
        model.addAttribute("customerList", this.iCustomerService.findAll());
        model.addAttribute("attachFacilityList", this.iAttachFacilityService.findAll());
        return "contract_create";
    }

//    @PostMapping("save")
//    public String saveContract(Contract contract) {
//        this.iContractService.save(contract);
//        return "contract_list1";
//    }

}
