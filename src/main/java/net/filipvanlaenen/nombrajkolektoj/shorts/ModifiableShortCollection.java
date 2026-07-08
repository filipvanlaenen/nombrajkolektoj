package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A modifiable numeric collection containing shorts. In addition to the functionality of modifiable collections in
 * general and shorts collections, it supports augmenting, subtracting, multiplying and dividing the collection with a
 * number, and negating it.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * binding the type parameter to Short. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}, and factory methods mirroring the
 * factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableCollection}.
 */
public interface ModifiableShortCollection extends ModifiableNumericCollection<Short>, ShortCollection {
    /**
     * A modifiable numeric collection containing shorts and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection}.
     */
    final class ArrayCollection extends ModifiableShortCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableArrayCollection<Short> decoratedCollection;

        @Override
        ModifiableCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same shorts and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Short> source) {
            decoratedCollection = new ModifiableArrayCollection<Short>(source);
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public ArrayCollection(final Short... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Short>(numbers);
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Short> source) {
            decoratedCollection = new ModifiableArrayCollection<Short>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Short>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing shorts and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}.
     */
    final class HashCollection extends ModifiableShortCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableHashCollection<Short> decoratedCollection;

        @Override
        ModifiableCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same shorts and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Short> source) {
            decoratedCollection = new ModifiableHashCollection<Short>(source);
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public HashCollection(final Short... numbers) {
            decoratedCollection = new ModifiableHashCollection<Short>(numbers);
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Short> source) {
            decoratedCollection = new ModifiableHashCollection<Short>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            decoratedCollection = new ModifiableHashCollection<Short>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing shorts and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}.
     */
    final class LinkedListCollection extends ModifiableShortCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableLinkedListCollection<Short> decoratedCollection;

        @Override
        ModifiableCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same shorts and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Short> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Short>(source);
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public LinkedListCollection(final Short... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Short>(numbers);
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Short> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Short>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Short>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable shorts collection.
     *
     * @return A new empty modifiable shorts collection.
     */
    static ModifiableShortCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable shorts collection containing all the elements present in each of the provided shorts
     * collections.
     *
     * @param collections The shorts collections from which to calculate the intersection.
     * @return A new modifiable shorts collection containing all the elements present in each of the provided shorts
     *         collections.
     */
    static ModifiableShortCollection intersectionOf(final NumericCollection<Short>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableShortCollection result = ModifiableShortCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable shorts collection with the specified shorts.
     *
     * @param numbers The shorts for the new modifiable shorts collection.
     * @return A new modifiable shorts collection with the specified shorts.
     */
    static ModifiableShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new modifiable shorts collection.
     * @return A new modifiable shorts collection with the specified element cardinality and the shorts.
     */
    static ModifiableShortCollection of(final ElementCardinality elementCardinality, final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original shorts collection.
     * @return A new modifiable shorts collection with the specified element cardinality and the shorts.
     */
    static ModifiableShortCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Short> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new shorts modifiable collection cloned from the provided shorts collection.
     *
     * @param collection The original shorts collection.
     * @return A new modifiable shorts collection cloned from the provided shorts collection.
     */
    static ModifiableShortCollection of(final NumericCollection<Short> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable shorts collection with the specified element cardinality containing all the elements
     * from the provided shorts collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The shorts collections from which to copy all the elements.
     * @return A new modifiable shorts collection with the specified element cardinality containing all the elements
     *         from the provided shorts collections.
     */
    static ModifiableShortCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Short>... collections) {
        ModifiableShortCollection result = ModifiableShortCollection.of(elementCardinality);
        for (NumericCollection<Short> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable shorts collection containing all the elements from the provided shorts collections.
     *
     * @param collections The shorts collections from which to copy all the elements.
     * @return A new modifiable shorts collection containing all the elements from the provided shorts collections.
     */
    static ModifiableShortCollection unionOf(final NumericCollection<Short>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
