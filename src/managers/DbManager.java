package managers;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Abstract class extended by all the manager classes in order to manage the entities in the db.
 */
public abstract class DbManager {
    /**
     * Stores the database connector.
     */
    private Connection connector;

    /**
     * DbManager's default constructor.
     */
    public DbManager() {
        DbFactory dbF = new DbFactory();
        this.connector = dbF.getConnector();
    }

    public DbManager(DbFactory dbF) {
        this.connector = dbF.getConnector();
    }

    public Connection getConnector() {
        return this.connector;
    }

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