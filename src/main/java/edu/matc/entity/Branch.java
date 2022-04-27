package edu.matc.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Story branch.
 */
@Entity(name = "Branch")
@Table(name = "branches")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "branch_text")
    private String branchText;

    @Column(name = "branch_description")
    private String branchDescription;

    @Column(name = "choice_ids")
    private String choiceIds;

    @ManyToOne
    private Story story;


    /**
     * Instantiates a new Story branch.
     */
    public Branch() {

    }


    /**
     * Instantiates a new Branch.
     *
     * @param branchText        the branch text
     * @param branchDescription the branch description
     * @param story             the story
     */
    public Branch(String branchText, String branchDescription, Story story) {

        this.branchText = branchText;
        this.branchDescription = branchDescription;
        this.choiceIds = "";
        this.story = story;
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
     * Gets branch text.
     *
     * @return the branch text
     */
    public String getBranchText() {
        return branchText;
    }

    /**
     * Sets branch text.
     *
     * @param branchText the branch text
     */
    public void setBranchText(String branchText) {
        this.branchText = branchText;
    }

    /**
     * Gets branch description.
     *
     * @return the branch description
     */
    public String getBranchDescription() {
        return branchDescription;
    }

    /**
     * Sets branch description.
     *
     * @param branchDescription the branch description
     */
    public void setBranchDescription(String branchDescription) {
        this.branchDescription = branchDescription;
    }

    /**
     * Gets choice ids.
     *
     * @return the choice ids
     */
    public String getChoiceIds() {
        return choiceIds;
    }

    /**
     * Sets choice ids.
     *
     * @param choiceIds the choice ids
     */
    public void setChoiceIds(String choiceIds) {
        this.choiceIds = choiceIds;
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

    public void addChoiceId(String choiceId) {
        choiceIds += choiceId + "&";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return id == branch.id &&
                Objects.equals(branchText, branch.branchText) &&
                Objects.equals(branchDescription, branch.branchDescription) &&
                Objects.equals(choiceIds, branch.choiceIds) &&
                Objects.equals(story, branch.story);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, branchText, branchDescription, choiceIds, story);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", branchText='" + branchText + '\'' +
                ", branchDescription='" + branchDescription + '\'' +
                ", choiceIds='" + choiceIds + '\'' +
                ", story=" + story +
                '}';
    }
}