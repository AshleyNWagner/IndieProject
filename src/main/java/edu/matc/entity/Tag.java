package edu.matc.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

/**
 * The type Tag.
 */
@Entity(name = "Tag")
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String tag;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)
    private Set<Story> stories = new HashSet<>();

    /**
     * Instantiates a new Tag.
     */
    public Tag() {
    }

    /**
     * Instantiates a new Tag.
     *
     * @param tag the tag
     */
    public Tag(String tag) {
        this.tag = tag;
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
     * Gets tag.
     *
     * @return the tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag(String tag) {
        this.tag = tag;
    }

    /**
     * Gets stories.
     *
     * @return the stories
     */
    public Set<Story> getStories() {
        return stories;
    }

    /**
     * Sets stories.
     *
     * @param stories the stories
     */
    public void setStories(Set<Story> stories) {
        this.stories = stories;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag1 = (Tag) o;
        return id == tag1.id && tag.equals(tag1.tag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tag);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tag='" + tag + '\'' +
                '}';
    }
}
