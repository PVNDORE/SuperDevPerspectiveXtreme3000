package managers;

import entities.Status;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static schemas.StatusDbSchema.TABLE;
import static schemas.StatusDbSchema.ID;
import static schemas.StatusDbSchema.LABEL;

/**
 * Manager class used to manage status entities.
 */
public final class StatusDbManager extends DbManager {
    /**
     * StatusDbManager's default constructor.
     */
    public StatusDbManager() {
        super();
    }

    /**
     * Creates a status into the database and set its associated id.
     * @param status The status to save.
     * @return true if success else false.
     */
    public boolean dbCreate(Status status) {
        try {
            String query = String.format("INSERT INTO %s (%s) VALUES (?)", TABLE, LABEL);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, status.getName());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                status.setId(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println("An error occurred with the status creating.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Loads a status from the database.
     * @param id The id of the status to load.
     * @return The loaded status if success else false.
     */
    public Status dbLoad(int id) {
        try {
            Status status = new Status();
            String query = String.format("SELECT * FROM %s WHERE %S = ?", TABLE, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                status.setId(rs.getInt(ID));
                status.setName(rs.getString(LABEL));
            }

            return status;
        } catch (SQLException e) {
            System.err.println("An error occurred with the status loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Updates a status into the database.
     * @param status The status to update.
     * @return true if success else false.
     */
    public boolean dbUpdate(Status status) {
        try {
            String query = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE, LABEL, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, status.getName());
            st.setInt(2, status.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the status's update.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Deletes a status entity from the database.s
     * @param status The status to delete.
     * @return true if success else false.
     */
    public boolean dbDelete(Status status) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setInt(1, status.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the status's update.\n" + e.getMessage());

            return false;
        }
    }
}
