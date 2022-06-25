package com.codegym.validateformdangky.controller;

import com.codegym.validateformdangky.dto.UserDto;
import com.codegym.validateformdangky.model.User;
import com.codegym.validateformdangky.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    private IUserService iUserService;

    


    @GetMapping("")
    public String showTableUser(Model model) {
        List<User> userList = iUserService.getAllUser();
        model.addAttribute("userList", userList);
        return "list";
    }

    @GetMapping("/create")
    public String showForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "create";
    }

    @PostMapping("create")
    public String createUser(@ModelAttribute @Validated UserDto userDto,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes,
                             Model model) {

//    new UserDto().validate(userDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";

        } else {
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            iUserService.save(user);
            redirectAttributes.addFlashAttribute("success", "Bạn đã thêm mới thành công!");
            return "redirect:/user";
        }
    }
}
