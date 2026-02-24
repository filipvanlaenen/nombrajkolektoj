package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for bytes and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedByteCollection extends AbstractModifiableOrderedByteCollection
        implements ModifiableOrderedNumericCollection<Byte> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedByteCollection {
        /**
         * Constructs a modifiable ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public ArrayCollection(final Byte... numbers) {
            super(new ModifiableOrderedArrayCollection<Byte>(numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            super(new ModifiableOrderedArrayCollection<Byte>(elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Byte> source) {
            super(new ModifiableOrderedArrayCollection<Byte>(elementCardinality, source));
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same bytes and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Byte> source) {
            super(new ModifiableOrderedArrayCollection<Byte>(source));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedByteCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same bytes and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Byte> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Byte>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public LinkedListCollection(final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Byte>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the bytes.
     */
    private final ModifiableOrderedCollection<Byte> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the bytes as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the bytes.
     */
    private ModifiableOrderedByteCollection(final ModifiableOrderedCollection<Byte> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final Byte element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Byte> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends Byte> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Byte element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Byte element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable bytes collection.
     *
     * @return A new empty modifiable bytes collection.
     */
    public static ModifiableOrderedByteCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Byte element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Byte element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Byte> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Byte element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified bytes.
     *
     * @param numbers The bytes for the new modifiable ordered bytes collection.
     * @return A new modifiable ordered bytes collection with the specified bytes.
     */
    public static ModifiableOrderedByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new modifiable ordered bytes collection.
     * @return A new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     */
    public static ModifiableOrderedByteCollection of(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered bytes collection.
     * @return A new modifiable ordered bytes collection with the specified element cardinality and the bytes.
     */
    public static ModifiableOrderedByteCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered bytes collection cloned from the provided ordered bytes collection.
     *
     * @param collection The original ordered bytes collection.
     * @return A new modifiable ordered bytes collection cloned from the provided ordered bytes collection.
     */
    public static ModifiableOrderedByteCollection of(final OrderedNumericCollection<Byte> collection) {
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
    public static ModifiableOrderedByteCollection of(final OrderedNumericCollection<Byte> collection,
            final int fromIndex, final int toIndex) {
        ModifiableOrderedByteCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public Byte putAt(final int index, final Byte element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
    }

    @Override
    public boolean remove(final Byte element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Byte> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Byte removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Byte> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Byte> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Byte> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Byte[] toArray() {
        return collection.toArray(EmptyArrays.BYTES);
    }
}
