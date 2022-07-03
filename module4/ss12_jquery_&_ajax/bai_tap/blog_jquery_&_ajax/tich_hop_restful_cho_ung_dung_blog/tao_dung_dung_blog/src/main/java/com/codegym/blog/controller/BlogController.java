package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import com.codegym.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String listBlog(Model model,
                           @PageableDefault(value = 6, sort = "name") Pageable pageable,
                           @RequestParam Optional<String> keyword) {
        String keywordVal = keyword.orElse("");
        Page<Blog> blogList = iBlogService.getAllBlog(keywordVal, pageable);
        model.addAttribute("blogList", blogList);
        model.addAttribute("keywordVal", keywordVal);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        iBlogService.save(blog);
        redirectAttributes.addFlashAttribute("success", "Bạn đã thêm mới thành công!");
        return "redirect:/blog";
    }

    @GetMapping("{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        model.addAttribute("categoryList", iCategoryService.findAll());
        return "edit";
    }

//    @PostMapping("/update")
//    public String update(@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
//        iBlogService.save(blog);
//        redirectAttributes.addFlashAttribute("success", "Bạn đã sửa thành công!");
//        return "redirect:/blog";
//    }

    @PostMapping("/delete")
    public String delete(@RequestParam Integer blogId, RedirectAttributes redirectAttributes) {
        Blog blog = this.iBlogService.findById(blogId);
        System.out.println(blog);
        iBlogService.deleteById(blog);
        redirectAttributes.addFlashAttribute("success", "Bạn đã xóa thành công!");
        return "redirect:/blog";
    }
//    @GetMapping("/search")
//    public String searchBlog(@RequestParam String nameSearch, Model model ){
//        model.addAttribute("blogList", iBlogService.search(nameSearch));
//        return "list";
//    }

}
