package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for BigIntegers.
 */
abstract class AbstractModifiableBigIntegerCollection extends AbstractBigIntegerCollection
        implements ModifiableNumericCollection<BigInteger> {
    @Override
    public boolean augment(final BigInteger addend) throws IllegalArgumentException {
        int n = size();
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigInteger originalValue = results[i];
            if (originalValue != null && addend != BigInteger.ZERO) {
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
    public boolean divide(final BigInteger divisor) throws IllegalArgumentException {
        int n = size();
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigInteger originalValue = results[i];
            if (originalValue != null && originalValue != BigInteger.ZERO && divisor != BigInteger.ONE) {
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
    public boolean multiply(final BigInteger multiplicand) throws IllegalArgumentException {
        int n = size();
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < n; i++) {
            BigInteger originalValue = results[i];
            if (originalValue != null && originalValue != BigInteger.ZERO && multiplicand != BigInteger.ONE) {
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
        BigInteger[] results = this.toArray();
        boolean changed = false;
        for (int i = 0; i < size(); i++) {
            BigInteger originalValue = results[i];
            if (originalValue != null && originalValue != BigInteger.ZERO) {
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
     * Puts the content of an array with BigIntegers into the BigIntegers collection.
     *
     * @param results      An array with BigIntegers that should be put into the BigIntegers collection.
     * @param errorMessage The message to be used as the message for the {@link IllegalArgumentException}
     * @throws IllegalArgumentException If the results can't be put into the collection.
     */
    protected void putResults(final BigInteger[] results, final String errorMessage) throws IllegalArgumentException {
        clear();
        for (BigInteger n : results) {
            if (!add(n)) {
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}
