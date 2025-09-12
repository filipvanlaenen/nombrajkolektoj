package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class OrderedBigIntegerCollection extends AbstractOrderedBigIntegerCollection
        implements OrderedNumericCollection<BigInteger> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedBigIntegerCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same BigIntegers and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs an ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigInteger>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the ordered collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigInteger>(numbers));
        }
    }

    /**
     * The ordered collection holding the BigIntegers.
     */
    private final OrderedCollection<BigInteger> collection;

    /**
     * Private constructor taking an ordered collection with the BigIntegers as its parameter.
     *
     * @param numbers The ordered collection holding the BigIntegers.
     */
    private OrderedBigIntegerCollection(final OrderedCollection<BigInteger> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final BigInteger element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty ordered BigIntegers collection.
     *
     * @return A new empty ordered BigIntegers collection.
     */
    static OrderedBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final BigInteger element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final BigInteger element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigInteger element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new ordered BigIntegers collection.
     * @return A new ordered BigIntegers collection with the specified BigIntegers.
     */
    static OrderedBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new ordered BigIntegers collection.
     * @return A new ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static OrderedBigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return collection.toArray(EmptyArrays.BIG_INTEGERS);
    }
}
