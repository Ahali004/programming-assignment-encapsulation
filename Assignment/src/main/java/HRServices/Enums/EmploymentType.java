package HRServices.Enums;

/** Named values used by the employee records. */
public enum EmploymentType {
    FULL_TIME("Full-time", "An employee who works a full-time schedule."),
    PART_TIME("Part-time", "An employee who works a part-time schedule."),
    SEASONAL("Seasonal", "An employee hired for a particular season."),
    CONTRACTOR("Contractor", "A worker engaged for a defined contract.");

    private final String name;
    private final String description;

    EmploymentType(String name, String description) {
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

    public static EmploymentType fromString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be blank.");
        }
        for (EmploymentType type : values()) {
            if (type.name().equalsIgnoreCase(trimmed)
                    || type.name.equalsIgnoreCase(trimmed)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown employment type: " + text);
    }
}