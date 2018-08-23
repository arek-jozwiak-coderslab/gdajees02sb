package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

import javax.validation.Valid;

@Controller
@RequestMapping("/author")
public class AuthorController {

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("author", new Author());
        return "author/add";
    }

    @PostMapping("/add")
    public String performNew(Model model, @Valid Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "author/add";
        }
        return "redirect:/author/list";
    }
}
