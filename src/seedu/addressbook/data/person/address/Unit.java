package seedu.addressbook.data.person.address;

public class Unit {
    public final String unit;

    public Unit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit;
    }

    @Override
    public boolean equals(Object other) {
        return this == other
                || (other instanceof Unit
                && this.unit.equals(((Unit) other).unit));
    }

    @Override
    public int hashCode() {
        return unit.hashCode();
    }
}