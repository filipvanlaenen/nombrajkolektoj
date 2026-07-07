package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.hash.ModifiableHashCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for bytes and containing inner classes with concrete implementations.
 */
public interface ModifiableByteCollection extends ModifiableNumericCollection<Byte>, ByteCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableByteCollectionDecorator {
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
     * Inner class using a hash backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class HashCollection extends ModifiableByteCollectionDecorator {
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
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableByteCollectionDecorator {
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
    public static ModifiableByteCollection empty() {
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

    public static ModifiableByteCollection intersectionOf(final NumericCollection<Byte>... collections) {
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
    public static ModifiableByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new modifiable bytes collection.
     * @return A new modifiable bytes collection with the specified element cardinality and the bytes.
     */
    public static ModifiableByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original bytes collection.
     * @return A new modifiable bytes collection with the specified element cardinality and the bytes.
     */
    public static ModifiableByteCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new bytes modifiable collection cloned from the provided bytes collection.
     *
     * @param collection The original bytes collection.
     * @return A new modifiable bytes collection cloned from the provided bytes collection.
     */
    public static ModifiableByteCollection of(final NumericCollection<Byte> collection) {
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
    public static ModifiableByteCollection unionOf(final ElementCardinality elementCardinality,
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

    public static ModifiableByteCollection unionOf(final NumericCollection<Byte>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
