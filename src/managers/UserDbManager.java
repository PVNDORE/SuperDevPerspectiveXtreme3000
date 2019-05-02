package managers;

import static schemas.UserDbSchema.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.User;

public class UserDbManager extends DbManager {

    public UserDbManager() {
        super();
    }

    /**
     * Creates a user into the database and set its associated id.
     * @param user The user to save.
     * @return true if success else false.
     */
    public boolean dbCreate(User user) {
        try {
            String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)", TABLE,LABEL,ADMIN,EMAIL,PASSWORD);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, user.getPseudo());
            st.setBoolean(2,user.isAdmin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                user.setId(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println("An error occurred with the user creating.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Loads a user from the database.
     * @param id The id of the user to load.
     * @return The loaded user if success else false.
     */
    public User dbLoad(int id) {
        try {
            User user = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                user = new User(rs);
            }

            rs.close();

            return user;
        } catch (SQLException e) {
            System.err.println("An error occurred with the user loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Loads a user from auth data from the database.
     * @param email The email of the user to load.
     * @param password The password of the user to load.
     * @return The loaded user if success else false.
     */
    public User dbLoadFromAuth(String email, String password) {
        try {
            User user = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ? && %s = ?", TABLE, EMAIL, PASSWORD);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, email);
            st.setString(2, password);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                user = new User(rs);
            }

            rs.close();

            return user;
        } catch (SQLException e) {
            System.err.println("An error occurred with the user loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Updates a user into the database.
     * @param user The user to update.
     * @return true if success else false.
     */
    public boolean dbUpdate(User user) {
        try {
            String query = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",TABLE,LABEL,ADMIN,EMAIL,PASSWORD,ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, user.getPseudo());
            st.setBoolean(2, user.isAdmin());
            st.setString(3, user.getEmail());
            st.setString(4, user.getPassword());
            st.setInt(5, user.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the user's update.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Deletes a user entity from the database.s
     * @param user The user to delete.
     * @return true if success else false.
     */
    public boolean dbDelete(User user) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setInt(1, user.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the user's update.\n" + e.getMessage());

            return false;
        }
    }
}