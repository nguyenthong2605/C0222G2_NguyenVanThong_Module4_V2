package com.codegym.validateformdangky.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Integer id;

    @NotBlank(message = "firstname khong co khoang trang")
    @NotNull(message = "firstname khong duoc de null")
    @NotEmpty(message = "firstname khong duoc de trong")
    @Size(min = 5, max = 45)

    private String firstName;

    @NotBlank(message = "firstname khong co khoang trang")
    @NotNull(message = "firstname khong duoc de null")
    @NotEmpty(message = "firstname khong duoc de trong")
    @Size(min = 5, max = 45)
    private String lastName;

    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$")
    @NotEmpty(message = "firstname khong duoc de trong")
    private String phoneNumber;

    @Min(18)
    private Integer age;

    @Email(message = "email không hợp lệ")
    @NotBlank(message = "phải nhập email chứ")
    private String email;

    public UserDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
