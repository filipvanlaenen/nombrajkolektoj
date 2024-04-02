package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for BigIntegers.
 */
abstract class AbstractBigIntegerCollection implements NumericCollection<BigInteger> {
    @Override
    public BigInteger max() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a maximum for an empty collection.");
        }
        BigInteger max = null;
        for (BigInteger bi : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (bi != null && (max == null || bi.compareTo(max) > 0)) {
                max = bi;
            }
        }
        return max;
    }

    @Override
    public BigInteger min() throws IndexOutOfBoundsException {
        if (size() == 0) {
            throw new IndexOutOfBoundsException("Cannot return a minimum for an empty collection.");
        }
        BigInteger min = null;
        for (BigInteger bi : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (bi != null && (min == null || bi.compareTo(min) < 0)) {
                min = bi;
            }
        }
        return min;
    }

    @Override
    public BigInteger product() {
        BigInteger product = BigInteger.ONE;
        for (BigInteger bi : this) {
            if (bi != null) {
                product = product.multiply(bi);
            }
        }
        return product;
    }

    @Override
    public BigInteger sum() {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger bi : this) {
            if (bi != null) {
                sum = sum.add(bi);
            }
        }
        return sum;
    }
}
