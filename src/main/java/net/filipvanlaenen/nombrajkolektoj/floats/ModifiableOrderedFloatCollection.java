package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing floats. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered floats collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a float at a specific position, or with an ordered floats collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to Float. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedFloatCollection
        extends ModifiableOrderedNumericCollection<Float>, ModifiableFloatCollection, OrderedFloatCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedFloatCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<Float> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public ArrayCollection(final Float... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Float>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Float>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Float> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Float>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same floats and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Float> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Float>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedFloatCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<Float> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public LinkedListCollection(final Float... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Float>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<Float> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Float>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Float>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same floats and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }
    }

    /**
     * Returns a new empty modifiable floats collection.
     *
     * @return A new empty modifiable floats collection.
     */
    static ModifiableOrderedFloatCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified floats.
     *
     * @param numbers The floats for the new modifiable ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified floats.
     */
    static ModifiableOrderedFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new modifiable ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified element cardinality and the floats.
     */
    static ModifiableOrderedFloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified element cardinality and the floats.
     */
    static ModifiableOrderedFloatCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered floats collection cloned from the provided ordered floats collection.
     *
     * @param collection The original ordered floats collection.
     * @return A new modifiable ordered floats collection cloned from the provided ordered floats collection.
     */
    static ModifiableOrderedFloatCollection of(final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered floats collection cloned from a range in the provided ordered floats
     * collection.
     *
     * @param collection The original ordered floats collection.
     * @param fromIndex  The index of the first element to be included in the new ordered floats collection.
     * @param toIndex    The index of the first element not to be included in the new ordered floats collection.
     * @return A new modifiable ordered floats collection cloned from a range in the provided ordered floats
     *         collection.
     */
    static ModifiableOrderedFloatCollection of(final OrderedNumericCollection<Float> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedFloatCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality containing all the
     * elements from the provided ordered floats collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered floats collections from which to copy all the elements.
     * @return A new modifiable ordered floats collection with the specified element cardinality containing all the
     *         elements from the provided ordered floats collections.
     */
    static ModifiableOrderedFloatCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Float>... collections) {
        ModifiableOrderedFloatCollection result = ModifiableOrderedFloatCollection.of(elementCardinality);
        for (OrderedNumericCollection<Float> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered floats collection containing all the elements from the provided ordered floats
     * collections.
     *
     * @param collections The ordered floats collections from which to copy all the elements.
     * @return A new modifiable ordered floats collection containing all the elements from the provided ordered floats
     *         collections.
     */
    static ModifiableOrderedFloatCollection unionOf(final OrderedNumericCollection<Float>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
