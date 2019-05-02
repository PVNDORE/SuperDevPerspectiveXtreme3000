package beans;

import java.util.*;

/**
 * Class representing a topic of the app.
 */
public final class Topic extends Entity {
    /**
     * Stores the name of the topic.
     */
    private String name;

    /**
     * Stores the list of discussion of the topic.
     */
    private List<Discussion> discussions;

    /**
     * Default constructor
     */
    private Topic() {
    }

    /**
     * Topic's nearly full filled constructor.
     * @param name The name of the topic.
     * @param discussions The list of discussions associated to the topic.
     */
    public Topic(String name, List<Discussion> discussions) {
        this.name = name;
        this.discussions = discussions;
    }

    /**
     * Topic's full filled constructor.
     * @param id The id of the topic.
     * @param name The name of the topic.
     * @param discussions The list of discussions associated to the topic.
     */
    public Topic(int id, String name, List<Discussion> discussions) {
        this.id = id;
        this.name = name;
        this.discussions = discussions;
    }

    /**
     * Gets the value of the name attribute.
     * @return The name of the topic.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name attribute.
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value of the discussions attribute.
     * @return The list of discussions of the topic.
     */
    public List<Discussion> getDiscussions() {
        return discussions;
    }

    /**
     * Sets the value of the discussion attribute.
     * @param discussions The list of discussion to set.
     */
    public void setDiscussions(List<Discussion> discussions) {
        this.discussions = discussions;
    }
}