package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * A modifiable ordered numeric collection containing BigDecimals. In addition to the functionality of modifiable ordered
 * collections in general and modifiable and ordered BigDecimals collections, it supports augmenting, subtracting,
 * multiplying and dividing the collection with a BigDecimal at a specific position, or with an ordered BigDecimals collection
 * of the same size, and negating it at a specific position.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface binding the type parameter to BigDecimal. It contains two nested classes implementing this interface, one
 * backed by an {@link net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection}, and factory methods mirroring
 * the factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}.
 */
public interface ModifiableOrderedBigDecimalCollection
        extends ModifiableOrderedNumericCollection<BigDecimal>, ModifiableBigDecimalCollection, OrderedBigDecimalCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    final class ArrayCollection extends ModifiableOrderedBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedArrayCollection<BigDecimal> decoratedCollection;

        @Override
        ModifiableOrderedCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigDecimal>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigDecimal>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<BigDecimal> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigDecimal>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigDecimals and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigDecimal> source) {
            decoratedCollection = new ModifiableOrderedArrayCollection<BigDecimal>(source);
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    final class LinkedListCollection extends ModifiableOrderedBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableOrderedLinkedListCollection<BigDecimal> decoratedCollection;

        @Override
        ModifiableOrderedCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public LinkedListCollection(final BigDecimal... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigDecimal>(numbers);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality,
                final OrderedCollection<BigDecimal> source) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigDecimal>(elementCardinality, source);
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableOrderedLinkedListCollection<BigDecimal>(elementCardinality, numbers);
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigDecimals and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }
    }

    /**
     * Returns a new empty modifiable BigDecimals collection.
     *
     * @return A new empty modifiable BigDecimals collection.
     */
    static ModifiableOrderedBigDecimalCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new modifiable ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection with the specified BigDecimals.
     */
    static ModifiableOrderedBigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new modifiable ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static ModifiableOrderedBigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static ModifiableOrderedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigDecimal> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     */
    static ModifiableOrderedBigDecimalCollection of(final OrderedNumericCollection<BigDecimal> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection cloned from a range in the provided ordered BigDecimals
     * collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @param fromIndex  The index of the first element to be included in the new ordered BigDecimals collection.
     * @param toIndex    The index of the first element not to be included in the new ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection cloned from a range in the provided ordered BigDecimals
     *         collection.
     */
    static ModifiableOrderedBigDecimalCollection of(final OrderedNumericCollection<BigDecimal> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedBigDecimalCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection with the specified element cardinality containing all the
     * elements from the provided ordered BigDecimals collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered BigDecimals collections from which to copy all the elements.
     * @return A new modifiable ordered BigDecimals collection with the specified element cardinality containing all the
     *         elements from the provided ordered BigDecimals collections.
     */
    static ModifiableOrderedBigDecimalCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigDecimal>... collections) {
        ModifiableOrderedBigDecimalCollection result = ModifiableOrderedBigDecimalCollection.of(elementCardinality);
        for (OrderedNumericCollection<BigDecimal> collection : collections) {
            result.addAllLast(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection containing all the elements from the provided ordered BigDecimals
     * collections.
     *
     * @param collections The ordered BigDecimals collections from which to copy all the elements.
     * @return A new modifiable ordered BigDecimals collection containing all the elements from the provided ordered BigDecimals
     *         collections.
     */
    static ModifiableOrderedBigDecimalCollection unionOf(final OrderedNumericCollection<BigDecimal>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
