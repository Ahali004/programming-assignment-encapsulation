package HRServices.Enums;

/** The 50 U.S. states. Constant names are postal abbreviations. */
public enum State {
    AL("Alabama"), AK("Alaska"), AZ("Arizona"), AR("Arkansas"), CA("California"),
    CO("Colorado"), CT("Connecticut"), DE("Delaware"), FL("Florida"), GA("Georgia"),
    HI("Hawaii"), ID("Idaho"), IL("Illinois"), IN("Indiana"), IA("Iowa"),
    KS("Kansas"), KY("Kentucky"), LA("Louisiana"), ME("Maine"), MD("Maryland"),
    MA("Massachusetts"), MI("Michigan"), MN("Minnesota"), MS("Mississippi"), MO("Missouri"),
    MT("Montana"), NE("Nebraska"), NV("Nevada"), NH("New Hampshire"), NJ("New Jersey"),
    NM("New Mexico"), NY("New York"), NC("North Carolina"), ND("North Dakota"), OH("Ohio"),
    OK("Oklahoma"), OR("Oregon"), PA("Pennsylvania"), RI("Rhode Island"), SC("South Carolina"),
    SD("South Dakota"), TN("Tennessee"), TX("Texas"), UT("Utah"), VT("Vermont"),
    VA("Virginia"), WA("Washington"), WV("West Virginia"), WI("Wisconsin"), WY("Wyoming");

    private final String name;
    private final String description;

    State(String name) {
        this.name = name;
        this.description = "The U.S. state of " + name + ".";
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

    public static State fromString(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Value cannot be null.");
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be blank.");
        }
        for (State state : values()) {
            if (state.name().equalsIgnoreCase(trimmed)
                    || state.name.equalsIgnoreCase(trimmed)) {
                return state;
            }
        }
        throw new IllegalArgumentException("Unknown state: " + text);
    }
}