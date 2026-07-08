package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * A modifiable numeric collection containing bytes. In addition to the functionality of modifiable collections in
 * general and bytes collections, it supports augmenting, subtracting, multiplying and dividing the collection with a
 * number, and negating it.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * binding the type parameter to Byte. It contains three nested classes implementing this interface, one backed by an
 * {@link net.filipvanlaenen.kolektoj.array.ArrayCollection}, one backed by
 * {@link net.filipvanlaenen.kolektoj.hash.HashCollection}, and one backed by
 * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}, and factory methods mirroring the
 * factory methods of {@link net.filipvanlaenen.kolektoj.ModifiableCollection}.
 */
public interface ModifiableByteCollection extends ModifiableNumericCollection<Byte>, ByteCollection {
    /**
     * A modifiable numeric collection containing bytes and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection}.
     */
    final class ArrayCollection extends ModifiableByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableArrayCollection<Byte> decoratedCollection;

        @Override
        ModifiableCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Byte> source) {
            decoratedCollection = new ModifiableArrayCollection<Byte>(source);
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public ArrayCollection(final Byte... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Byte>(numbers);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Byte> source) {
            decoratedCollection = new ModifiableArrayCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection = new ModifiableArrayCollection<Byte>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing bytes and backed by a hash. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection}.
     */
    final class HashCollection extends ModifiableByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableHashCollection<Byte> decoratedCollection;

        @Override
        ModifiableCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public HashCollection(final Collection<Byte> source) {
            decoratedCollection = new ModifiableHashCollection<Byte>(source);
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public HashCollection(final Byte... numbers) {
            decoratedCollection = new ModifiableHashCollection<Byte>(numbers);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Collection<Byte> source) {
            decoratedCollection = new ModifiableHashCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public HashCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection = new ModifiableHashCollection<Byte>(elementCardinality, numbers);
        }
    }

    /**
     * A modifiable numeric collection containing bytes and backed by a linked list. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection}.
     */
    final class LinkedListCollection extends ModifiableByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableLinkedListCollection<Byte> decoratedCollection;

        @Override
        ModifiableCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Byte> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Byte>(source);
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public LinkedListCollection(final Byte... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Byte>(numbers);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Collection<Byte> source) {
            decoratedCollection = new ModifiableLinkedListCollection<Byte>(elementCardinality, source);
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection = new ModifiableLinkedListCollection<Byte>(elementCardinality, numbers);
        }
    }

    /**
     * Returns a new empty modifiable bytes collection.
     *
     * @return A new empty modifiable bytes collection.
     */
    static ModifiableByteCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new modifiable bytes collection containing all the elements present in each of the provided bytes
     * collections.
     *
     * @param collections The bytes collections from which to calculate the intersection.
     * @return A new modifiable bytes collection containing all the elements present in each of the provided bytes
     *         collections.
     */
    static ModifiableByteCollection intersectionOf(final NumericCollection<Byte>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableByteCollection result = ModifiableByteCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return result;
    }

    /**
     * Returns a new modifiable bytes collection with the specified bytes.
     *
     * @param numbers The bytes for the new modifiable bytes collection.
     * @return A new modifiable bytes collection with the specified bytes.
     */
    static ModifiableByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new modifiable bytes collection.
     * @return A new modifiable bytes collection with the specified element cardinality and the bytes.
     */
    static ModifiableByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original bytes collection.
     * @return A new modifiable bytes collection with the specified element cardinality and the bytes.
     */
    static ModifiableByteCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new bytes modifiable collection cloned from the provided bytes collection.
     *
     * @param collection The original bytes collection.
     * @return A new modifiable bytes collection cloned from the provided bytes collection.
     */
    static ModifiableByteCollection of(final NumericCollection<Byte> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable bytes collection with the specified element cardinality containing all the elements
     * from the provided bytes collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The bytes collections from which to copy all the elements.
     * @return A new modifiable bytes collection with the specified element cardinality containing all the elements
     *         from the provided bytes collections.
     */
    static ModifiableByteCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Byte>... collections) {
        ModifiableByteCollection result = ModifiableByteCollection.of(elementCardinality);
        for (NumericCollection<Byte> collection : collections) {
            result.addAll(collection);
        }
        return result;
    }

    /**
     * Returns a new modifiable bytes collection containing all the elements from the provided bytes collections.
     *
     * @param collections The bytes collections from which to copy all the elements.
     * @return A new modifiable bytes collection containing all the elements from the provided bytes collections.
     */
    static ModifiableByteCollection unionOf(final NumericCollection<Byte>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
