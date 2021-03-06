package managers;

import beans.Topic;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static schemas.TopicDbSchema.*;

/**
 * Manager class used to manage topic beans.
 */
public final class TopicDbManager extends DbManager {
    /**
     * TopicDbManager's default constructor.
     */
    public TopicDbManager() {
        super();
    }

    /**
     * Creates a topic into the database and set its associated id.
     * @param topic The topic to save.
     * @return true if success else false.
     */
    public boolean dbCreate(Topic topic) {
        try {
            String query = String.format("INSERT INTO %s (%s) VALUES (?)", TABLE, LABEL);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, topic.getName());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                topic.setId(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println("An error occurred with the topic creating.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Loads a topic from the database.
     * @param id The id of the topic to load.
     * @return The loaded topic if success.
     */
    public Topic dbLoad(int id) {
        try {
            Topic topic = null;
            String query = String.format("SELECT * FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                topic = new Topic(rs);
            }

            rs.close();

            return topic;
        } catch (SQLException e) {
            System.err.println("An error occurred with the topic loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Updates a topic into the database.
     * @param topic The topic to update.
     * @return true if success else false.
     */
    public boolean dbUpdate(Topic topic) {
        try {
            String query = String.format("UPDATE %s SET %s = ? WHERE %s = ?", TABLE, LABEL, ID);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setString(1, topic.getName());
            st.setInt(2, topic.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the topic's update.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Deletes a topic entity from the database.
     * @param topic The topic to delete.
     * @return true if success else false.
     */
    public boolean dbDelete(Topic topic) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            st.setInt(1, topic.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the topic's update.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Gets the list of all topics from the database.
     * @return The list of topics.
     */
    public List<Topic> queryAll() {
        try {
            List<Topic> topics = new ArrayList<>();
            String query = String.format("SELECT * FROM %s", TABLE);
            PreparedStatement st = DbManager.getConnector().prepareStatement(query);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                topics.add(new Topic(rs));
            }

            rs.close();

            return topics;
        } catch (SQLException e) {
            System.err.println("An error occurred with the topics loading.\n" + e.getMessage());

            return null;
        }
    }
}
