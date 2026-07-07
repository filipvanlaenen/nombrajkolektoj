package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for BigIntegers and containing inner classes with concrete implementations.
 */
public interface ModifiableBigIntegerCollection extends ModifiableNumericCollection<BigInteger>, BigIntegerCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableBigIntegerCollectionDecorator {
        private ModifiableArrayCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigInteger> source) {
            decoratedCollection = new ModifiableArrayCollection<BigInteger>(source);
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            decoratedCollection = new ModifiableArrayCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<BigInteger> source) {
            decoratedCollection = new ModifiableArrayCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection = new ModifiableArrayCollection<BigInteger>(elementCardinality, numbers);
        }
    }

    /**
     * Inner class using a hash backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class HashCollection extends ModifiableBigIntegerCollectionDecorator {
        private ModifiableHashCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<BigInteger> source) {
            decoratedCollection = new ModifiableHashCollection<BigInteger>(source);
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public HashCollection(final BigInteger... numbers) {
            decoratedCollection = new ModifiableHashCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<BigInteger> source) {
            decoratedCollection = new ModifiableHashCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection = new ModifiableHashCollection<BigInteger>(elementCardinality, numbers);
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableBigIntegerCollectionDecorator {
        private ModifiableLinkedListCollection<BigInteger> decoratedCollection;

        @Override
        ModifiableCollection<BigInteger> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<BigInteger> source) {
            decoratedCollection = new ModifiableLinkedListCollection<BigInteger>(source);
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public LinkedListCollection(final BigInteger... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<BigInteger>(numbers);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<BigInteger> source) {
            decoratedCollection = new ModifiableLinkedListCollection<BigInteger>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<BigInteger>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable BigIntegers collection.
     *
     * @return A new empty modifiable BigIntegers collection.
     */
    public static ModifiableBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable BigIntegers collection containing all the elements present in each of the provided BigIntegers
     * collections.
     *
     * @param collections The BigIntegers collections from which to calculate the intersection.
     * @return A new modifiable BigIntegers collection containing all the elements present in each of the provided BigIntegers
     *         collections.
     */

    public static ModifiableBigIntegerCollection intersectionOf(final NumericCollection<BigInteger>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableBigIntegerCollection result = ModifiableBigIntegerCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new modifiable BigIntegers collection.
     * @return A new modifiable BigIntegers collection with the specified BigIntegers.
     */
    public static ModifiableBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new modifiable BigIntegers collection.
     * @return A new modifiable BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableBigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original BigIntegers collection.
     * @return A new modifiable BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableBigIntegerCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new BigIntegers modifiable collection cloned from the provided BigIntegers collection.
     *
     * @param collection The original BigIntegers collection.
     * @return A new modifiable BigIntegers collection cloned from the provided BigIntegers collection.
     */
    public static ModifiableBigIntegerCollection of(final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable BigIntegers collection with the specified element cardinality containing all the elements
     * from the provided BigIntegers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The BigIntegers collections from which to copy all the elements.
     * @return A new modifiable BigIntegers collection with the specified element cardinality containing all the elements
     *         from the provided BigIntegers collections.
     */
    public static ModifiableBigIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger>... collections) {
        ModifiableBigIntegerCollection result = ModifiableBigIntegerCollection.of(elementCardinality);
        for (NumericCollection<BigInteger> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable BigIntegers collection containing all the elements from the provided BigIntegers collections.
     *
     * @param collections The BigIntegers collections from which to copy all the elements.
     * @return A new modifiable BigIntegers collection containing all the elements from the provided BigIntegers collections.
     */

    public static ModifiableBigIntegerCollection unionOf(final NumericCollection<BigInteger>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
