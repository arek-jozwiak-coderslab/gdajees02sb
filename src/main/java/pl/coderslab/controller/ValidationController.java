package pl.coderslab.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@Log
public class ValidationController {

    @Autowired
    Validator validator;


    @GetMapping("/validate")
    @ResponseBody
    public String dummyAdd() {
        //read from file
        Book book = new Book();
        book.setDescription("some desc");
        Set<ConstraintViolation<Book>> validate = validator.validate(book);
        if (!validate.isEmpty()) {

            for (ConstraintViolation<Book> bookConstraintViolation : validate) {
                log.info(bookConstraintViolation.getPropertyPath() + ": " +bookConstraintViolation.getMessage());
            }
        }

        return "-- tt --";
    }
}
