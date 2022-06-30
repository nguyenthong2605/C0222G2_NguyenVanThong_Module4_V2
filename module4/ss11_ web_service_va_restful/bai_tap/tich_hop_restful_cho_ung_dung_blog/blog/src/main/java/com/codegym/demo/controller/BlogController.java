package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.IBlogService;
import com.codegym.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("")
    public String getList(Model model,
                          @PageableDefault(value = 4) Pageable pageable,
                          @RequestParam Optional<String> keyword){
        String keywordVal = keyword.orElse("");
        model.addAttribute("blogList", this.iBlogService.getAllByKeyWord(keywordVal, pageable));
        model.addAttribute("keywordVal", keywordVal);
        return "list";
    }

//    @GetMapping("")
//    public String getList(Model model) {
//        List<Blog> blogList = this.iBlogService.findAll();
//        model.addAttribute("blogList", blogList);
//        return "list";
//    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "create";
    }

    @PostMapping("save")
    public String save(Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "successfully added new!");
        return "redirect:/blog";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "edit";
    }

    @PostMapping("update")
    public String update(Blog blog, RedirectAttributes redirectAttributes) {
        this.iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "successful fix");
        return "redirect:/blog";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", this.iBlogService.findById(id));
        model.addAttribute("categoryList", this.iCategoryService.findAll());
        return "view";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
        Blog blog = this.iBlogService.findById(id);
        this.iBlogService.deleteBlogById(blog);
        redirectAttributes.addFlashAttribute("success", "successfully!");
        return "redirect:/blog";
    }
}
