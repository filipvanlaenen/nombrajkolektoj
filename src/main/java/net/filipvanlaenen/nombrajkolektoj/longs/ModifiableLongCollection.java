package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for longs and containing inner classes with concrete implementations.
 */
public interface ModifiableLongCollection extends ModifiableNumericCollection<Long>, LongCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableLongCollectionDecorator {
        private ModifiableArrayCollection<Long> decoratedCollection;

        @Override
        ModifiableCollection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Long> source) {
            decoratedCollection = new ModifiableArrayCollection<Long>(source);
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public ArrayCollection(final Long... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Long>(numbers);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Long> source) {
            decoratedCollection = new ModifiableArrayCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Long>(elementCardinality, numbers);
        }
    }

    /**
     * Inner class using a hash backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class HashCollection extends ModifiableLongCollectionDecorator {
        private ModifiableHashCollection<Long> decoratedCollection;

        @Override
        ModifiableCollection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Long> source) {
            decoratedCollection = new ModifiableHashCollection<Long>(source);
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public HashCollection(final Long... numbers) {
            decoratedCollection = new ModifiableHashCollection<Long>(numbers);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Long> source) {
            decoratedCollection = new ModifiableHashCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection = new ModifiableHashCollection<Long>(elementCardinality, numbers);
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableLongCollectionDecorator {
        private ModifiableLinkedListCollection<Long> decoratedCollection;

        @Override
        ModifiableCollection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Long> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Long>(source);
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public LinkedListCollection(final Long... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Long>(numbers);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Long> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Long>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable longs collection.
     *
     * @return A new empty modifiable longs collection.
     */
    public static ModifiableLongCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable longs collection containing all the elements present in each of the provided longs
     * collections.
     *
     * @param collections The longs collections from which to calculate the intersection.
     * @return A new modifiable longs collection containing all the elements present in each of the provided longs
     *         collections.
     */

    public static ModifiableLongCollection intersectionOf(final NumericCollection<Long>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableLongCollection result = ModifiableLongCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable longs collection with the specified longs.
     *
     * @param numbers The longs for the new modifiable longs collection.
     * @return A new modifiable longs collection with the specified longs.
     */
    public static ModifiableLongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new modifiable longs collection.
     * @return A new modifiable longs collection with the specified element cardinality and the longs.
     */
    public static ModifiableLongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original longs collection.
     * @return A new modifiable longs collection with the specified element cardinality and the longs.
     */
    public static ModifiableLongCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Long> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new longs modifiable collection cloned from the provided longs collection.
     *
     * @param collection The original longs collection.
     * @return A new modifiable longs collection cloned from the provided longs collection.
     */
    public static ModifiableLongCollection of(final NumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable longs collection with the specified element cardinality containing all the elements
     * from the provided longs collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The longs collections from which to copy all the elements.
     * @return A new modifiable longs collection with the specified element cardinality containing all the elements
     *         from the provided longs collections.
     */
    public static ModifiableLongCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Long>... collections) {
        ModifiableLongCollection result = ModifiableLongCollection.of(elementCardinality);
        for (NumericCollection<Long> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable longs collection containing all the elements from the provided longs collections.
     *
     * @param collections The longs collections from which to copy all the elements.
     * @return A new modifiable longs collection containing all the elements from the provided longs collections.
     */

    public static ModifiableLongCollection unionOf(final NumericCollection<Long>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
