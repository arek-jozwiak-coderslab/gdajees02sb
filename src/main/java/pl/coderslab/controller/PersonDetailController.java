package pl.coderslab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.PersonDTO;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.StudentDTO;
import pl.coderslab.entity.StudentGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("/person-dto")
public class PersonDetailController {

    @ModelAttribute("skills")
    public List<String> skills() {
        List<String> skills = new ArrayList<>();
        skills.add( "Java");
        skills.add( "PHP");
        skills.add( "Ruby");
        return skills;
    }
    @ModelAttribute("hobbies")
    public List<String> hobbies() {
        List<String> skills = new ArrayList<>();
        skills.add( "programing Java");
        skills.add( "programing PHP");
        skills.add( "programing Ruby");
        return skills;
    }

    public List<String> countryItems() {
        List<String> skills = new ArrayList<>();
        skills.add( "country Java");
        skills.add( "country PHP");
        skills.add( "country Ruby");
        return skills;
    }


    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("countryItems" ,this.countryItems());
        model.addAttribute("personDTO", new PersonDTO());
        return "person-dto/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String perform(@ModelAttribute PersonDTO personDTO){

        return ""+ personDTO;
    }
}
