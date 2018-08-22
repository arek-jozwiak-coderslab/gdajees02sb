package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Student;
import pl.coderslab.repository.PersonRepository;

@Controller
@RequestMapping("/person")
public class PersonController {
    private final PersonRepository personRepository;

    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/add-old")
    public String add(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/add-old")
    @ResponseBody
    public String performOld(@RequestParam String login,
                             @RequestParam String password,
                             @RequestParam String email
    ) {
        Person person = new Person();
        person.setEmail(email);
        person.setLogin(login);
        person.setPassword(password);
        personRepository.save(person);
        return "--added-old-";
    }

    @GetMapping("/add-new")
    public String addNew(Model model) {
        model.addAttribute("person", new Person());
        return "person/add";
    }

    @PostMapping("/add-new")
    @ResponseBody
    public String performNew(@ModelAttribute Person person) {
        personRepository.save(person);
        return "--added-new-";
    }

}
