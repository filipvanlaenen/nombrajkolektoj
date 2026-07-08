package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing integers. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered integers collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a int at a specific position, or with an ordered integers collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to Integer. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedIntegerCollection
        extends ModifiableOrderedNumericCollection<Integer>, ModifiableIntegerCollection, OrderedIntegerCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<Integer> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public ArrayCollection(final Integer... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Integer>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Integer>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Integer> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same integers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Integer> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Integer>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<Integer> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public LinkedListCollection(final Integer... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Integer>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<Integer> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Integer>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same integers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }
    }

    /**
     * Returns a new empty modifiable integers collection.
     *
     * @return A new empty modifiable integers collection.
     */
    static ModifiableOrderedIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified integers.
     *
     * @param numbers The integers for the new modifiable ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified integers.
     */
    static ModifiableOrderedIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new modifiable ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified element cardinality and the integers.
     */
    static ModifiableOrderedIntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified element cardinality and the integers.
     */
    static ModifiableOrderedIntegerCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered integers collection cloned from the provided ordered integers collection.
     *
     * @param collection The original ordered integers collection.
     * @return A new modifiable ordered integers collection cloned from the provided ordered integers collection.
     */
    static ModifiableOrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered integers collection cloned from a range in the provided ordered integers
     * collection.
     *
     * @param collection The original ordered integers collection.
     * @param fromIndex  The index of the first element to be included in the new ordered integers collection.
     * @param toIndex    The index of the first element not to be included in the new ordered integers collection.
     * @return A new modifiable ordered integers collection cloned from a range in the provided ordered integers
     *         collection.
     */
    static ModifiableOrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedIntegerCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified element cardinality containing all the
     * elements from the provided ordered integers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered integers collections from which to copy all the elements.
     * @return A new modifiable ordered integers collection with the specified element cardinality containing all the
     *         elements from the provided ordered integers collections.
     */
    static ModifiableOrderedIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Integer>... collections) {
        ModifiableOrderedIntegerCollection result = ModifiableOrderedIntegerCollection.of(elementCardinality);
        for (OrderedNumericCollection<Integer> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered integers collection containing all the elements from the provided ordered integers
     * collections.
     *
     * @param collections The ordered integers collections from which to copy all the elements.
     * @return A new modifiable ordered integers collection containing all the elements from the provided ordered integers
     *         collections.
     */
    static ModifiableOrderedIntegerCollection unionOf(final OrderedNumericCollection<Integer>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
