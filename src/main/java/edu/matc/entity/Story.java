package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;
import java.time.*;
import javax.persistence.*;

@Entity(name = "Story")
@Table(name = "stories")
public class Story {

    private String title;

    private String author;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "date_created")
    private LocalDate dateCreated;


}
