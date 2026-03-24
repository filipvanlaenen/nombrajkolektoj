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
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigDecimal>(source));
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

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<BigDecimal> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigDecimal>(elementCardinality, source));
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
    }

    /**
     * Returns a new empty BigDecimals collection.
     *
     * @return A new empty BigDecimals collection.
     */
    public static BigDecimalCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new BigDecimals collection containing all the elements present in each of the provided BigDecimals collections.
     *
     * @param collections The BigDecimals collections from which to calculate the intersection.
     * @return A new BigDecimals collection containing all the elements present in each of the provided BigDecimals collections.
     */
    public static BigDecimalCollection intersectionOf(final NumericCollection<BigDecimal>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableBigDecimalCollection result = ModifiableBigDecimalCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new BigDecimals collection.
     * @return A new BigDecimals collection with the specified BigDecimals.
     */
    public static BigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new BigDecimals collection.
     * @return A new BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    public static BigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new BigDecimals collection with the specified element cardinality cloned from the provided BigDecimals
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original BigDecimals collection.
     * @return A new BigDecimals collection with the specified element cardinality cloned from the provided BigDecimals
     *         collection.
     */
    public static BigDecimalCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new BigDecimals collection cloned from the provided BigDecimals collection.
     *
     * @param collection The original BigDecimals collection.
     * @return A new BigDecimals collection cloned from the provided BigDecimals collection.
     */
    public static BigDecimalCollection of(final NumericCollection<BigDecimal> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new BigDecimals collection containing all the elements from the provided BigDecimals collections.
     *
     * @param collections The BigDecimals collections from which to copy all the elements.
     * @return A new BigDecimals collection containing all the elements from the provided BigDecimals collections.
     */
    public static BigDecimalCollection unionOf(final NumericCollection<BigDecimal>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new BigDecimals collection with the specified element cardinality containing all the elements from the
     * provided BigDecimals collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The BigDecimals collections from which to copy all the elements.
     * @return A new BigDecimals collection with the specified element cardinality containing all the elements from the
     *         provided BigDecimals collections.
     */
    public static BigDecimalCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal>... collections) {
        ModifiableBigDecimalCollection result = ModifiableBigDecimalCollection.of(elementCardinality);
        for (NumericCollection<BigDecimal> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
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
