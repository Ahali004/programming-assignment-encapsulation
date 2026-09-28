package HRServices.Enums;

/** How an emergency contact is related to an employee. */
public enum Relationship {
    FRIEND("Friend", "A personal friend."),
    SPOUSE("Spouse", "A husband or wife."),
    PARTNER("Partner", "A life partner."),
    NEIGHBOR("Neighbor", "A person who lives nearby."),
    OTHER("Other", "Another trusted emergency contact.");

    private final String name;
    private final String description;

    Relationship(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name;
    }

    public static Relationship fromString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be blank.");
        }
        for (Relationship relationship : values()) {
            if (relationship.name().equalsIgnoreCase(trimmed)
                    || relationship.name.equalsIgnoreCase(trimmed)) {
                return relationship;
            }
        }
        throw new IllegalArgumentException("Unknown relationship: " + text);
    }
}