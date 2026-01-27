package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for bytes and containing inner classes with concrete implementations.
 */
public abstract class ModifiableByteCollection extends AbstractModifiableByteCollection
        implements ModifiableNumericCollection<Byte> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableByteCollection {
        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Byte> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            super(new ModifiableArrayCollection<Byte>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public ArrayCollection(final Byte... numbers) {
            super(new ModifiableArrayCollection<Byte>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableByteCollection {
        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Byte> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            super(new ModifiableLinkedListCollection<Byte>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public LinkedListCollection(final Byte... numbers) {
            super(new ModifiableLinkedListCollection<Byte>(numbers));
        }
    }

    /**
     * The modifiable collection holding the bytes.
     */
    private final ModifiableCollection<Byte> collection;

    /**
     * Private constructor taking a collection with the bytes as its parameter.
     *
     * @param numbers The collection holding the bytes.
     */
    private ModifiableByteCollection(final ModifiableCollection<Byte> numbers) {
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
    public static ModifiableByteCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Byte> iterator() {
        return collection.iterator();
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

    @Override
    public boolean remove(final Byte element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Byte> otherCollection) {
        return collection.removeAll(otherCollection);
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
