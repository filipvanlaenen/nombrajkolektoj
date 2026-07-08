package net.filipvanlaenen.nombrajkolektoj.longs;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing longs. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered longs collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a long at a specific position, or with an ordered longs collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to Long. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedLongCollection
        extends ModifiableOrderedNumericCollection<Long>, ModifiableLongCollection, OrderedLongCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedLongCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<Long> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public ArrayCollection(final Long... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Long>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Long>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Long> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same longs and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Long> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Long>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedLongCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<Long> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Long> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public LinkedListCollection(final Long... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Long>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<Long> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Long>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Long>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same longs and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }
    }

    /**
     * Returns a new empty modifiable longs collection.
     *
     * @return A new empty modifiable longs collection.
     */
    static ModifiableOrderedLongCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered longs collection with the specified longs.
     *
     * @param numbers The longs for the new modifiable ordered longs collection.
     * @return A new modifiable ordered longs collection with the specified longs.
     */
    static ModifiableOrderedLongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new modifiable ordered longs collection.
     * @return A new modifiable ordered longs collection with the specified element cardinality and the longs.
     */
    static ModifiableOrderedLongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered longs collection.
     * @return A new modifiable ordered longs collection with the specified element cardinality and the longs.
     */
    static ModifiableOrderedLongCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Long> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered longs collection cloned from the provided ordered longs collection.
     *
     * @param collection The original ordered longs collection.
     * @return A new modifiable ordered longs collection cloned from the provided ordered longs collection.
     */
    static ModifiableOrderedLongCollection of(final OrderedNumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered longs collection cloned from a range in the provided ordered longs
     * collection.
     *
     * @param collection The original ordered longs collection.
     * @param fromIndex  The index of the first element to be included in the new ordered longs collection.
     * @param toIndex    The index of the first element not to be included in the new ordered longs collection.
     * @return A new modifiable ordered longs collection cloned from a range in the provided ordered longs
     *         collection.
     */
    static ModifiableOrderedLongCollection of(final OrderedNumericCollection<Long> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedLongCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered longs collection with the specified element cardinality containing all the
     * elements from the provided ordered longs collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered longs collections from which to copy all the elements.
     * @return A new modifiable ordered longs collection with the specified element cardinality containing all the
     *         elements from the provided ordered longs collections.
     */
    static ModifiableOrderedLongCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Long>... collections) {
        ModifiableOrderedLongCollection result = ModifiableOrderedLongCollection.of(elementCardinality);
        for (OrderedNumericCollection<Long> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered longs collection containing all the elements from the provided ordered longs
     * collections.
     *
     * @param collections The ordered longs collections from which to copy all the elements.
     * @return A new modifiable ordered longs collection containing all the elements from the provided ordered longs
     *         collections.
     */
    static ModifiableOrderedLongCollection unionOf(final OrderedNumericCollection<Long>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
