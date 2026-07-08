package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A numeric collection containing bytes. In addition to the functionality of collections in general, it supports
 * calculating the sum and the product of the numbers it contains, and finding their maximum and the minimum.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface binding the
 * type parameter to Byte. It contains two nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection} and one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and factory methods mirroring the factory methods of
 * {@link net.filipvanlaenen.kolektoj.Collection}.
 */
public interface ByteCollection extends NumericCollection<Byte> {
    /**
     * A numeric collection containing bytes and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}.
     */
    final class ArrayCollection extends ByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Byte> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(source);
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public ArrayCollection(final Byte... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Byte> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(elementCardinality, numbers);
        }

        @Override
        Collection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * A numeric collection containing bytes and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}.
     */
    final class HashCollection extends ByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.hash.HashCollection<Byte> decoratedCollection;

        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Byte> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Byte>(source);
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public HashCollection(final Byte... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.hash.HashCollection<Byte>(numbers);
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Byte> source) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.hash.HashCollection<Byte>(elementCardinality, numbers);
        }

        @Override
        Collection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty bytes collection.
     *
     * @return A new empty bytes collection.
     */
    static ByteCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new bytes collection containing all the elements present in each of the provided bytes collections.
     *
     * @param collections The bytes collections from which to calculate the intersection.
     * @return A new bytes collection containing all the elements present in each of the provided bytes collections.
     */
    static ByteCollection intersectionOf(final NumericCollection<Byte>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableByteCollection result = ModifiableByteCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new bytes collection with the specified bytes.
     *
     * @param numbers The bytes for the new bytes collection.
     * @return A new bytes collection with the specified bytes.
     */
    static ByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new bytes collection.
     * @return A new bytes collection with the specified element cardinality and the bytes.
     */
    static ByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new bytes collection with the specified element cardinality cloned from the provided bytes
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original bytes collection.
     * @return A new bytes collection with the specified element cardinality cloned from the provided bytes
     *         collection.
     */
    static ByteCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new bytes collection cloned from the provided bytes collection.
     *
     * @param collection The original bytes collection.
     * @return A new bytes collection cloned from the provided bytes collection.
     */
    static ByteCollection of(final NumericCollection<Byte> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new bytes collection containing all the elements from the provided bytes collections.
     *
     * @param collections The bytes collections from which to copy all the elements.
     * @return A new bytes collection containing all the elements from the provided bytes collections.
     */
    static ByteCollection unionOf(final NumericCollection<Byte>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new bytes collection with the specified element cardinality containing all the elements from the
     * provided bytes collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The bytes collections from which to copy all the elements.
     * @return A new bytes collection with the specified element cardinality containing all the elements from the
     *         provided bytes collections.
     */
    static ByteCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Byte>... collections) {
        ModifiableByteCollection result = ModifiableByteCollection.of(elementCardinality);
        for (NumericCollection<Byte> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }
}
