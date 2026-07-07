package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for doubles and containing inner classes with concrete implementations.
 */
public interface ModifiableDoubleCollection extends ModifiableNumericCollection<Double>, DoubleCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableDoubleCollectionDecorator {
        private ModifiableArrayCollection<Double> decoratedCollection;

        @Override
        ModifiableCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Double> source) {
            decoratedCollection = new ModifiableArrayCollection<Double>(source);
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Double>(numbers);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            decoratedCollection = new ModifiableArrayCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Double>(elementCardinality, numbers);
        }
    }

    /**
     * Inner class using a hash backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class HashCollection extends ModifiableDoubleCollectionDecorator {
        private ModifiableHashCollection<Double> decoratedCollection;

        @Override
        ModifiableCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Double> source) {
            decoratedCollection = new ModifiableHashCollection<Double>(source);
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public HashCollection(final Double... numbers) {
            decoratedCollection = new ModifiableHashCollection<Double>(numbers);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            decoratedCollection = new ModifiableHashCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new ModifiableHashCollection<Double>(elementCardinality, numbers);
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableDoubleCollectionDecorator {
        private ModifiableLinkedListCollection<Double> decoratedCollection;

        @Override
        ModifiableCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Double> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Double>(source);
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public LinkedListCollection(final Double... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Double>(numbers);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Double>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable doubles collection.
     *
     * @return A new empty modifiable doubles collection.
     */
    public static ModifiableDoubleCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable doubles collection containing all the elements present in each of the provided doubles
     * collections.
     *
     * @param collections The doubles collections from which to calculate the intersection.
     * @return A new modifiable doubles collection containing all the elements present in each of the provided doubles
     *         collections.
     */

    public static ModifiableDoubleCollection intersectionOf(final NumericCollection<Double>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new modifiable doubles collection.
     * @return A new modifiable doubles collection with the specified doubles.
     */
    public static ModifiableDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new modifiable doubles collection.
     * @return A new modifiable doubles collection with the specified element cardinality and the doubles.
     */
    public static ModifiableDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original doubles collection.
     * @return A new modifiable doubles collection with the specified element cardinality and the doubles.
     */
    public static ModifiableDoubleCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new doubles modifiable collection cloned from the provided doubles collection.
     *
     * @param collection The original doubles collection.
     * @return A new modifiable doubles collection cloned from the provided doubles collection.
     */
    public static ModifiableDoubleCollection of(final NumericCollection<Double> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable doubles collection with the specified element cardinality containing all the elements
     * from the provided doubles collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The doubles collections from which to copy all the elements.
     * @return A new modifiable doubles collection with the specified element cardinality containing all the elements
     *         from the provided doubles collections.
     */
    public static ModifiableDoubleCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Double>... collections) {
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(elementCardinality);
        for (NumericCollection<Double> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable doubles collection containing all the elements from the provided doubles collections.
     *
     * @param collections The doubles collections from which to copy all the elements.
     * @return A new modifiable doubles collection containing all the elements from the provided doubles collections.
     */

    public static ModifiableDoubleCollection unionOf(final NumericCollection<Double>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
