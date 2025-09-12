package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for BigDecimals.
 */
abstract class AbstractBigDecimalCollection implements NumericCollection<BigDecimal> {
    @Override
    public BigDecimal max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        BigDecimal max = null;
        for (BigDecimal n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n.compareTo(max) > 0)) {
                max = n;
            }
        }
        return max;
    }

    @Override
    public BigDecimal min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        BigDecimal min = null;
        for (BigDecimal n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n.compareTo(min) < 0)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public BigDecimal product() {
        BigDecimal product = BigDecimal.ONE;
        for (BigDecimal n : this) {
            if (n != null) {
                product = product.multiply(n);
            }
        }
        return product;
    }

    @Override
    public BigDecimal sum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal n : this) {
            if (n != null) {
                sum = sum.add(n);
            }
        }
        return sum;
    }

    @Override
    public abstract BigDecimal[] toArray();
}
