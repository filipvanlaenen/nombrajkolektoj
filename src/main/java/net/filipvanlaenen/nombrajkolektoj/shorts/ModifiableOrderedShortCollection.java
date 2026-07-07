package net.filipvanlaenen.nombrajkolektoj.shorts;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for shorts and containing inner classes with concrete implementations.
 */
public interface ModifiableOrderedShortCollection
        extends ModifiableOrderedNumericCollection<Short>, ModifiableShortCollection, OrderedShortCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedShortCollectionDecorator {
        private ModifiableOrderedArrayCollection<Short> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public ArrayCollection(final Short... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Short>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Short>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Short> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Short>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same shorts and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Short> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Short>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedShortCollectionDecorator {
        private ModifiableOrderedLinkedListCollection<Short> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same shorts and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Short>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public LinkedListCollection(final Short... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Short>(numbers);
        }
    }

    /**
     * Returns a new empty modifiable shorts collection.
     *
     * @return A new empty modifiable shorts collection.
     */
    public static ModifiableOrderedShortCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered shorts collection with the specified shorts.
     *
     * @param numbers The shorts for the new modifiable ordered shorts collection.
     * @return A new modifiable ordered shorts collection with the specified shorts.
     */
    public static ModifiableOrderedShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new modifiable ordered shorts collection.
     * @return A new modifiable ordered shorts collection with the specified element cardinality and the shorts.
     */
    public static ModifiableOrderedShortCollection of(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered shorts collection.
     * @return A new modifiable ordered shorts collection with the specified element cardinality and the shorts.
     */
    public static ModifiableOrderedShortCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Short> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered shorts collection cloned from the provided ordered shorts collection.
     *
     * @param collection The original ordered shorts collection.
     * @return A new modifiable ordered shorts collection cloned from the provided ordered shorts collection.
     */
    public static ModifiableOrderedShortCollection of(final OrderedNumericCollection<Short> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered shorts collection cloned from a range in the provided ordered shorts
     * collection.
     *
     * @param collection The original ordered shorts collection.
     * @param fromIndex  The index of the first element to be included in the new ordered shorts collection.
     * @param toIndex    The index of the first element not to be included in the new ordered shorts collection.
     * @return A new modifiable ordered shorts collection cloned from a range in the provided ordered shorts
     *         collection.
     */
    public static ModifiableOrderedShortCollection of(final OrderedNumericCollection<Short> collection,
            final int fromIndex, final int toIndex) {
        ModifiableOrderedShortCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered shorts collection with the specified element cardinality containing all the
     * elements from the provided ordered shorts collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered shorts collections from which to copy all the elements.
     * @return A new modifiable ordered shorts collection with the specified element cardinality containing all the
     *         elements from the provided ordered shorts collections.
     */
    public static ModifiableOrderedShortCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Short>... collections) {
        ModifiableOrderedShortCollection result = ModifiableOrderedShortCollection.of(elementCardinality);
        for (OrderedNumericCollection<Short> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered shorts collection containing all the elements from the provided ordered shorts
     * collections.
     *
     * @param collections The ordered shorts collections from which to copy all the elements.
     * @return A new modifiable ordered shorts collection containing all the elements from the provided ordered shorts
     *         collections.
     */
    public static ModifiableOrderedShortCollection unionOf(final OrderedNumericCollection<Short>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

}
