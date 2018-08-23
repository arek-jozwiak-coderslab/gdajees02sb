package pl.coderslab.entity;

import lombok.Data;
import pl.coderslab.validator.YearOfBirth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    @YearOfBirth
    private Integer yearOfBirth;
}
