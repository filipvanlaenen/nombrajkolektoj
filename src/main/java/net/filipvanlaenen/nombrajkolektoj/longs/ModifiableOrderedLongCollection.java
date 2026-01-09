package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for longs and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedLongCollection extends AbstractModifiableOrderedLongCollection
        implements ModifiableOrderedNumericCollection<Long> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedLongCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same longs and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a modifiable ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Long>(elementCardinality,
                    numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public ArrayCollection(final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Long>(numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedLongCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same longs and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a modifiable ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Long>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public LinkedListCollection(final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Long>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the longs.
     */
    private final ModifiableOrderedCollection<Long> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the longs as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the longs.
     */
    private ModifiableOrderedLongCollection(final ModifiableOrderedCollection<Long> numbers) {
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
    public boolean addAllAt(final int index, final OrderedCollection<? extends Long> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Long element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
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
    public static ModifiableOrderedLongCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Long element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Long element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Long element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable ordered longs collection with the specified longs.
     *
     * @param numbers The longs for the new modifiable ordered longs collection.
     * @return A new modifiable ordered longs collection with the specified longs.
     */
    public static ModifiableOrderedLongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new modifiable ordered longs collection.
     * @return A new modifiable ordered longs collection with the specified element cardinality and the longs.
     */
    public static ModifiableOrderedLongCollection of(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered longs collection cloned from the provided ordered longs collection.
     *
     * @param collection The original ordered longs collection.
     * @return A new modifiable ordered longs collection cloned from the provided ordered longs collection.
     */
    public static ModifiableOrderedLongCollection of(final OrderedLongCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered longs collection cloned from a range in the provided ordered longs
     * collection.
     *
     * @param collection The original ordered longs collection.
     * @param fromIndex  The index of the first element to be included in the new ordered longs collection.
     * @param toIndex    The index of the first element not to be included in the new ordered longs collection.
     * @return A new modifiable ordered longs collection cloned from a range in the provided ordered longs
     *         collection.
     */
    public static ModifiableOrderedLongCollection of(final OrderedLongCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedLongCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public Long putAt(final int index, final Long element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
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
    public Long removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
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
