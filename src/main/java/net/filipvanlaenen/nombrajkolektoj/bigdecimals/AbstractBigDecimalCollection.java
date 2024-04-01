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
        for (BigDecimal bd : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (bd != null && (max == null || bd.compareTo(max) > 0)) {
                max = bd;
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
        for (BigDecimal bd : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (bd != null && (min == null || bd.compareTo(min) < 0)) {
                min = bd;
            }
        }
        return min;
    }

    @Override
    public BigDecimal product() {
        BigDecimal product = BigDecimal.ONE;
        for (BigDecimal bd : this) {
            if (bd != null) {
                product = product.multiply(bd);
            }
        }
        return product;
    }

    @Override
    public BigDecimal sum() {
        BigDecimal sum = BigDecimal.ZERO;
        for (BigDecimal bd : this) {
            if (bd != null) {
                sum = sum.add(bd);
            }
        }
        return sum;
    }
}
