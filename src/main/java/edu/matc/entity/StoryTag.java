package edu.matc.entity;


import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

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


}
