package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for floats and containing inner classes with concrete implementations.
 */
public interface ModifiableOrderedFloatCollection
        extends ModifiableOrderedNumericCollection<Float>, ModifiableFloatCollection, OrderedFloatCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedFloatCollectionDecorator {
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
    public static final class LinkedListCollection extends ModifiableOrderedFloatCollectionDecorator {
        private ModifiableOrderedLinkedListCollection<Float> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
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
         * Constructs a modifiable ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public LinkedListCollection(final Float... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Float>(numbers);
        }
    }

    /**
     * Returns a new empty modifiable floats collection.
     *
     * @return A new empty modifiable floats collection.
     */
    public static ModifiableOrderedFloatCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified floats.
     *
     * @param numbers The floats for the new modifiable ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified floats.
     */
    public static ModifiableOrderedFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new modifiable ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified element cardinality and the floats.
     */
    public static ModifiableOrderedFloatCollection of(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified element cardinality and the floats.
     */
    public static ModifiableOrderedFloatCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered floats collection cloned from the provided ordered floats collection.
     *
     * @param collection The original ordered floats collection.
     * @return A new modifiable ordered floats collection cloned from the provided ordered floats collection.
     */
    public static ModifiableOrderedFloatCollection of(final OrderedNumericCollection<Float> collection) {
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
    public static ModifiableOrderedFloatCollection of(final OrderedNumericCollection<Float> collection,
            final int fromIndex, final int toIndex) {
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
    public static ModifiableOrderedFloatCollection unionOf(final ElementCardinality elementCardinality,
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
    public static ModifiableOrderedFloatCollection unionOf(final OrderedNumericCollection<Float>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

}
