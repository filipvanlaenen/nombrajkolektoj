package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for longs.
 */
abstract class AbstractModifiableLongCollection extends AbstractLongCollection
        implements ModifiableNumericCollection<Long> {
    @Override
    public boolean augment(final Long addend) {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && addend != 0L) {
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
    public boolean divide(final Long divisor) {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && originalValue != 0L && divisor != 1L) {
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
    public boolean multiply(final Long multiplicand) {
        int n = size();
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && originalValue != 0L && multiplicand != 1L) {
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
        Long[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            Long originalValue = results[i];
            if (originalValue != null && originalValue != 0L) {
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
     * Puts the content of an array with longs into the longs collection.
     *
     * @param results An array with longs that should be put into the longs collection.
     */
    private void putResults(final Long[] results, final String errorMessage) {
        clear();
        for (Long n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
