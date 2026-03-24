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
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(source));
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

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<BigInteger> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(elementCardinality, source));
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
    }

    /**
     * Returns a new empty BigIntegers collection.
     *
     * @return A new empty BigIntegers collection.
     */
    public static BigIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new BigIntegers collection containing all the elements present in each of the provided BigIntegers collections.
     *
     * @param collections The BigIntegers collections from which to calculate the intersection.
     * @return A new BigIntegers collection containing all the elements present in each of the provided BigIntegers collections.
     */
    public static BigIntegerCollection intersectionOf(final NumericCollection<BigInteger>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableBigIntegerCollection result = ModifiableBigIntegerCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
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

    /**
     * Returns a new BigIntegers collection with the specified element cardinality cloned from the provided BigIntegers
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original BigIntegers collection.
     * @return A new BigIntegers collection with the specified element cardinality cloned from the provided BigIntegers
     *         collection.
     */
    public static BigIntegerCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, collection);
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
     * Returns a new BigIntegers collection containing all the elements from the provided BigIntegers collections.
     *
     * @param collections The BigIntegers collections from which to copy all the elements.
     * @return A new BigIntegers collection containing all the elements from the provided BigIntegers collections.
     */
    public static BigIntegerCollection unionOf(final NumericCollection<BigInteger>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new BigIntegers collection with the specified element cardinality containing all the elements from the
     * provided BigIntegers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The BigIntegers collections from which to copy all the elements.
     * @return A new BigIntegers collection with the specified element cardinality containing all the elements from the
     *         provided BigIntegers collections.
     */
    public static BigIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger>... collections) {
        ModifiableBigIntegerCollection result = ModifiableBigIntegerCollection.of(elementCardinality);
        for (NumericCollection<BigInteger> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
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
