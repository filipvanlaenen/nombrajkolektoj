package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A modifiable numeric collection containing integers. In addition to the functionality of modifiable collections in
 * general and integers collections, it supports augmenting, subtracting, multiplying and dividing the collection with a
 * number, and negating it.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * binding the type parameter to Integer. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}, and factory methods mirroring the
 * factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableCollection}.
 */
public interface ModifiableIntegerCollection extends ModifiableNumericCollection<Integer>, IntegerCollection {
    /**
     * A modifiable numeric collection containing integers and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection}.
     */
    final class ArrayCollection extends ModifiableIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableArrayCollection<Integer> decoratedCollection;

        @Override
        ModifiableCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Integer> source) {
            decoratedCollection = new ModifiableArrayCollection<Integer>(source);
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public ArrayCollection(final Integer... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Integer>(numbers);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Integer> source) {
            decoratedCollection = new ModifiableArrayCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Integer>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing integers and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}.
     */
    final class HashCollection extends ModifiableIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableHashCollection<Integer> decoratedCollection;

        @Override
        ModifiableCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Integer> source) {
            decoratedCollection = new ModifiableHashCollection<Integer>(source);
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public HashCollection(final Integer... numbers) {
            decoratedCollection = new ModifiableHashCollection<Integer>(numbers);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Integer> source) {
            decoratedCollection = new ModifiableHashCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection = new ModifiableHashCollection<Integer>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing integers and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}.
     */
    final class LinkedListCollection extends ModifiableIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableLinkedListCollection<Integer> decoratedCollection;

        @Override
        ModifiableCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Integer> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Integer>(source);
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public LinkedListCollection(final Integer... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Integer>(numbers);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Integer> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Integer>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable integers collection.
     *
     * @return A new empty modifiable integers collection.
     */
    static ModifiableIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable integers collection containing all the elements present in each of the provided integers
     * collections.
     *
     * @param collections The integers collections from which to calculate the intersection.
     * @return A new modifiable integers collection containing all the elements present in each of the provided integers
     *         collections.
     */
    static ModifiableIntegerCollection intersectionOf(final NumericCollection<Integer>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableIntegerCollection result = ModifiableIntegerCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable integers collection with the specified integers.
     *
     * @param numbers The integers for the new modifiable integers collection.
     * @return A new modifiable integers collection with the specified integers.
     */
    static ModifiableIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new modifiable integers collection.
     * @return A new modifiable integers collection with the specified element cardinality and the integers.
     */
    static ModifiableIntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original integers collection.
     * @return A new modifiable integers collection with the specified element cardinality and the integers.
     */
    static ModifiableIntegerCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new integers modifiable collection cloned from the provided integers collection.
     *
     * @param collection The original integers collection.
     * @return A new modifiable integers collection cloned from the provided integers collection.
     */
    static ModifiableIntegerCollection of(final NumericCollection<Integer> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable integers collection with the specified element cardinality containing all the elements
     * from the provided integers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The integers collections from which to copy all the elements.
     * @return A new modifiable integers collection with the specified element cardinality containing all the elements
     *         from the provided integers collections.
     */
    static ModifiableIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Integer>... collections) {
        ModifiableIntegerCollection result = ModifiableIntegerCollection.of(elementCardinality);
        for (NumericCollection<Integer> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable integers collection containing all the elements from the provided integers collections.
     *
     * @param collections The integers collections from which to copy all the elements.
     * @return A new modifiable integers collection containing all the elements from the provided integers collections.
     */
    static ModifiableIntegerCollection unionOf(final NumericCollection<Integer>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
