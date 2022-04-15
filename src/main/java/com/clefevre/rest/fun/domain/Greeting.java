package com.clefevre.rest.fun.domain;

/**
 * Basic greeting class to return to the caller a simple greeting.
 */
public class Greeting {

    /**
     * Identifier for the greeting being used.
     */
    private final long id;

    /**
     * The content of the greeting to be displayed.
     */
    private final String content;

    /**
     * Standard constructor
     * @param aId the Id to assign to the greeting.
     * @param aContent The content to be assigned as the greeting itself.
     */
    public Greeting( long aId, String aContent ) {
        id = aId;
        content = aContent;
    }

    /**
     * Basic getter for the greeting identifier.
     * @return The long identifier.
     */
    public long getId() {
        return id;
    }

    /**
     * Basic getter for the greeting content.
     * @return String content of the greeting.
     */
    public String getContent() {
        return content;
    }
}
