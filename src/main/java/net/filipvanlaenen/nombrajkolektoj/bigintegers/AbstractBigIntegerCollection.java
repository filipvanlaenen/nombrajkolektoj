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
        for (BigInteger n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (max == null || n.compareTo(max) > 0)) {
                max = n;
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
        for (BigInteger n : this) {
            // EQMU: Changing the conditional boundary below produces an equivalent mutant.
            if (n != null && (min == null || n.compareTo(min) < 0)) {
                min = n;
            }
        }
        return min;
    }

    @Override
    public BigInteger product() {
        BigInteger product = BigInteger.ONE;
        for (BigInteger n : this) {
            if (n != null) {
                product = product.multiply(n);
            }
        }
        return product;
    }

    @Override
    public BigInteger sum() {
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger n : this) {
            if (n != null) {
                sum = sum.add(n);
            }
        }
        return sum;
    }

    @Override
    public abstract BigInteger[] toArray();
}
