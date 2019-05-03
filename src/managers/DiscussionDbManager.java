package managers;

import beans.Discussion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static schemas.DiscussionDbSchema.*;

/**
 * Manager class used to manage discussion beans.
 */
public final class DiscussionDbManager extends DbManager {
    /**
     * DiscussionDbManager's default constructor.
     */
    public DiscussionDbManager() {
        super();
    }

    /**
     * Creates a discussion into the database and set its associated id.
     * @param discussion The discussion to save.
     * @return true if success else false.
     */
    public boolean dbCreate(Discussion discussion) {
        try {
            String query = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?)", TABLE, LABEL, TOPIC, STATUS);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, discussion.getTitle());
            st.setInt(2, discussion.getTopicId());
            st.setInt(3, discussion.getStatus().getId());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                discussion.setId(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussion creating.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Loads a discussion from the database.
     * @param id The id of the discussion to load.
     * @return The loaded discussion if success.
     */
    public Discussion dbLoad(int id) {
        try {
            Discussion discussion = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                discussion = new Discussion(rs);
            }

            rs.close();

            return discussion;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussion loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Loads all discussions which have not the pending status from the database.
     * @return The loaded discussions if success.
     */
    public List<Discussion> dbLoadPublic() {
        try {
            ArrayList<Discussion> discussions = new ArrayList<>();
            String query = String.format("SELECT * FROM %s WHERE %s != ?", TABLE, STATUS);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, new StatusDbManager().getId(StatusDbManager.PENDING));

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                discussions.add(new Discussion(rs));
            }

            rs.close();

            return discussions;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussions loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Loads all discussions which have the pending status from the database.
     * @return The loaded discussions if success.
     */
    public List<Discussion> dbLoadPending() {
        try {
            ArrayList<Discussion> discussions = new ArrayList<>();
            String query = String.format("SELECT * FROM %s WHERE %s = ?", TABLE, STATUS);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, new StatusDbManager().getId(StatusDbManager.PENDING));

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                discussions.add(new Discussion(rs));
            }

            rs.close();

            return discussions;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussions loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Loads all discussions from a specific topic from the database.
     * @return The loaded discussions if success.
     */
    public List<Discussion> dbLoadFromTopic(int id) {
        try {
            Discussion discussion;
            ArrayList<Discussion> discussions = new ArrayList<>();
            String query = String.format("SELECT * FROM %s WHERE %s = ?", TABLE, TOPIC);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                discussions.add(new Discussion(rs));
            }

            rs.close();

            return discussions;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussions loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Updates a discussion into the database.
     * @param discussion The discussion to update.
     * @return true if success else false.
     */
    public boolean dbUpdate(Discussion discussion) {
        try {
            String query = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?", TABLE, LABEL, TOPIC,
                    STATUS, ID);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, discussion.getTitle());
            st.setInt(2, discussion.getTopicId());
            st.setInt(3, discussion.getStatus().getId());
            st.setInt(4, discussion.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussion's update.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Deletes a discussion entity from the databases.
     * @param discussion The discussion to delete.
     * @return true if success else false.
     */
    public boolean dbDelete(Discussion discussion) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, discussion.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the discussion's update.\n" + e.getMessage());

            return false;
        }
    }
}
