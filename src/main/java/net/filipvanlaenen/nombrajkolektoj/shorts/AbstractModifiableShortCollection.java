package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for shorts.
 */
abstract class AbstractModifiableShortCollection extends AbstractShortCollection
        implements ModifiableNumericCollection<Short> {
    @Override
    public boolean augment(final Short addend) {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && addend != (short) 0) {
                results[i] = (short) (originalValue + addend);
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
    public boolean divide(final Short divisor) {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && originalValue != (short) 0 && divisor != (short) 1) {
                results[i] = (short) (originalValue / divisor);
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
    public boolean multiply(final Short multiplicand) {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && originalValue != (short) 0 && multiplicand != (short) 1) {
                results[i] = (short) (originalValue * multiplicand);
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
    public boolean negate() {
        int n = size();
        Short[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Short originalValue = results[i];
            if (originalValue != null && originalValue != (short) 0) {
                results[i] = (short) (-originalValue);
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
     * Puts the content of an array with shorts into the shorts collection.
     *
     * @param results An array with shorts that should be put into the shorts collection.
     */
    private void putResults(final Short[] results, final String errorMessage) {
        clear();
        for (Short n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
