package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import static schemas.StatusDbSchema.*;

/**
 * Class defining the status of a discussion.
 */
public final class Status extends Entity {
    /**
     * Stores the name of the status.
     */
    private String name;

    /**
     * Default constructor
     */
    public Status() {
    }

    /**
     * Status's nearly full filled constructor.
     * @param name The name of the status.
     */
    public Status(String name) {
        this.name = name;
    }

    /**
     * Status's full filled constructor.
     * @param id The id of the status.
     * @param name The name of the status.
     */
    public Status(int id, String name) {
        this.name = name;
    }

    /**
     * Status's constructor from result set.
     * @param rs The result set from the database.
     */
    public Status(ResultSet rs) {
        try {
            this.id = rs.getInt(ID);
            this.name = rs.getString(LABEL);
        } catch (SQLException e) {
            System.err.println("An error occurred with the status init.\n" + e.getMessage());
        }
    }

    /**
     * Gets the value of the name attribute.
     * @return The value of the name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the value of the name.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}