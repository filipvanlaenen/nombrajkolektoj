package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for BigDecimals.
 */
abstract class AbstractModifiableBigDecimalCollection extends AbstractBigDecimalCollection
        implements ModifiableNumericCollection<BigDecimal> {
    @Override
    public boolean augment(final BigDecimal addend) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && addend != BigDecimal.ZERO) {
                results[i] = originalValue.add(addend);
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
    public boolean divide(final BigDecimal divisor) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO && divisor != BigDecimal.ONE) {
                results[i] = originalValue.divide(divisor);
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
    public boolean multiply(final BigDecimal multiplicand) throws IllegalArgumentException {
        int n = size();
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO && multiplicand != BigDecimal.ONE) {
                results[i] = originalValue.multiply(multiplicand);
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
        BigDecimal[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            BigDecimal originalValue = results[i];
            if (originalValue != null && originalValue != BigDecimal.ZERO) {
                results[i] = originalValue.negate();
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
     * Puts the content of an array with BigDecimals into the BigDecimals collection.
     *
     * @param results      An array with BigDecimals that should be put into the BigDecimals collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final BigDecimal[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (BigDecimal n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
