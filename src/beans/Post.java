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
     * Stores the id of row in discussion table.
     */
    private int discussionId;

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
     * @param discussionId The id of discussion.
     * @param author The author of the post.
     */
    public Post(String content,int discussionId, User author) {
        this.content = content;
        this.datePublished = new Date();
        this.author = author;
        this.discussionId = discussionId;
    }

    /**
     * Post's full filled constructor.
     * @param id The id of the post.
     * @param content The content of the post.
     * @param discussionId The id of discussion.
     * @param author The author of the post.
     */
    public Post(int id, String content, int discussionId, User author) {
    	this.discussionId = id;
        this.content = content;
        this.datePublished = new Date();
        this.author = author;
        this.discussionId = discussionId;
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

    /**
     * Gets the value of the discussion id attribute.
     * @return id of discussion
     */
	public int getDiscussionId() {
		return discussionId;
	}

	
    /**
     * Sets the value of the discussion id attribute.
     * @param id of discussion.
     */
	public void setDiscussionId(int discussionId) {
		this.discussionId = discussionId;
	}
}