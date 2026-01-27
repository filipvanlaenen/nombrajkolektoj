package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for floats.
 */
abstract class AbstractModifiableFloatCollection extends AbstractFloatCollection
        implements ModifiableNumericCollection<Float> {
    @Override
    public boolean augment(final Float addend) {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && addend != 0F) {
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
    public boolean divide(final Float divisor) {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && originalValue != 0F && divisor != 1F) {
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
    public boolean multiply(final Float multiplicand) {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && originalValue != 0F && multiplicand != 1F) {
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
    public boolean negate() {
        int n = size();
        Float[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Float originalValue = results[i];
            if (originalValue != null && originalValue != 0F) {
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
     * Puts the content of an array with floats into the floats collection.
     *
     * @param results An array with floats that should be put into the floats collection.
     */
    private void putResults(final Float[] results, final String errorMessage) {
        clear();
        for (Float n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
