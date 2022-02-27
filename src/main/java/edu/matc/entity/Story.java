package edu.matc.entity;

//TODO add constructors

import org.hibernate.annotations.GenericGenerator;
import java.time.*;
import java.util.*;
import javax.persistence.*;

@Entity(name = "Story")
@Table(name = "stories")
public class Story {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String title;

    private String description;

    @ManyToOne
    private User user;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    // TODO figure out what you're doing for these things
    // Set<String> tags = HashSet<>();
    // SomeType image = something

    public Story() {

    }

    // TODO add image
    public Story(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
        setDateCreated(LocalDate.now());

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }
}
