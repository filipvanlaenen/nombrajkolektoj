package net.filipvanlaenen.nombrajkolektoj.integers;

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
 * interface for integers and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedIntegerCollection extends AbstractModifiableOrderedIntegerCollection
        implements ModifiableOrderedNumericCollection<Integer> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedIntegerCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same integers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a modifiable ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Integer>(elementCardinality,
                    numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public ArrayCollection(final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Integer>(numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedIntegerCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same integers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a modifiable ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Integer>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public LinkedListCollection(final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Integer>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the integers.
     */
    private final ModifiableOrderedCollection<Integer> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the integers as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the integers.
     */
    private ModifiableOrderedIntegerCollection(final ModifiableOrderedCollection<Integer> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final Integer element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends Integer> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Integer element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Integer element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable integers collection.
     *
     * @return A new empty modifiable integers collection.
     */
    public static ModifiableOrderedIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Integer element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Integer element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Integer element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified integers.
     *
     * @param numbers The integers for the new modifiable ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified integers.
     */
    public static ModifiableOrderedIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new modifiable ordered integers collection.
     * @return A new modifiable ordered integers collection with the specified element cardinality and the integers.
     */
    public static ModifiableOrderedIntegerCollection of(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered integers collection cloned from the provided ordered integers collection.
     *
     * @param collection The original ordered integers collection.
     * @return A new modifiable ordered integers collection cloned from the provided ordered integers collection.
     */
    public static ModifiableOrderedIntegerCollection of(final OrderedIntegerCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered integers collection cloned from a range in the provided ordered integers
     * collection.
     *
     * @param collection The original ordered integers collection.
     * @param fromIndex  The index of the first element to be included in the new ordered integers collection.
     * @param toIndex    The index of the first element not to be included in the new ordered integers collection.
     * @return A new modifiable ordered integers collection cloned from a range in the provided ordered integers
     *         collection.
     */
    public static ModifiableOrderedIntegerCollection of(final OrderedIntegerCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedIntegerCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public Integer putAt(final int index, final Integer element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
    }

    @Override
    public boolean remove(final Integer element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Integer> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Integer removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Integer> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Integer> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return collection.toArray(EmptyArrays.INTEGERS);
    }
}
