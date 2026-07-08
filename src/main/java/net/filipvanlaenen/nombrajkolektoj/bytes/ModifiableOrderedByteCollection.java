package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing bytes. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered bytes collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a byte at a specific position, or with an ordered bytes collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to Byte. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedByteCollection
        extends ModifiableOrderedNumericCollection<Byte>, ModifiableByteCollection, OrderedByteCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<Byte> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public ArrayCollection(final Byte... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Byte>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Byte>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Byte> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same bytes and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Byte> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<Byte>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<Byte> decoratedCollection;

        @Override
        ModifiableOrderedCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public LinkedListCollection(final Byte... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Byte>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<Byte> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<Byte>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same bytes and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Byte> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
        }
    }

    /**
     * Returns a new empty modifiable bytes collection.
     *
     * @return A new empty modifiable bytes collection.
     */
    static ModifiableOrderedByteCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified bytes.
     *
     * @param numbers The bytes for the new modifiable ordered bytes collection.
     * @return A new modifiable ordered bytes collection with the specified bytes.
     */
    static ModifiableOrderedByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new modifiable ordered bytes collection.
     * @return A new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     */
    static ModifiableOrderedByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered bytes collection.
     * @return A new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     */
    static ModifiableOrderedByteCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered bytes collection cloned from the provided ordered bytes collection.
     *
     * @param collection The original ordered bytes collection.
     * @return A new modifiable ordered bytes collection cloned from the provided ordered bytes collection.
     */
    static ModifiableOrderedByteCollection of(final OrderedNumericCollection<Byte> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered bytes collection cloned from a range in the provided ordered bytes
     * collection.
     *
     * @param collection The original ordered bytes collection.
     * @param fromIndex  The index of the first element to be included in the new ordered bytes collection.
     * @param toIndex    The index of the first element not to be included in the new ordered bytes collection.
     * @return A new modifiable ordered bytes collection cloned from a range in the provided ordered bytes
     *         collection.
     */
    static ModifiableOrderedByteCollection of(final OrderedNumericCollection<Byte> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedByteCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified element cardinality containing all the
     * elements from the provided ordered bytes collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered bytes collections from which to copy all the elements.
     * @return A new modifiable ordered bytes collection with the specified element cardinality containing all the
     *         elements from the provided ordered bytes collections.
     */
    static ModifiableOrderedByteCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Byte>... collections) {
        ModifiableOrderedByteCollection result = ModifiableOrderedByteCollection.of(elementCardinality);
        for (OrderedNumericCollection<Byte> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered bytes collection containing all the elements from the provided ordered bytes
     * collections.
     *
     * @param collections The ordered bytes collections from which to copy all the elements.
     * @return A new modifiable ordered bytes collection containing all the elements from the provided ordered bytes
     *         collections.
     */
    static ModifiableOrderedByteCollection unionOf(final OrderedNumericCollection<Byte>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
