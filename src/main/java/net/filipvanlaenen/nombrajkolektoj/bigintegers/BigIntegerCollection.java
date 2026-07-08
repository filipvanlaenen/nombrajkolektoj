package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A numeric collection containing BigIntegers. In addition to the functionality of collections in general, it supports
 * calculating the sum and the product of the numbers it contains, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface binding the
 * type parameter to BigInteger. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection} and one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.Collection}.
 */
public interface BigIntegerCollection extends NumericCollection<BigInteger> {
    /**
     * A numeric collection containing BigIntegers and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}.
     */
    final class ArrayCollection extends BigIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigInteger> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(source);
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<BigInteger> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(elementCardinality, numbers);
        }

        @Override
        Collection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * A numeric collection containing BigIntegers and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}.
     */
    final class HashCollection extends BigIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.hash.HashCollection<BigInteger> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<BigInteger> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<BigInteger>(source);
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public HashCollection(final BigInteger... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<BigInteger> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<BigInteger>(elementCardinality, numbers);
        }

        @Override
        Collection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty BigIntegers collection.
     *
     * @return A new empty BigIntegers collection.
     */
    static BigIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new BigIntegers collection containing all the elements present in each of the provided BigIntegers collections.
     *
     * @param collections The BigIntegers collections from which to calculate the intersection.
     * @return A new BigIntegers collection containing all the elements present in each of the provided BigIntegers collections.
     */
    static BigIntegerCollection intersectionOf(final NumericCollection<BigInteger>... collections) {
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
    static BigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new BigIntegers collection.
     * @return A new BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static BigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
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
    static BigIntegerCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new BigIntegers collection cloned from the provided BigIntegers collection.
     *
     * @param collection The original BigIntegers collection.
     * @return A new BigIntegers collection cloned from the provided BigIntegers collection.
     */
    static BigIntegerCollection of(final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new BigIntegers collection containing all the elements from the provided BigIntegers collections.
     *
     * @param collections The BigIntegers collections from which to copy all the elements.
     * @return A new BigIntegers collection containing all the elements from the provided BigIntegers collections.
     */
    static BigIntegerCollection unionOf(final NumericCollection<BigInteger>... collections) {
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
    static BigIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger>... collections) {
        ModifiableBigIntegerCollection result = ModifiableBigIntegerCollection.of(elementCardinality);
        for (NumericCollection<BigInteger> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }
}
