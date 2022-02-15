package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity(name = "StoryBranch")
@Table(name = "story_branches")
public class StoryBranch {

    @Column(name = "story_id")
    private int storyId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    //@Column(name = "branch_text")
    // private type branchText;

    @Column(name = "excerpt_description")
    private String excerptDescription;

    @Column(name = "choice_one")
    private String choice1;

    @Column(name = "choice_two")
    private String choice2;

}
