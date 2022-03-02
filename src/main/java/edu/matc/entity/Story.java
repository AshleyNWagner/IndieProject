package edu.matc.entity;

//TODO add constructors

import org.hibernate.annotations.GenericGenerator;
import java.time.*;
import java.util.*;
import javax.persistence.*;

/**
 * The type Story.
 */
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

    /**
     * Instantiates a new Story.
     */
    public Story() {

    }

    /**
     * Instantiates a new Story.
     *
     * @param title       the title
     * @param description the description
     * @param user        the user
     */
// TODO add image?
    public Story(String title, String description, User user) {
        this.title = title;
        this.description = description;
        this.user = user;
        setDateCreated(LocalDate.now());

    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets date created.
     *
     * @return the date created
     */
    public LocalDate getDateCreated() {
        return dateCreated;
    }

    /**
     * Sets date created.
     *
     * @param dateCreated the date created
     */
    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return id == story.id && Objects.equals(title, story.title) &&
                Objects.equals(description, story.description) &&
                Objects.equals(user, story.user) &&
                Objects.equals(dateCreated, story.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, user, dateCreated);
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", user=" + user +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
