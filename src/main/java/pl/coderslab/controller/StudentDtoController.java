package pl.coderslab.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.StudentDTO;
import pl.coderslab.entity.StudentGroup;
import pl.coderslab.repository.StudentGroupRepository;
import pl.coderslab.repository.StudentRepository;

@Controller
@RequestMapping("/student-dto")
public class StudentDtoController {

    private final StudentRepository studentRepository;
    private final StudentGroupRepository studentGroupRepository;

    public StudentDtoController(StudentRepository studentRepository, StudentGroupRepository studentGroupRepository) {
        this.studentRepository = studentRepository;
        this.studentGroupRepository = studentGroupRepository;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("studentDTO", new StudentDTO());
        return "student-dto/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public String perform(@ModelAttribute StudentDTO studentDTO){

        StudentGroup studentGroup = new StudentGroup();
        studentGroup.setName(studentDTO.getGroupName());
        studentGroupRepository.save(studentGroup);

        Student student = new Student();
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getFirstName());
        student.setStudentGroup(studentGroup);

        studentRepository.save(student);
        return ""+ studentDTO;
    }
}
