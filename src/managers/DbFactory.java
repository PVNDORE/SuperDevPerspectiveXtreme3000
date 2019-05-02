package managers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class providing the database connection object.
 */
public class DbFactory {
    /**
     * The db user name.
     */
    private String userName;

    /**
     * The db password.
     */
    private String password;

    /**
     * The db name.
     */
    private String database;

    /**
     * The db connection url.
     */
    private String url;

    /**
     * DbFactory's default constructor.
     */
    public DbFactory() {
        this.userName = "root";
        this.password = "root";
        this.database = "Forum";
        this.url = "jdbc:mysql://localhost:8889/" + this.database + "?serverTimezone=UTC";
    }

    /**
     * DbFactory's default constructor.
     * @param uName The db user name.
     * @param psswd The db password.
     * @param db The db name.
     * @param host The db host.
     * @param port The db port.
     */
    public DbFactory(String uName, String psswd, String db, String host, String port) {
        this.userName = uName;
        this.password = psswd;
        this.database = db;
        this.url = "jdbc:mysql://" + host + ":" + port + "/" + db;
    }

    /**
     * Gets the userName attribute.
     * @return The user name.
     */
    public String getUserName() {
        return this.userName;
    }

    /**
     * Sets the value of the userName attribute.
     * @param userName The user name to set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password attribute.
     * @return The password.
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
     * Gets the database attribute.
     * @return The database name.
     */
    public String getDatabase() {
        return this.database;
    }

    /**
     * Sets the value of the database attribute.
     * @param database The database to set.
     */
    public void setDatabase(String database) {
        this.database = database;
    }

    /**
     * Gets the url attribute.
     * @return The associated url.
     */
    public String getUrl() {
        return this.url;
    }

    /**
     * Sets the value of the url attribute.
     * @param url The url to set.
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the database connector.
     * @return The db connector.
     */
    public Connection getConnector() {
        try {
            return DriverManager.getConnection(this.url, this.userName, this.password);
        } catch (SQLException e) {
            System.err.println("An error occurred while getting the connector.");
            System.err.println(e.getMessage());

            return null;
        }
    }
}