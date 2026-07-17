package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A modifiable numeric collection containing floats. In addition to the functionality of modifiable collections in
 * general and floats collections, it supports augmenting, subtracting, multiplying and dividing the collection with a
 * number, and negating it.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * binding the type parameter to Float. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}, and factory methods mirroring the
 * factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableCollection}.
 */
public interface ModifiableFloatCollection extends ModifiableNumericCollection<Float>, FloatCollection {
    /**
     * A modifiable numeric collection containing floats and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection}.
     */
    final class ArrayCollection extends ModifiableFloatCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableArrayCollection<Float> decoratedCollection;

        @Override
        ModifiableCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same floats and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Float> source) {
            decoratedCollection = new ModifiableArrayCollection<Float>(source);
        }

        /**
         * Constructs a collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public ArrayCollection(final Float... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Float>(numbers);
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Float> source) {
            decoratedCollection = new ModifiableArrayCollection<Float>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Float>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing floats and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}.
     */
    final class HashCollection extends ModifiableFloatCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableHashCollection<Float> decoratedCollection;

        @Override
        ModifiableCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same floats and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Float> source) {
            decoratedCollection = new ModifiableHashCollection<Float>(source);
        }

        /**
         * Constructs a collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public HashCollection(final Float... numbers) {
            decoratedCollection = new ModifiableHashCollection<Float>(numbers);
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Float> source) {
            decoratedCollection = new ModifiableHashCollection<Float>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            decoratedCollection = new ModifiableHashCollection<Float>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing floats and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}.
     */
    final class LinkedListCollection extends ModifiableFloatCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableLinkedListCollection<Float> decoratedCollection;

        @Override
        ModifiableCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same floats and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Float> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Float>(source);
        }

        /**
         * Constructs a collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public LinkedListCollection(final Float... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Float>(numbers);
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Float> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Float>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Float>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable floats collection.
     *
     * @return A new empty modifiable floats collection.
     */
    static ModifiableFloatCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable floats collection containing all the elements present in each of the provided floats
     * collections.
     *
     * @param collections The floats collections from which to calculate the intersection.
     * @return A new modifiable floats collection containing all the elements present in each of the provided floats
     *         collections.
     */
    static ModifiableFloatCollection intersectionOf(final NumericCollection<Float>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableFloatCollection result = ModifiableFloatCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable floats collection with the specified floats.
     *
     * @param numbers The floats for the new modifiable floats collection.
     * @return A new modifiable floats collection with the specified floats.
     */
    static ModifiableFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new modifiable floats collection.
     * @return A new modifiable floats collection with the specified element cardinality and the floats.
     */
    static ModifiableFloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original floats collection.
     * @return A new modifiable floats collection with the specified element cardinality and the floats.
     */
    static ModifiableFloatCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Float> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new floats modifiable collection cloned from the provided floats collection.
     *
     * @param collection The original floats collection.
     * @return A new modifiable floats collection cloned from the provided floats collection.
     */
    static ModifiableFloatCollection of(final NumericCollection<Float> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable floats collection with the specified element cardinality containing all the elements
     * from the provided floats collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The floats collections from which to copy all the elements.
     * @return A new modifiable floats collection with the specified element cardinality containing all the elements
     *         from the provided floats collections.
     */
    static ModifiableFloatCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Float>... collections) {
        ModifiableFloatCollection result = ModifiableFloatCollection.of(elementCardinality);
        for (NumericCollection<Float> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable floats collection containing all the elements from the provided floats collections.
     *
     * @param collections The floats collections from which to copy all the elements.
     * @return A new modifiable floats collection containing all the elements from the provided floats collections.
     */
    static ModifiableFloatCollection unionOf(final NumericCollection<Float>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
