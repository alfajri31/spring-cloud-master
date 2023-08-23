package com.cantimapp.adm.controller;

import com.cantimapp.adm.model.Book;
import com.cantimapp.adm.service.IBookService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@NoArgsConstructor
@RequestMapping("/book")
public class BookController {

    @Autowired
    private IBookService IBookService;


    @GetMapping("/view")
    public String viewBooks(Model model) {
        model.addAttribute("books", IBookService.getBooks());
        return "view-books";
    }

    @GetMapping("/addBook")
    public String addBookView(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

//    @PostMapping("/addBook")
//    public RedirectView addBook(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
//        final RedirectView redirectView = new RedirectView("/book/addBook", HttpStatusCode.valueOf(200));
//        Book savedBook = IBookService.addBook(book);
//        redirectAttributes.addFlashAttribute("savedBook", savedBook);
//        redirectAttributes.addFlashAttribute("addBookSuccess", true);
//        return redirectView;
//    }

}
