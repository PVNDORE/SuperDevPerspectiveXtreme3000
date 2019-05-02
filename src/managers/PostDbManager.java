package managers;

import static schemas.PostDbSchema.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Post;
import beans.User;

public class PostDbManager extends DbManager {
	
    public PostDbManager() {
        super();
    }

    /**
     * Creates a post into the database and set its associated id.
     * @param post The post to save.
     * @return true if success else false.
     */
    public boolean dbCreate(Post post) {
        try {
            String query = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?)", TABLE,DATE,CONTENT,DISCUSSION,USER);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, post.getDatePublished().toString());
            st.setString(2, post.getContent());
            st.setInt(3, post.getDiscussionId());
            st.setInt(4, post.getAuthor().getId());
            st.executeUpdate();

            ResultSet rs = st.getGeneratedKeys();

            if (rs.next()) {
                post.setId(rs.getInt(1));
            }

            return true;
        } catch (SQLException e) {
            System.err.println("An error occurred with the post creating.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Loads a post from the database.
     * @param id The id of the post to load.
     * @return The loaded post if success else false.
     */
    public Post dbLoad(int id) {
        try {
            Post post = new Post();
            String query = String.format("SELECT * FROM %s WHERE %S = ?", TABLE, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if (rs.next()) {
                post.setId(rs.getInt(ID));
                post.setAuthor(new UserDbManager().dbLoad(rs.getInt(USER)));
                post.setContent(rs.getString(CONTENT));
                post.setDatePublished(rs.getDate(DATE));
                post.setDiscussionId(rs.getInt(DISCUSSION));
                
                
                // TODO : Get the associated discussions ?
            }

            return post;
        } catch (SQLException e) {
            System.err.println("An error occurred with the post loading.\n" + e.getMessage());

            return null;
        }
    }

    /**
     * Updates a post into the database.
     * @param post The post to update.
     * @return true if success else false.
     */
    public boolean dbUpdate(Post post) {
        try {
            String query = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?",TABLE,DATE,CONTENT,DISCUSSION,USER,ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setString(1, post.getDatePublished().toString());
            st.setString(2, post.getContent());
            st.setInt(3, post.getDiscussionId());
            st.setInt(4, post.getAuthor().getId());
            st.setInt(5, post.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the post's update.\n" + e.getMessage());

            return false;
        }
    }

    /**
     * Deletes a post entity from the database.s
     * @param post The post to delete.
     * @return true if success else false.
     */
    public boolean dbDelete(Post post) {
        try {
            String query = String.format("DELETE FROM %s WHERE %s = ?", TABLE, ID);
            PreparedStatement st = this.getConnector().prepareStatement(query);

            st.setInt(1, post.getId());

            return st.executeUpdate() != 0;
        } catch (SQLException e) {
            System.err.println("An error occurred with the post's update.\n" + e.getMessage());

            return false;
        }
    }

}