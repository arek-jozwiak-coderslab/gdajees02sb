package pl.coderslab.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.pl.PESEL;
import pl.coderslab.validator.StartWith;
import pl.coderslab.validator.ValidationGroupName;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(min = 5)
    @StartWith(groups = ValidationGroupName.class, value = "a")
    private String title;
    @Min(1)
    @Max(10)
    private double rating;
    @Size(max = 600)
    @StartWith("Super")
    private String description;
    @ManyToOne
    @NonNull
    private Publisher publisher;
    @NotEmpty

    @ManyToMany
    private List<Author> authors;

    @Min(1)
    private int pages;


}
