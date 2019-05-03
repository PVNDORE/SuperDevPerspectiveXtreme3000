package beans;

import java.sql.ResultSet;
import java.sql.SQLException;

import static schemas.UserDbSchema.*;

/**
 * Class representing a user of the app.
 */
public final class User extends Entity {
	/**
	 * Defines the default attribute name when using request to set attribute.
	 */
	public static final String ATTR_NAME = "user";
	
	/**
	 * Defines the default cookie name to get the connected user.
	 */
	public static final String COOKIE = "userConnected";
    /**
     * Stores the user's pseudo.
     */
    private String pseudo;

    /**
     * Stores the user's email.
     */
    private String email;

    /**
     * Stores the user's password.
     */
    private String password;

    /**
     * Defines if the user is admin or not.
     */
    private boolean admin;

    /**
     * Default constructor
     */
    public User() {
    }

    /**
     * Pseudo's nearly full filled constructor.
     * @param pseudo The user's pseudo.
     * @param email The user's email.
     * @param password The user's password.
     * @param isAdmin The boolean defining if the user is admin or not.
     */
    public User(String pseudo, String email, String password, boolean isAdmin) {
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.admin = isAdmin;
    }

    /**
     * Pseudo's nearly full filled constructor.
     * @param id The user's id.
     * @param pseudo The user's pseudo.
     * @param email The user's email.
     * @param password The user's password.
     * @param isAdmin The boolean defining if the user is admin or not.
     */
    public User(int id, String pseudo, String email, String password, boolean isAdmin) {
        this.id = id;
        this.pseudo = pseudo;
        this.email = email;
        this.password = password;
        this.admin = isAdmin;
    }

    /**
     * User's constructor from result set.
     * @param rs The result set from the database.
     */
    public User(ResultSet rs) {
        try {
            this.id = rs.getInt(ID);
            this.pseudo = rs.getString(LABEL);
            this.admin = rs.getBoolean(ADMIN);
            this.email = rs.getString(EMAIL);
            this.password = rs.getString(EMAIL);
        } catch (SQLException e) {
            System.err.println("An error occurred with the user init.\n" + e.getMessage());
        }
    }

    /**
     * Gets the value of the pseudo attribute.
     * @return The value of the attribute.
     */
    public String getPseudo() {
        return this.pseudo;
    }

    /**
     * Sets the value of the pseudo attribute.
     * @param pseudo The pseudo to set.
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Gets the value of the email attribute.
     * @return The value of the attribute.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the value of the email attribute.
     * @param email The email to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the value of the password attribute.
     * @return The value of the attribute.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Sets the value of the password attribute.
     * @param password The password to set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the value of the admin attribute.
     * @return The value of the attribute.
     */
    public boolean isAdmin() {
        return this.admin;
    }

    /**
     * Sets the value of the admin attribute.
     * @param admin The boolean value to set.
     */
    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
}