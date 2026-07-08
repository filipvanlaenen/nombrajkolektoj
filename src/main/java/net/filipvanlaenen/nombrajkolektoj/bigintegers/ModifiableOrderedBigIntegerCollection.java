package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing BigIntegers. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered BigIntegers collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a BigInteger at a specific position, or with an ordered BigIntegers collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to BigInteger. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedBigIntegerCollection
        extends ModifiableOrderedNumericCollection<BigInteger>, ModifiableBigIntegerCollection, OrderedBigIntegerCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedBigIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableOrderedCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigInteger>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<BigInteger> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigIntegers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigInteger> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigInteger>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedBigIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableOrderedCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public LinkedListCollection(final BigInteger... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<BigInteger> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigInteger>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigIntegers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }
    }

    /**
     * Returns a new empty modifiable BigIntegers collection.
     *
     * @return A new empty modifiable BigIntegers collection.
     */
    static ModifiableOrderedBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new modifiable ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified BigIntegers.
     */
    static ModifiableOrderedBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new modifiable ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static ModifiableOrderedBigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static ModifiableOrderedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     */
    static ModifiableOrderedBigIntegerCollection of(final OrderedNumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection cloned from a range in the provided ordered BigIntegers
     * collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @param fromIndex  The index of the first element to be included in the new ordered BigIntegers collection.
     * @param toIndex    The index of the first element not to be included in the new ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection cloned from a range in the provided ordered BigIntegers
     *         collection.
     */
    static ModifiableOrderedBigIntegerCollection of(final OrderedNumericCollection<BigInteger> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedBigIntegerCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality containing all the
     * elements from the provided ordered BigIntegers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered BigIntegers collections from which to copy all the elements.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality containing all the
     *         elements from the provided ordered BigIntegers collections.
     */
    static ModifiableOrderedBigIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigInteger>... collections) {
        ModifiableOrderedBigIntegerCollection result = ModifiableOrderedBigIntegerCollection.of(elementCardinality);
        for (OrderedNumericCollection<BigInteger> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection containing all the elements from the provided ordered BigIntegers
     * collections.
     *
     * @param collections The ordered BigIntegers collections from which to copy all the elements.
     * @return A new modifiable ordered BigIntegers collection containing all the elements from the provided ordered BigIntegers
     *         collections.
     */
    static ModifiableOrderedBigIntegerCollection unionOf(final OrderedNumericCollection<BigInteger>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
