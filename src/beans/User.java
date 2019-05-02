package beans;

/**
 * Class representing a user of the app.
 */
public final class User extends Entity {
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
    private boolean isAdmin;

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
        this.isAdmin = isAdmin;
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
        this.isAdmin = isAdmin;
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
        return this.isAdmin;
    }

    /**
     * Sets the value of the admin attribute.
     * @param admin The boolean value to set.
     */
    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}