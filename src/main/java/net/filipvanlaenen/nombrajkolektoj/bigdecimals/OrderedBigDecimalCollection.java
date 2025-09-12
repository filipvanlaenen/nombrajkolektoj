package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class OrderedBigDecimalCollection extends AbstractOrderedBigDecimalCollection
        implements OrderedNumericCollection<BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedBigDecimalCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same BigDecimals and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs an ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the ordered collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal>(numbers));
        }
    }

    /**
     * The ordered collection holding the BigDecimals.
     */
    private final OrderedCollection<BigDecimal> collection;

    /**
     * Private constructor taking an ordered collection with the BigDecimals as its parameter.
     *
     * @param numbers The ordered collection holding the BigDecimals.
     */
    private OrderedBigDecimalCollection(final OrderedCollection<BigDecimal> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty ordered BigDecimals collection.
     *
     * @return A new empty ordered BigDecimals collection.
     */
    static OrderedBigDecimalCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final BigDecimal element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection with the specified BigDecimals.
     */
    static OrderedBigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static OrderedBigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return collection.toArray(EmptyArrays.BIG_DECIMALS);
    }
}
