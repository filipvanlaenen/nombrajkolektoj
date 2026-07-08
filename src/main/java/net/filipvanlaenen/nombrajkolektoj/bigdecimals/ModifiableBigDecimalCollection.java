package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A modifiable numeric collection containing BigDecimals. In addition to the functionality of modifiable collections in
 * general and BigDecimals collections, it supports augmenting, subtracting, multiplying and dividing the collection with a
 * number, and negating it.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * binding the type parameter to BigDecimal. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}, and factory methods mirroring the
 * factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableCollection}.
 */
public interface ModifiableBigDecimalCollection extends ModifiableNumericCollection<BigDecimal>, BigDecimalCollection {
    /**
     * A modifiable numeric collection containing BigDecimals and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection}.
     */
    final class ArrayCollection extends ModifiableBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableArrayCollection<BigDecimal> decoratedCollection;

        @Override
        ModifiableCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigDecimal> source) {
            decoratedCollection = new ModifiableArrayCollection<BigDecimal>(source);
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            decoratedCollection = new ModifiableArrayCollection<BigDecimal>(numbers);
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<BigDecimal> source) {
            decoratedCollection = new ModifiableArrayCollection<BigDecimal>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableArrayCollection<BigDecimal>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing BigDecimals and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}.
     */
    final class HashCollection extends ModifiableBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableHashCollection<BigDecimal> decoratedCollection;

        @Override
        ModifiableCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<BigDecimal> source) {
            decoratedCollection = new ModifiableHashCollection<BigDecimal>(source);
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public HashCollection(final BigDecimal... numbers) {
            decoratedCollection = new ModifiableHashCollection<BigDecimal>(numbers);
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<BigDecimal> source) {
            decoratedCollection = new ModifiableHashCollection<BigDecimal>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableHashCollection<BigDecimal>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing BigDecimals and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}.
     */
    final class LinkedListCollection extends ModifiableBigDecimalCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableLinkedListCollection<BigDecimal> decoratedCollection;

        @Override
        ModifiableCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<BigDecimal> source) {
            decoratedCollection = new ModifiableLinkedListCollection<BigDecimal>(source);
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public LinkedListCollection(final BigDecimal... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<BigDecimal>(numbers);
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<BigDecimal> source) {
            decoratedCollection = new ModifiableLinkedListCollection<BigDecimal>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<BigDecimal>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable BigDecimals collection.
     *
     * @return A new empty modifiable BigDecimals collection.
     */
    static ModifiableBigDecimalCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable BigDecimals collection containing all the elements present in each of the provided BigDecimals
     * collections.
     *
     * @param collections The BigDecimals collections from which to calculate the intersection.
     * @return A new modifiable BigDecimals collection containing all the elements present in each of the provided BigDecimals
     *         collections.
     */
    static ModifiableBigDecimalCollection intersectionOf(final NumericCollection<BigDecimal>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableBigDecimalCollection result = ModifiableBigDecimalCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new modifiable BigDecimals collection.
     * @return A new modifiable BigDecimals collection with the specified BigDecimals.
     */
    static ModifiableBigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new modifiable BigDecimals collection.
     * @return A new modifiable BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static ModifiableBigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original BigDecimals collection.
     * @return A new modifiable BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static ModifiableBigDecimalCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new BigDecimals modifiable collection cloned from the provided BigDecimals collection.
     *
     * @param collection The original BigDecimals collection.
     * @return A new modifiable BigDecimals collection cloned from the provided BigDecimals collection.
     */
    static ModifiableBigDecimalCollection of(final NumericCollection<BigDecimal> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable BigDecimals collection with the specified element cardinality containing all the elements
     * from the provided BigDecimals collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The BigDecimals collections from which to copy all the elements.
     * @return A new modifiable BigDecimals collection with the specified element cardinality containing all the elements
     *         from the provided BigDecimals collections.
     */
    static ModifiableBigDecimalCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<BigDecimal>... collections) {
        ModifiableBigDecimalCollection result = ModifiableBigDecimalCollection.of(elementCardinality);
        for (NumericCollection<BigDecimal> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable BigDecimals collection containing all the elements from the provided BigDecimals collections.
     *
     * @param collections The BigDecimals collections from which to copy all the elements.
     * @return A new modifiable BigDecimals collection containing all the elements from the provided BigDecimals collections.
     */
    static ModifiableBigDecimalCollection unionOf(final NumericCollection<BigDecimal>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
