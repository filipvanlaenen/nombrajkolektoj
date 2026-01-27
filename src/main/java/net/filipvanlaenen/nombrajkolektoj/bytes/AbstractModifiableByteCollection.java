package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for bytes.
 */
abstract class AbstractModifiableByteCollection extends AbstractByteCollection
        implements ModifiableNumericCollection<Byte> {
    @Override
    public boolean augment(final Byte addend) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && addend != (byte) 0) {
                results[i] = (byte) (originalValue + addend);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot augment with the addend due to the cardinality constraint.");
        return true;
    }

    @Override
    public boolean divide(final Byte divisor) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && originalValue != (byte) 0 && divisor != (byte) 1) {
                results[i] = (byte) (originalValue / divisor);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot divide by the divisor due to the cardinality constraint.");
        return true;
    }

    @Override
    public boolean multiply(final Byte multiplicand) throws IllegalArgumentException {
        int n = size();
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Byte originalValue = results[i];
            if (originalValue != null && originalValue != (byte) 0 && multiplicand != (byte) 1) {
                results[i] = (byte) (originalValue * multiplicand);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot multiply with the multiplicand due to the cardinality constraint.");
        return true;
    }

    @Override
    public boolean negate() throws IllegalArgumentException {
        Byte[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Byte originalValue = results[i];
            if (originalValue != null && originalValue != (byte) 0) {
                results[i] = (byte) (-originalValue);
                changed = true;
            }
        }
        if (!changed) {
            return false;
        }
        putResults(results, "Cannot negate due to the cardinality constraint.");
        return true;
    }

    /**
     * Puts the content of an array with bytes into the bytes collection.
     *
     * @param results      An array with bytes that should be put into the bytes collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Byte[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Byte n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
