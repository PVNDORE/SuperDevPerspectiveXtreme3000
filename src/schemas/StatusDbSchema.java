package schemas;

/**
 * Schema class defining the db schema of the status entity.
 */
public abstract class StatusDbSchema {
    /**
     * Stores the table name.
     */
    public static final String TABLE = "status";

    /**
     * Stores the id field name.
     */
    public static final String ID = "id";

    /**
     * Stores the label field name.
     */
    public static final String LABEL = "label";

    /**
     * Stores the id field aliased by the table name.
     */
    public static final String AL_ID = TABLE + "." + ID;

    /**
     * Stores the label field aliased by the table name.
     */
    public static final String AL_LABEL = TABLE + "." + LABEL;
}
