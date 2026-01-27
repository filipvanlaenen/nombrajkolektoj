package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for integers.
 */
abstract class AbstractModifiableIntegerCollection extends AbstractIntegerCollection
        implements ModifiableNumericCollection<Integer> {
    @Override
    public boolean augment(final Integer addend) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && addend != 0) {
                results[i] = originalValue + addend;
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
    public boolean divide(final Integer divisor) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && originalValue != 0 && divisor != 1) {
                results[i] = originalValue / divisor;
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
    public boolean multiply(final Integer multiplicand) throws IllegalArgumentException {
        int n = size();
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Integer originalValue = results[i];
            if (originalValue != null && originalValue != 0 && multiplicand != 1) {
                results[i] = originalValue * multiplicand;
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
        Integer[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            Integer originalValue = results[i];
            if (originalValue != null && originalValue != 0) {
                results[i] = -originalValue;
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
     * Puts the content of an array with integers into the integers collection.
     *
     * @param results      An array with integers that should be put into the integers collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final Integer[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (Integer n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
