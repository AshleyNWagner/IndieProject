package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

/**
 * The type Story tag.
 */
@Entity(name = "StoryTag")
@Table(name = "story_tags")
public class StoryTag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Id
    @ManyToOne
    @JoinColumn(name = "story_id", referencedColumnName = "id")
    private Story story;

    @Id
    @ManyToOne
    @JoinColumn(name = "tag_id", referencedColumnName = "id")
    private Tag tag;

    /**
     * Instantiates a new Story tag.
     */
    public StoryTag() {
    }

    /**
     * Instantiates a new Story tag.
     *
     * @param story the story
     * @param tag   the tag
     */
    public StoryTag(Story story, Tag tag) {
        this.story = story;
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
     * Gets story.
     *
     * @return the story
     */
    public Story getStory() {
        return story;
    }

    /**
     * Sets story.
     *
     * @param story the story
     */
    public void setStory(Story story) {
        this.story = story;
    }

    /**
     * Gets tag.
     *
     * @return the tag
     */
    public Tag getTag() {
        return tag;
    }

    /**
     * Sets tag.
     *
     * @param tag the tag
     */
    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "StoryTag{" +
                "id=" + id +
                ", story=" + story.getId() +
                ", tag=" + tag.getId() +
                '}';
    }
}
