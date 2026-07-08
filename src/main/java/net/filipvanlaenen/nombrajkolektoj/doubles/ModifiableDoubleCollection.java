package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A modifiable numeric collection containing doubles. In addition to the functionality of modifiable collections in
 * general and doubles collections, it supports augmenting, subtracting, multiplying and dividing the collection with a
 * number, and negating it.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * binding the type parameter to Double. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}, and factory methods mirroring the
 * factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableCollection}.
 */
public interface ModifiableDoubleCollection extends ModifiableNumericCollection<Double>, DoubleCollection {
    /**
     * A modifiable numeric collection containing doubles and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection}.
     */
    final class ArrayCollection extends ModifiableDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
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
     * A modifiable numeric collection containing doubles and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}.
     */
    final class HashCollection extends ModifiableDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
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
     * A modifiable numeric collection containing doubles and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}.
     */
    final class LinkedListCollection extends ModifiableDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
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
    static ModifiableDoubleCollection empty() {
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
    static ModifiableDoubleCollection intersectionOf(final NumericCollection<Double>... collections) {
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
    static ModifiableDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new modifiable doubles collection.
     * @return A new modifiable doubles collection with the specified element cardinality and the doubles.
     */
    static ModifiableDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original doubles collection.
     * @return A new modifiable doubles collection with the specified element cardinality and the doubles.
     */
    static ModifiableDoubleCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new doubles modifiable collection cloned from the provided doubles collection.
     *
     * @param collection The original doubles collection.
     * @return A new modifiable doubles collection cloned from the provided doubles collection.
     */
    static ModifiableDoubleCollection of(final NumericCollection<Double> collection) {
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
    static ModifiableDoubleCollection unionOf(final ElementCardinality elementCardinality,
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
    static ModifiableDoubleCollection unionOf(final NumericCollection<Double>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
