package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.time.*;
import java.util.*;
import javax.persistence.*;

/**
 * The type Story.
 */
@Entity(name = "Story")
@Table(name = "stories")
public class Story implements Serializable {

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

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(name= "story_tags",
        joinColumns = @JoinColumn(name = "story_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private Set<Tag> tags = new HashSet<>();

//  https://vladmihalcea.com/the-best-way-to-use-the-manytomany-annotation-with-jpa-and-hibernate/

    @OneToMany(mappedBy = "story", fetch = FetchType.EAGER)
    private List<Branch> branches = new ArrayList<>();

    // TODO decide if you're including images

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
    // TODO figure out user stuff
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

    /**
     * Gets tags.
     *
     * @return the tags
     */
    public Set<Tag> getTags() {
        return tags;
    }

    /**
     * Sets tags.
     *
     * @param tags the tags
     */
    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    /**
     * Gets branches.
     *
     * @return the branches
     */
    public List<Branch> getBranches() {
        return branches;
    }

    /**
     * Sets branches.
     *
     * @param branches the branches
     */
    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    /**
     * Add tag.
     *
     * @param tag the tag
     */
    public void addTag(Tag tag) {
        tags.add(tag);
        tag.getStories().add(this);
    }

    /**
     * Add branch.
     *
     * @param branch the branch
     */
    public void addBranch(Branch branch) {
        branches.add(branch);
        branch.setStory(this);
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
