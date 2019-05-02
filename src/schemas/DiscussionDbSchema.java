package schemas;

/**
 * Schema class defining the db schema of the discussion entity.
 */
public abstract class DiscussionDbSchema {
    /**
     * Stores the table name.
     */
    public static final String TABLE = "discussion";

    /**
     * Stores the id field name.
     */
    public static final String ID = "id";

    /**
     * Stores the label field name.
     */
    public static final String LABEL = "label";

    /**
     * Stores the topic field name.
     */
    public static final String TOPIC = "topic_id";

    /**
     * Stores the user field name.
     */
    public static final String USER = "user_id";

    /**
     * Stores the id field aliased by the table name.
     */
    public static final String AL_ID = TABLE + "." + ID;

    /**
     * Stores the title field aliased by the table name.
     */
    public static final String AL_LABEL = TABLE + "." + LABEL;

    /**
     * Stores the user field aliased by the table name.
     */
    public static final String AL_USER = TABLE + "." + USER;
}
