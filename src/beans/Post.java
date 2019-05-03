package beans;

import managers.UserDbManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import static schemas.PostDbSchema.*;

/**
 * Class defining a post.
 */
public final class Post extends Entity {
	/**
	 * Defines the default attribute name when using request to set attribute.
	 */
	public static final String ATTR_NAME = "post";
	
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
    	this.id = id;
        this.content = content;
        this.datePublished = new Date();
        this.author = author;
        this.discussionId = discussionId;
    }

    /**
     * Post's constructor from result set.
     * @param rs The result set from the database.
     */
    public Post(ResultSet rs) {
        try {
            this.id = rs.getInt(ID);
            this.content = rs.getString(CONTENT);
            this.datePublished = rs.getDate(DATE);
            this.author = new UserDbManager().dbLoad(rs.getInt(USER));
            this.discussionId = rs.getInt(DISCUSSION);
        } catch (SQLException e) {
            System.err.println("An error occurred with the status init.\n" + e.getMessage());
        }
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
     * @param discussionId the id of the discussion.
     */
	public void setDiscussionId(int discussionId) {
		this.discussionId = discussionId;
	}
}