package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An interface defining the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for integers and
 * containing inner classes with concrete implementations.
 */
public interface IntegerCollection extends NumericCollection<Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    final class ArrayCollection extends IntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Integer> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(source);
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public ArrayCollection(final Integer... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Integer> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(elementCardinality, numbers);
        }

        @Override
        Collection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using a hash backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    final class HashCollection extends IntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.hash.HashCollection<Integer> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Integer> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Integer>(source);
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public HashCollection(final Integer... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Integer>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Integer> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Integer>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Integer>(elementCardinality, numbers);
        }

        @Override
        Collection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty integers collection.
     *
     * @return A new empty integers collection.
     */
    static IntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new integers collection containing all the elements present in each of the provided integers collections.
     *
     * @param collections The integers collections from which to calculate the intersection.
     * @return A new integers collection containing all the elements present in each of the provided integers collections.
     */
    static IntegerCollection intersectionOf(final NumericCollection<Integer>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableIntegerCollection result = ModifiableIntegerCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new integers collection with the specified integers.
     *
     * @param numbers The integers for the new integers collection.
     * @return A new integers collection with the specified integers.
     */
    static IntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new integers collection.
     * @return A new integers collection with the specified element cardinality and the integers.
     */
    static IntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new integers collection with the specified element cardinality cloned from the provided integers
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original integers collection.
     * @return A new integers collection with the specified element cardinality cloned from the provided integers
     *         collection.
     */
    static IntegerCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new integers collection cloned from the provided integers collection.
     *
     * @param collection The original integers collection.
     * @return A new integers collection cloned from the provided integers collection.
     */
    static IntegerCollection of(final NumericCollection<Integer> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new integers collection containing all the elements from the provided integers collections.
     *
     * @param collections The integers collections from which to copy all the elements.
     * @return A new integers collection containing all the elements from the provided integers collections.
     */
    static IntegerCollection unionOf(final NumericCollection<Integer>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new integers collection with the specified element cardinality containing all the elements from the
     * provided integers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The integers collections from which to copy all the elements.
     * @return A new integers collection with the specified element cardinality containing all the elements from the
     *         provided integers collections.
     */
    static IntegerCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Integer>... collections) {
        ModifiableIntegerCollection result = ModifiableIntegerCollection.of(elementCardinality);
        for (NumericCollection<Integer> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }
}
