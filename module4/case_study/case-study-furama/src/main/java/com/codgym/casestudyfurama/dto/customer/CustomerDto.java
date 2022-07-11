package com.codgym.casestudyfurama.dto.customer;

import com.codgym.casestudyfurama.model.contract.Contract;
import com.codgym.casestudyfurama.model.customer.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class CustomerDto implements Validator {
    private Integer id;

    private CustomerType customerType;

    @NotBlank(message = "Name is blank")
    private String name;

    private String dateOfBirth;

    private String gender;

    @NotBlank(message = "Id Card is blank")
    private String idCard;

    @NotBlank(message = "Id Card is blank")
    private String phoneNumber;

    @NotBlank(message = "Id Card is blank")
    private String email;

    @NotBlank(message = "Id Card is blank")
    private String address;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
