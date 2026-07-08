package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalCollection} interface.
 */
abstract class BigDecimalCollectionDecorator implements BigDecimalCollection {
    @Override
    public boolean contains(final BigDecimal element) {
        return getDecoratedCollection().contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return getDecoratedCollection().containsAll(collection);
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return getDecoratedCollection().get();
    }

    /**
     * Returns the internal decorated collection.
     *
     * @return The internal decorated collection
     */
    abstract Collection<BigDecimal> getDecoratedCollection();

    @Override
    public ElementCardinality getElementCardinality() {
        return getDecoratedCollection().getElementCardinality();
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return getDecoratedCollection().iterator();
    }

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
    public int size() {
        return getDecoratedCollection().size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return getDecoratedCollection().spliterator();
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
    public BigDecimal[] toArray() {
        return getDecoratedCollection().toArray(EmptyArrays.BIG_DECIMALS);
    }
}
