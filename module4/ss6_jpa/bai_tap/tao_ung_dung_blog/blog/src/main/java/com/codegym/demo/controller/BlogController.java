package com.codegym.demo.controller;

import com.codegym.demo.model.Blog;
import com.codegym.demo.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("")
    public String getList(Model model) {
        List<Blog> blogList = this.iBlogService.findAll();
        model.addAttribute("blogList", blogList);
        return "list";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
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
