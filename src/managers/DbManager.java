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
    private static Connection connector;

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
        
        if (DbManager.connector == null) {
        	DbManager.connector = dbF.getConnector();
        }
    }

    /**
     * DbManager's full filled constructor providing its DbFactory.
     * @param dbF The DbFactory used to get the connection object.
     */
    public DbManager(DbFactory dbF) {
    	DbManager.connector = dbF.getConnector();
    }

    /**
     * Gets the connector attribute.
     * @return The db connection.
     */
    public static Connection getConnector() {
        return DbManager.connector;
    }

    /**
     * Sets the value of the connector.
     * @param connector The new value to set.
     */
    public static void setConnector(Connection connector) {
    	DbManager.connector = connector;
    }
}