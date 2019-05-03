package managers;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Abstract class extended by all the manager classes in order to manage the beans in the db.
 */
public abstract class DbManager {
    /**
     * Stores the database connector.
     */
    private Connection connector;

    /**
     * Defines if the jdbc driver has been loaded or not.
     */
    protected static boolean driverLoaded;

    /**
     * DbManager's default constructor.
     */
    public DbManager() {
        if (!DbManager.driverLoaded) {
            try {
                Class.forName("com.mysql.jdbc.Driver");

                DbManager.driverLoaded = true;
            } catch (ClassNotFoundException e) {
                System.err.println(e.getMessage());
            }
        }
        DbFactory dbF = new DbFactory();
        this.connector = dbF.getConnector();
    }

    /**
     * DbManager's full filled constructor providing its DbFactory.
     * @param dbF The DbFactory used to get the connection object.
     */
    public DbManager(DbFactory dbF) {
        this.connector = dbF.getConnector();
    }

    /**
     * Gets the connector attribute.
     * @return The db connection.
     */
    public Connection getConnector() {
        return this.connector;
    }

    /**
     * Sets the value of the connector.
     * @param connector The new value to set.
     */
    public void setConnector(Connection connector) {
        this.connector = connector;
    }

    @Override
    public void finalize() {
        try {
            this.connector.close();
        } catch (SQLException e) {
            System.err.println("The connector can't be closed, it may not exists.");
        }
    }
}