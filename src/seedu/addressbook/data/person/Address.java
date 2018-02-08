package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

import seedu.addressbook.data.person.address.Block;
import seedu.addressbook.data.person.address.Street;
import seedu.addressbook.data.person.address.Unit;
import seedu.addressbook.data.person.address.PostalCode;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses should be in the format of: " +
            "'a/BLOCK, STREET, UNIT, POSTAL_CODE'";
    public static final String ADDRESS_VALIDATION_REGEX = "(.+),(.+),(.+),(.+)";

    private static final String ADDRESS_SPLIT_DELIMITER = ",";

    private static final Integer BLOCK_INDEX = 0;
    private static final Integer STREET_INDEX = 1;
    private static final Integer UNIT_INDEX = 2;
    private static final Integer POSTALCODE_INDEX = 3;

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;

    public final String value;
    private boolean isPrivate;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = trimmedAddress;
        String[] splitAddress = trimmedAddress.split(ADDRESS_SPLIT_DELIMITER);
        if (splitAddress.length < 4) { //Sanity check
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.block = new Block(splitAddress[BLOCK_INDEX].trim());
        this.street = new Street(splitAddress[STREET_INDEX].trim());
        this.unit = new Unit(splitAddress[UNIT_INDEX].trim());
        this.postalCode = new PostalCode(splitAddress[POSTALCODE_INDEX].trim());
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s",
                block.toString(),
                street.toString(),
                unit.toString(),
                postalCode.toString());
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
