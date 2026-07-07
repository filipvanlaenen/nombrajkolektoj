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
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for BigIntegers and containing inner classes with concrete implementations.
 */
public interface ModifiableOrderedBigIntegerCollection
        extends ModifiableOrderedNumericCollection<BigInteger>, ModifiableBigIntegerCollection, OrderedBigIntegerCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedBigIntegerCollectionDecorator {
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
    public static final class LinkedListCollection extends ModifiableOrderedBigIntegerCollectionDecorator {
        private ModifiableOrderedLinkedListCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableOrderedCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
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
         * Constructs a modifiable ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public LinkedListCollection(final BigInteger... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigInteger>(numbers);
        }
    }

    /**
     * Returns a new empty modifiable BigIntegers collection.
     *
     * @return A new empty modifiable BigIntegers collection.
     */
    public static ModifiableOrderedBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new modifiable ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified BigIntegers.
     */
    public static ModifiableOrderedBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new modifiable ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableOrderedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableOrderedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     */
    public static ModifiableOrderedBigIntegerCollection of(final OrderedNumericCollection<BigInteger> collection) {
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
    public static ModifiableOrderedBigIntegerCollection of(final OrderedNumericCollection<BigInteger> collection,
            final int fromIndex, final int toIndex) {
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
    public static ModifiableOrderedBigIntegerCollection unionOf(final ElementCardinality elementCardinality,
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
    public static ModifiableOrderedBigIntegerCollection unionOf(final OrderedNumericCollection<BigInteger>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

}
