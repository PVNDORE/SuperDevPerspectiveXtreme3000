package schemas;

/**
 * Schema class defining the db schema of the user entity.
 */
public abstract class UserDbSchema {
    /**
     * Stores the table name.
     */
    public static final String TABLE = "user";

    /**
     * Stores the id field name.
     */
    public static final String ID = "id";

    /**
     * Stores the label field name.
     */
    public static final String LABEL = "label";

    /**
     * Stores the admin field name.
     */
    public static final String ADMIN = "admin";

    /**
     * Stores the email field name.
     */
    public static final String EMAIL = "email";

    /**
     * Stores the password field name.
     */
    public static final String PASSWORD = "password";

    /**
     * Stores the id field aliased by the table name.
     */
    public static final String AL_ID = TABLE + "." + ID;

    /**
     * Stores the label field aliased by the table name.
     */
    public static final String AL_LABEL = TABLE + "." + LABEL;
}
