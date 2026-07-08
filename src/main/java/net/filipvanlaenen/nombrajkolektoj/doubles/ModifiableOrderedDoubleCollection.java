package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing doubles. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered doubles collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a double at a specific position, or with an ordered doubles collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to Double. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedDoubleCollection
        extends ModifiableOrderedNumericCollection<Double>, ModifiableDoubleCollection, OrderedDoubleCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<Double> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Double>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Double>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Double> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same doubles and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Double> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Double>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<Double> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public LinkedListCollection(final Double... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Double>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<Double> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Double>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same doubles and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }
    }

    /**
     * Returns a new empty modifiable doubles collection.
     *
     * @return A new empty modifiable doubles collection.
     */
    static ModifiableOrderedDoubleCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new modifiable ordered doubles collection.
     * @return A new modifiable ordered doubles collection with the specified doubles.
     */
    static ModifiableOrderedDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new modifiable ordered doubles collection.
     * @return A new modifiable ordered doubles collection with the specified element cardinality and the doubles.
     */
    static ModifiableOrderedDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered doubles collection.
     * @return A new modifiable ordered doubles collection with the specified element cardinality and the doubles.
     */
    static ModifiableOrderedDoubleCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered doubles collection cloned from the provided ordered doubles collection.
     *
     * @param collection The original ordered doubles collection.
     * @return A new modifiable ordered doubles collection cloned from the provided ordered doubles collection.
     */
    static ModifiableOrderedDoubleCollection of(final OrderedNumericCollection<Double> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered doubles collection cloned from a range in the provided ordered doubles
     * collection.
     *
     * @param collection The original ordered doubles collection.
     * @param fromIndex  The index of the first element to be included in the new ordered doubles collection.
     * @param toIndex    The index of the first element not to be included in the new ordered doubles collection.
     * @return A new modifiable ordered doubles collection cloned from a range in the provided ordered doubles
     *         collection.
     */
    static ModifiableOrderedDoubleCollection of(final OrderedNumericCollection<Double> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedDoubleCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered doubles collection with the specified element cardinality containing all the
     * elements from the provided ordered doubles collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered doubles collections from which to copy all the elements.
     * @return A new modifiable ordered doubles collection with the specified element cardinality containing all the
     *         elements from the provided ordered doubles collections.
     */
    static ModifiableOrderedDoubleCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Double>... collections) {
        ModifiableOrderedDoubleCollection result = ModifiableOrderedDoubleCollection.of(elementCardinality);
        for (OrderedNumericCollection<Double> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered doubles collection containing all the elements from the provided ordered doubles
     * collections.
     *
     * @param collections The ordered doubles collections from which to copy all the elements.
     * @return A new modifiable ordered doubles collection containing all the elements from the provided ordered doubles
     *         collections.
     */
    static ModifiableOrderedDoubleCollection unionOf(final OrderedNumericCollection<Double>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
