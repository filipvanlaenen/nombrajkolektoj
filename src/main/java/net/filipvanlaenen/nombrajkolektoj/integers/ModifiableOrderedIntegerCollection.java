package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for integers and containing inner classes with concrete implementations.
 */
public interface ModifiableOrderedIntegerCollection
        extends ModifiableOrderedNumericCollection<Integer>, ModifiableIntegerCollection, OrderedIntegerCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedIntegerCollectionDecorator {
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
    public static final class LinkedListCollection extends ModifiableOrderedIntegerCollectionDecorator {
        private ModifiableOrderedLinkedListCollection<Integer> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
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
         * Constructs a modifiable ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public LinkedListCollection(final Integer... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Integer>(numbers);
        }
    }

    /**
     * Returns a new empty modifiable integers collection.
     *
     * @return A new empty modifiable integers collection.
     */
    public static ModifiableOrderedIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified integers.
     *
     * @param numbers The integers for the new modifiable ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified integers.
     */
    public static ModifiableOrderedIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new modifiable ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified element cardinality and the integers.
     */
    public static ModifiableOrderedIntegerCollection of(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified element cardinality and the integers.
     */
    public static ModifiableOrderedIntegerCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered integers collection cloned from the provided ordered integers collection.
     *
     * @param collection The original ordered integers collection.
     * @return A new modifiable ordered integers collection cloned from the provided ordered integers collection.
     */
    public static ModifiableOrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection) {
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
    public static ModifiableOrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection,
            final int fromIndex, final int toIndex) {
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
    public static ModifiableOrderedIntegerCollection unionOf(final ElementCardinality elementCardinality,
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
    public static ModifiableOrderedIntegerCollection unionOf(final OrderedNumericCollection<Integer>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

}
