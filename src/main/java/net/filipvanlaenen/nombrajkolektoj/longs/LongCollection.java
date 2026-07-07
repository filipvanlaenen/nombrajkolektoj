package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for longs
 * and containing inner classes with concrete implementations.
 */
public interface LongCollection extends NumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends LongCollectionDecorator {
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
     * Inner class using a hash backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class HashCollection extends LongCollectionDecorator {
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
    public static LongCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new longs collection containing all the elements present in each of the provided longs collections.
     *
     * @param collections The longs collections from which to calculate the intersection.
     * @return A new longs collection containing all the elements present in each of the provided longs collections.
     */
    public static LongCollection intersectionOf(final NumericCollection<Long>... collections) {
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
    public static LongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new longs collection.
     * @return A new longs collection with the specified element cardinality and the longs.
     */
    public static LongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
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
    public static LongCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Long> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new longs collection cloned from the provided longs collection.
     *
     * @param collection The original longs collection.
     * @return A new longs collection cloned from the provided longs collection.
     */
    public static LongCollection of(final NumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new longs collection containing all the elements from the provided longs collections.
     *
     * @param collections The longs collections from which to copy all the elements.
     * @return A new longs collection containing all the elements from the provided longs collections.
     */
    public static LongCollection unionOf(final NumericCollection<Long>... collections) {
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
    public static LongCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Long>... collections) {
        ModifiableLongCollection result = ModifiableLongCollection.of(elementCardinality);
        for (NumericCollection<Long> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }
}
