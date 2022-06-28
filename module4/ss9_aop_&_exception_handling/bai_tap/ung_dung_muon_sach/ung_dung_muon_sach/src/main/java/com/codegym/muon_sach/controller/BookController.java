package com.codegym.muon_sach.controller;

import com.codegym.muon_sach.model.Book;
import com.codegym.muon_sach.model.BorrowBooks;
import com.codegym.muon_sach.service.IBookService;
import com.codegym.muon_sach.service.IBorrowBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/book")

public class BookController {
    @Autowired
    IBookService iBookService;

    @Autowired
    IBorrowBooksService iBorrowBooksService;

    @GetMapping("")
    public String listBook(Model model) {
        List<Book> bookList = iBookService.getAllBook();
        model.addAttribute("bookList", bookList);
        return "list";
    }

    @GetMapping("{bookId}/rent")
    public String rentBookShow(@PathVariable Integer bookId, RedirectAttributes redirectAttributes) {
        Book book = iBookService.findById(bookId);
        if (book != null && book.getQuantity() > 0) {
            iBookService.rent(book);
            Integer idBorrowBooks = iBorrowBooksService.create(book);
            redirectAttributes.addFlashAttribute("success", "Bạn đã mượn thành công!" + " Với mã mượn là: " + idBorrowBooks);
            return "redirect:/book";
        } else {
            redirectAttributes.addFlashAttribute("message", "Báo lỗi");
            return "redirect:/book";
        }
    }

    @PostMapping("/giveBack")
    public String giveBackShow(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        BorrowBooks borrowBooks = this.iBorrowBooksService.findById(id);
        iBookService.back(borrowBooks.getBook());
        iBorrowBooksService.deleteById(id);
        redirectAttributes.addFlashAttribute("success", "Bạn đã trả thành công!");
        return "redirect:/book";
    }

}
