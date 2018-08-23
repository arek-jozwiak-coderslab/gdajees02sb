package pl.coderslab.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repository.BookRepository;
import pl.coderslab.repository.PublisherRepository;
import pl.coderslab.validator.ValidationGroupName;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@RequestMapping("/book")
@Controller
@Log
public class BookController {
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;


    @Autowired
    Validator validator;

    public BookController(BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @GetMapping("/dummy-add")
    @ResponseBody
    public String dummyAdd() {
        //read from file
        Book book = new Book();
        book.setDescription("some desc");
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        if (validate.isEmpty()) {
            bookRepository.save(book);
        }else{
            for (ConstraintViolation<Book> bookConstraintViolation : validate) {
                log.info(bookConstraintViolation.getPropertyPath() + ": " +bookConstraintViolation.getMessage());
            }
        }

        return "-- tt --";
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
    public String performNew(Model model, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherRepository.findAll());
            return "book/add";
        }
        bookRepository.save(book);
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        bookRepository.delete(id);
        return "redirect:/book/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("book", bookRepository.findOne(id));
        model.addAttribute("publishers", publisherRepository.findAll());
        return "book/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid Book book, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("publishers", publisherRepository.findAll());
            return "book/edit";
        }
        bookRepository.save(book);
        return "redirect:/book/list";
    }
}
