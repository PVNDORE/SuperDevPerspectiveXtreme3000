package beans;

import java.util.*;

/**
 * Class defining a post.
 */
public final class Post extends Entity {
    /**
     * Stores the content of the post.
     */
    private String content;

    /**
     * Stores the date published of the post.
     */
    private Date datePublished;

    /**
     * Stores the user who wrote the post.
     */
    private User author;

    /**
     * Default constructor.
     */
    public Post() {
    }

    /**
     * Post's nearly full filled constructor.
     * @param content The content of the post.
     * @param datePublished The date of the post.
     * @param author The author of the post.
     */
    public Post(String content, Date datePublished, User author) {
        this.content = content;
        this.datePublished = datePublished;
        this.author = author;
    }

    /**
     * Post's full filled constructor.
     * @param id The id of the post.
     * @param content The content of the post.
     * @param datePublished The date of the post.
     * @param author The author of the post.
     */
    public Post(int id, String content, Date datePublished, User author) {
        this.id = id;
        this.content = content;
        this.datePublished = datePublished;
        this.author = author;
    }

    /**
     * Gets the content attribute.
     * @return The content of the post.
     */
    public String getContent() {
        return this.content;
    }

    /**
     * Sets the value of the content attribute.
     * @param content The content to set.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Gets the value of the datePublished attribute.
     * @return The date of the post.
     */
    public Date getDatePublished() {
        return this.datePublished;
    }

    /**
     * Sets the value of the datePublished attribute.
     * @param datePublished The date to set.
     */
    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }

    /**
     * Gets the author attribute.
     * @return The associated user.s
     */
    public User getAuthor() {
        return this.author;
    }

    /**
     * Sets the value of the author attribute.
     * @param author the User to set.
     */
    public void setAuthor(User author) {
        this.author = author;
    }
}