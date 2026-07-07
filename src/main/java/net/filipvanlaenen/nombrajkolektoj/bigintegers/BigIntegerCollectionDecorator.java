package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} for BigIntegers.
 */
abstract class BigIntegerCollectionDecorator implements BigIntegerCollection {
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

    abstract Collection<BigInteger> getDecoratedCollection();

    @Override
    public boolean contains(final BigInteger element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return getDecoratedCollection().iterator();
    }

    @Override
    public int size() {
        return getDecoratedCollection().size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return getDecoratedCollection().spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.BIG_INTEGERS);
    }
}
