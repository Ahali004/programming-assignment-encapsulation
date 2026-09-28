package HRServices.Records;

/** Immutable contact information for a person. */
public record ContactInfo(
        String firstName,
        String lastName,
        Address address,
        String telephone,
        String email) {

    @Override
    public String toString() {
        return toString(0);
    }

    /** Formats this record with the requested number of leading tabs. */
    public String toString(int tabLevel) {
        if (tabLevel < 0) {
            throw new IllegalArgumentException("tabLevel must not be negative.");
        }
        String indent = "\t".repeat(tabLevel);
        StringBuilder text = new StringBuilder();
        text.append(indent).append("First name: ").append(firstName).append('\n');
        text.append(indent).append("Last name: ").append(lastName).append('\n');
        text.append(indent).append("Address:").append('\n');
        text.append(address.toString(tabLevel + 1)).append('\n');
        text.append(indent).append("Telephone: ").append(telephone).append('\n');
        text.append(indent).append("Email: ").append(email);
        return text.toString();
    }

    /** Compact layout used for supervisor and emergency contacts. */
    String compactString(int tabLevel) {
        String indent = "\t".repeat(tabLevel);
        StringBuilder text = new StringBuilder();
        text.append(indent).append("Name: ").append(firstName).append(' ').append(lastName).append('\n');
        text.append(indent).append("Telephone: ").append(telephone).append('\n');
        text.append(indent).append("Email: ").append(email).append('\n');
        text.append(indent).append("Address:").append('\n');
        text.append(indent).append('\t').append(address.street()).append('\n');
        text.append(indent).append('\t').append(address.city()).append(", ")
                .append(address.state()).append(' ').append(address.zipCode());
        return text.toString();
    }

    /** A nested builder, not a subclass: records themselves are final. */
    public static class Builder {
        private String firstName;
        private String lastName;
        private Address address;
        private String telephone;
        private String email;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder address(Address address) {
            this.address = address;
            return this;
        }

        public Builder telephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public ContactInfo build() {
            return new ContactInfo(firstName, lastName, address, telephone, email);
        }
    }
}