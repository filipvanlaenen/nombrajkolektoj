package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for BigIntegers
 * and containing inner classes with concrete implementations.
 */
public abstract class BigIntegerCollection extends AbstractBigIntegerCollection implements NumericCollection<BigInteger> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends BigIntegerCollection {
        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(numbers));
        }
    }

    /**
     * The collection holding the BigIntegers.
     */
    private final Collection<BigInteger> numbers;

    /**
     * Private constructor taking a collection with the BigIntegers as its parameter.
     *
     * @param numbers The collection holding the BigIntegers.
     */
    private BigIntegerCollection(final Collection<BigInteger> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final BigInteger element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty BigIntegers collection.
     *
     * @return A new empty BigIntegers collection.
     */
    public static BigIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new BigIntegers collection cloned from the provided BigIntegers collection.
     *
     * @param collection The original BigIntegers collection.
     * @return A new BigIntegers collection cloned from the provided BigIntegers collection.
     */
    public static BigIntegerCollection of(final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new BigIntegers collection.
     * @return A new BigIntegers collection with the specified BigIntegers.
     */
    public static BigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new BigIntegers collection.
     * @return A new BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static BigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return numbers.toArray(EmptyArrays.BIG_INTEGERS);
    }
}
