package HRServices.Enums;

/** Named values used by the employee records. */
public enum EmployeeDivision {
    WAREHOUSE("Warehouse", "Receives, stores, and prepares inventory."),
    TRANSPORTATION("Transportation", "Moves goods between locations."),
    SALES("Sales", "Sells products and services to customers."),
    MARKETING("Marketing", "Promotes products and manages branding."),
    ENGINEERING("Engineering", "Designs and builds products and systems."),
    MAINTENANCE("Maintenance", "Maintains and repairs equipment and facilities.");

    private final String name;
    private final String description;

    EmployeeDivision(String name, String description) {
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

    public static EmployeeDivision fromString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be blank.");
        }
        for (EmployeeDivision division : values()) {
            if (division.name().equalsIgnoreCase(trimmed)
                    || division.name.equalsIgnoreCase(trimmed)) {
                return division;
            }
        }
        throw new IllegalArgumentException("Unknown employee division: " + text);
    }
}