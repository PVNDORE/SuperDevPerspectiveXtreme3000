package beans;

import java.util.*;

/**
 * Class representing a discussion.
 */
public final class Discussion extends Entity {
    /**
     * Stores the discussion title.
     */
    private String title;

    /**
     * Stores the status of the discussion.
     */
    private Status status;

    /**
     * Stores the discussion's list of post.
     */
    private List<Post> posts;

    /**
     * Stores the discussion topic id.
     */
    private int topicId;

    /**
     * Default constructor.
     */
    public Discussion() {
    }

    /**
     * Discussion's nearly full filled constructor.
     * @param title The title to set.
     * @param status The status to set.
     * @param posts The list of post to set.
     * @param topicId The id of the topic.
     */
    public Discussion(String title, Status status, List<Post> posts, int topicId) {
        this.title = title;
        this.status = status;
        this.posts = posts;
        this.topicId = topicId;
    }

    /**
     * Discussion's full filled constructor.
     * @param id The id to set.
     * @param title The title to set.
     * @param status The status to set.
     * @param posts The list of post to set.
     * @param topicId The id of the topic.
     */
    public Discussion(int id, String title, Status status, List<Post> posts, int topicId) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.posts = posts;
        this.topicId = topicId;
    }

    /**
     * Gets the value of the title attribute.
     * @return The title of the discussion.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Sets the value of the title attribute.
     * @param title The new title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the value of the status attribute.
     * @return The discussion's status.
     */
    public Status getStatut() {
        return this.status;
    }

    /**
     * Sets the value of the status attribute.
     * @param status The status to set.
     */
    public void setStatut(Status status) {
        this.status = status;
    }

    /**
     * Gets the posts attribute.
     * @return The list of posts.
     */
    public List<Post> getPosts() {
        return this.posts;
    }

    /**
     * Sets the posts attribute.
     * @param posts The list of posts to set.
     */
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    /**
     * Gets the topic attribute value.
     * @return The value of the topic attribute.
     */
    public int getTopicId() {
        return this.topicId;
    }

    /**
     * Sets the topicId attribute.
     * @param topicId The new value to set.
     */
    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }
}