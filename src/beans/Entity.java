package entities;

/**
 * Abstract class, extended by all the entities.
 */
public abstract class Entity {
    /**
     * The entity id.
     */
    protected int id;

    /**
     * Default constructor.
     */
    public Entity() {
    }

    /**
     * Gets the value of the id attribute.
     * @return The int value of the attribute.
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id attribute.
     * @param id The id to set.
     */
    public void setId(int id) {
        this.id = id;
    }
}