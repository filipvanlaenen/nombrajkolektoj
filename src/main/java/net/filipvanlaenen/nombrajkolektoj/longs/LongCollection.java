package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A numeric collection containing longs. In addition to the functionality of collections in general, it supports
 * calculating the sum and the product of the numbers it contains, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface binding the
 * type parameter to Long. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection} and one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.Collection}.
 */
public interface LongCollection extends NumericCollection<Long> {
    /**
     * A numeric collection containing longs and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}.
     */
    final class ArrayCollection extends LongCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.array.ArrayCollection<Long> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Long> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(source);
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public ArrayCollection(final Long... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Long> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(elementCardinality, numbers);
        }

        @Override
        Collection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * A numeric collection containing longs and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.longs.LongCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}.
     */
    final class HashCollection extends LongCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.hash.HashCollection<Long> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Long> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Long>(source);
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public HashCollection(final Long... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Long>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Long> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Long>(elementCardinality, numbers);
        }

        @Override
        Collection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty longs collection.
     *
     * @return A new empty longs collection.
     */
    static LongCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new longs collection containing all the elements present in each of the provided longs collections.
     *
     * @param collections The longs collections from which to calculate the intersection.
     * @return A new longs collection containing all the elements present in each of the provided longs collections.
     */
    static LongCollection intersectionOf(final NumericCollection<Long>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableLongCollection result = ModifiableLongCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new longs collection with the specified longs.
     *
     * @param numbers The longs for the new longs collection.
     * @return A new longs collection with the specified longs.
     */
    static LongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new longs collection.
     * @return A new longs collection with the specified element cardinality and the longs.
     */
    static LongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new longs collection with the specified element cardinality cloned from the provided longs
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original longs collection.
     * @return A new longs collection with the specified element cardinality cloned from the provided longs
     *         collection.
     */
    static LongCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Long> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new longs collection cloned from the provided longs collection.
     *
     * @param collection The original longs collection.
     * @return A new longs collection cloned from the provided longs collection.
     */
    static LongCollection of(final NumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new longs collection containing all the elements from the provided longs collections.
     *
     * @param collections The longs collections from which to copy all the elements.
     * @return A new longs collection containing all the elements from the provided longs collections.
     */
    static LongCollection unionOf(final NumericCollection<Long>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new longs collection with the specified element cardinality containing all the elements from the
     * provided longs collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The longs collections from which to copy all the elements.
     * @return A new longs collection with the specified element cardinality containing all the elements from the
     *         provided longs collections.
     */
    static LongCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Long>... collections) {
        ModifiableLongCollection result = ModifiableLongCollection.of(elementCardinality);
        for (NumericCollection<Long> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }
}
