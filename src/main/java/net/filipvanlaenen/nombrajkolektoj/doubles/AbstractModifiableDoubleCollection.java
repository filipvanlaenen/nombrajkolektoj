package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for doubles.
 */
abstract class AbstractModifiableDoubleCollection extends AbstractDoubleCollection
        implements ModifiableNumericCollection<Double> {
    @Override
    public boolean augment(final Double addend) {
        int n = size();
        Double[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Double originalValue = results[i];
            if (originalValue != null && addend != 0D) {
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
    public boolean divide(final Double divisor) {
        int n = size();
        Double[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Double originalValue = results[i];
            if (originalValue != null && originalValue != 0D && divisor != 1D) {
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
    public boolean multiply(final Double multiplicand) {
        int n = size();
        Double[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Double originalValue = results[i];
            if (originalValue != null && originalValue != 0D && multiplicand != 1D) {
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
        Double[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Double originalValue = results[i];
            if (originalValue != null && originalValue != 0D) {
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
     * Puts the content of an array with doubles into the doubles collection.
     *
     * @param results An array with doubles that should be put into the doubles collection.
     */
    private void putResults(final Double[] results, final String errorMessage) {
        clear();
        for (Double n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
