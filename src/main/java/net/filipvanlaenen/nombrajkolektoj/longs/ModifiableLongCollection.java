package net.filipvanlaenen.nombrajkolektoj.longs;

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
 * for longs and containing inner classes with concrete implementations.
 */
public abstract class ModifiableLongCollection extends AbstractModifiableLongCollection
        implements ModifiableNumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableLongCollection {
        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new ModifiableArrayCollection<Long>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public ArrayCollection(final Long... numbers) {
            super(new ModifiableArrayCollection<Long>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableLongCollection {
        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new ModifiableLinkedListCollection<Long>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public LinkedListCollection(final Long... numbers) {
            super(new ModifiableLinkedListCollection<Long>(numbers));
        }
    }

    /**
     * The modifiable collection holding the longs.
     */
    private final ModifiableCollection<Long> collection;

    /**
     * Private constructor taking a collection with the longs as its parameter.
     *
     * @param numbers The collection holding the longs.
     */
    private ModifiableLongCollection(final ModifiableCollection<Long> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final Long element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Long> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Long element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable longs collection.
     *
     * @return A new empty modifiable longs collection.
     */
    public static ModifiableLongCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new longs modifiable collection cloned from the provided longs collection.
     *
     * @param collection The original longs collection.
     * @return A new modifiable longs collection cloned from the provided longs collection.
     */
    public static ModifiableLongCollection of(final NumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable longs collection with the specified longs.
     *
     * @param numbers The longs for the new modifiable longs collection.
     * @return A new modifiable longs collection with the specified longs.
     */
    public static ModifiableLongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new modifiable longs collection.
     * @return A new modifiable longs collection with the specified element cardinality and the longs.
     */
    public static ModifiableLongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public boolean remove(final Long element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Long> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super Long> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Long> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Long[] toArray() {
        return collection.toArray(EmptyArrays.LONGS);
    }
}
