package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for BigDecimals
 * and containing inner classes with concrete implementations.
 */
public abstract class BigDecimalCollection extends AbstractBigDecimalCollection implements NumericCollection<BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends BigDecimalCollection {
        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigDecimal>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigDecimal>(numbers));
        }
    }

    /**
     * The collection holding the BigDecimals.
     */
    private final Collection<BigDecimal> numbers;

    /**
     * Private constructor taking a collection with the BigDecimals as its parameter.
     *
     * @param numbers The collection holding the BigDecimals.
     */
    private BigDecimalCollection(final Collection<BigDecimal> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty BigDecimals collection.
     *
     * @return A new empty BigDecimals collection.
     */
    static BigDecimalCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new BigDecimals collection.
     * @return A new BigDecimals collection with the specified BigDecimals.
     */
    static BigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new BigDecimals collection.
     * @return A new BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static BigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return numbers.toArray(EmptyArrays.BIG_DECIMALS);
    }
}
