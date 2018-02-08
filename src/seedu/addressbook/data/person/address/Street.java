package seedu.addressbook.data.person.address;

public class Street {
    public final String street;

    public Street(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return street;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Street
                && this.street.equals(((Street) other).street));
    }

    @Override
    public int hashCode() {
        return street.hashCode();
    }
}