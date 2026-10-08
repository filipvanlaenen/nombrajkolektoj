package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A numeric collection containing doubles. In addition to the functionality of collections in general, it supports
 * calculating the sum and the product of the numbers it contains, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface binding the
 * type parameter to Double. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection} and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection}, and factory methods mirroring the factory
 * methods of {@link net.filipvanlaenen.kolektoj.Collection}.
 */
public interface DoubleCollection extends NumericCollection<Double> {
    /**
     * A numeric collection containing doubles and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}.
     */
    final class ArrayCollection extends DoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.array.ArrayCollection<Double> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Double> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(source);
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(elementCardinality, numbers);
        }

        @Override
        Collection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * A numeric collection containing doubles and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}.
     */
    final class HashCollection extends DoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.hash.HashCollection<Double> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Double> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Double>(source);
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public HashCollection(final Double... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Double>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Double>(elementCardinality, numbers);
        }

        @Override
        Collection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * A numeric collection containing doubles and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection}.
     */
    final class LinkedListCollection extends DoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection<Double> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Double> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection<Double>(source);
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public LinkedListCollection(final Double... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection<Double>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection<Double>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.linkedlist.LinkedListCollection<Double>(
                    elementCardinality, numbers);
        }

        @Override
        Collection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new doubles collection containing all the elements present in the first doubles collection, but not in
     * any of the other provided doubles collections.
     *
     * This method corresponds to the difference (or relative complement) operation in set theory, denoted by the symbol
     * ∖, with {1, 2, 3} ∖ {2, 3, 4} = {1}.
     *
     * @param collections The doubles collections for which to calculate the difference.
     * @return A new doubles collection containing all the elements present in the first doubles collection, but not in
     *         any of the other provided doubles collections.
     */
    static DoubleCollection differenceOf(final NumericCollection<Double>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.removeAll(collections[i]);
        }
        return of(result);
    }

    /**
     * Returns a new empty doubles collection.
     *
     * @return A new empty doubles collection.
     */
    static DoubleCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new doubles collection containing all the elements present in each of the provided doubles collections.
     *
     * This method corresponds to the intersection operation in set theory, denoted by the symbol ∩, with {1, 2, 3} ∩
     * {2, 3, 4} = {2, 3}.
     *
     * @param collections The doubles collections from which to calculate the intersection.
     * @return A new doubles collection containing all the elements present in each of the provided doubles collections.
     */
    static DoubleCollection intersectionOf(final NumericCollection<Double>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return of(result);
    }

    /**
     * Returns a new doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new doubles collection.
     * @return A new doubles collection with the specified doubles.
     */
    static DoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new doubles collection.
     * @return A new doubles collection with the specified element cardinality and the doubles.
     */
    static DoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality cloned from the provided doubles
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original doubles collection.
     * @return A new doubles collection with the specified element cardinality cloned from the provided doubles
     *         collection.
     */
    static DoubleCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new doubles collection cloned from the provided doubles collection.
     *
     * @param collection The original doubles collection.
     * @return A new doubles collection cloned from the provided doubles collection.
     */
    static DoubleCollection of(final NumericCollection<Double> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality containing all the elements from the
     * provided doubles collections.
     *
     * This method corresponds to the union operation in set theory, denoted by the symbol ∪, with {1, 2, 3} ∪ {2, 3, 4}
     * = {1, 2, 3, 4}. For multisets, allowing duplicate elements, {1, 2, 3} ∪ {2, 3, 4} = {1, 2, 2, 3, 3, 4}.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The doubles collections from which to copy all the elements.
     * @return A new doubles collection with the specified element cardinality containing all the elements from the
     *         provided doubles collections.
     */
    static DoubleCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Double>... collections) {
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(elementCardinality);
        for (NumericCollection<Double> collection : collections) {
            result.addAll(collection);
        }
        return of(result);
    }

    /**
     * Returns a new doubles collection containing all the elements from the provided doubles collections.
     *
     * This method corresponds to the union operation in set theory, denoted by the symbol ∪, with {1, 2, 3} ∪ {2, 3, 4}
     * = {1, 2, 3, 4}. For multisets, allowing duplicate elements, {1, 2, 3} ∪ {2, 3, 4} = {1, 2, 2, 3, 3, 4}.
     *
     * @param collections The doubles collections from which to copy all the elements.
     * @return A new doubles collection containing all the elements from the provided doubles collections.
     */
    static DoubleCollection unionOf(final NumericCollection<Double>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
