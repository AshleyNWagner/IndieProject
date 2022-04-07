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

    @Column(name = "story_id")
    private int storyId;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "branch_text")
    private String branchText;

    @Column(name = "branch_description")
    private String branchDescription;

    @Column(name = "choice_one")
    private String choice1;

    @Column(name = "choice_two")
    private String choice2;

    /**
     * Instantiates a new Story branch.
     */
    public Branch() {

    }

    /**
     * Instantiates a new Story branch.
     *
     * @param storyId           the story id
     * @param branchText        the branch text
     * @param branchDescription the branch description
     * @param choice1           the choice 1
     * @param choice2           the choice 2
     */
    public Branch(int storyId, String branchText, String branchDescription, String choice1, String choice2) {
        this.storyId = storyId;
        this.branchText = branchText;
        this.branchDescription = branchDescription;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    /**
     * Gets story id.
     *
     * @return the story id
     */
    public int getStoryId() {
        return storyId;
    }

    /**
     * Sets story id.
     *
     * @param storyId the story id
     */
    public void setStoryId(int storyId) {
        this.storyId = storyId;
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
     * Gets choice 1.
     *
     * @return the choice 1
     */
    public String getChoice1() {
        return choice1;
    }

    /**
     * Sets choice 1.
     *
     * @param choice1 the choice 1
     */
    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    /**
     * Gets choice 2.
     *
     * @return the choice 2
     */
    public String getChoice2() {
        return choice2;
    }

    /**
     * Sets choice 2.
     *
     * @param choice2 the choice 2
     */
    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch that = (Branch) o;
        return storyId == that.storyId && id == that.id &&
                Objects.equals(branchText, that.branchText) &&
                Objects.equals(branchDescription, that.branchDescription) &&
                Objects.equals(choice1, that.choice1) &&
                Objects.equals(choice2, that.choice2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storyId, id, branchText, branchDescription, choice1, choice2);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "storyId=" + storyId +
                ", id=" + id +
                ", branchText='" + branchText + '\'' +
                ", branchDescription='" + branchDescription + '\'' +
                ", choice1='" + choice1 + '\'' +
                ", choice2='" + choice2 + '\'' +
                '}';
    }
}