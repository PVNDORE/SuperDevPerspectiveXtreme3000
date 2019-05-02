package schemas;

/**
 * Schema class defining the db schema of the post entity.
 */
public abstract class PostDbSchema {
    /**
     * Stores the table name.
     */
    public static final String TABLE = "post";

    /**
     * Stores the id field name.
     */
    public static final String ID = "id";

    /**
     * Stores the content field name.
     */
    public static final String CONTENT = "content";

    /**
     * Stores the date field name.
     */
    public static final String DATE = "date_published";

    /**
     * Stores the discussion field name.
     */
    public static final String DISCUSSION = "discussion_id";

    /**
     * Stores the user field name.
     */
    public static final String USER = "user_id";

    /**
     * Stores the id field aliased by the table name.
     */
    public static final String AL_ID = TABLE + "." + ID;

    /**
     * Stores the user field aliased by the table name.
     */
    public static final String AL_USER = TABLE + "." + USER;
}
