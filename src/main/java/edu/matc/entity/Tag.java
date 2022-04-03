package edu.matc.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.*;

@Entity(name = "Tag")
@Table(name="tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;
    private String tag;

    @OneToMany(mappedBy = "tag", fetch = FetchType.EAGER)
    private Set<StoryTag> stories = new HashSet<>();

}
