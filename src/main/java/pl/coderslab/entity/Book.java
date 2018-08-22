package pl.coderslab.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    @ManyToOne
    private Publisher publisher;


}
