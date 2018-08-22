package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.PublisherRepository;

@RequestMapping("/book")
@Controller
public class BookController {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "book/list";
    }

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("publishers", publisherRepository.findAll());
        return "book/add";
    }

    @PostMapping("/add")
    public String performNew(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:list";
    }
}
