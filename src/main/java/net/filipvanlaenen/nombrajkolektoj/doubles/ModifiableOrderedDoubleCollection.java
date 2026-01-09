package net.filipvanlaenen.nombrajkolektoj.doubles;

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
 * interface for doubles and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedDoubleCollection extends AbstractModifiableOrderedDoubleCollection
        implements ModifiableOrderedNumericCollection<Double> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedDoubleCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same doubles and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Double>(elementCardinality,
                    numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Double>(numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedDoubleCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same doubles and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Double>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public LinkedListCollection(final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Double>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the doubles.
     */
    private final ModifiableOrderedCollection<Double> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the doubles as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the doubles.
     */
    private ModifiableOrderedDoubleCollection(final ModifiableOrderedCollection<Double> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final Double element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Double> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends Double> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Double element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Double element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable doubles collection.
     *
     * @return A new empty modifiable doubles collection.
     */
    public static ModifiableOrderedDoubleCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Double element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Double element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Double> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Double element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable ordered doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new modifiable ordered doubles collection.
     * @return A new modifiable ordered doubles collection with the specified doubles.
     */
    public static ModifiableOrderedDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new modifiable ordered doubles collection.
     * @return A new modifiable ordered doubles collection with the specified element cardinality and the doubles.
     */
    public static ModifiableOrderedDoubleCollection of(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered doubles collection cloned from the provided ordered doubles collection.
     *
     * @param collection The original ordered doubles collection.
     * @return A new modifiable ordered doubles collection cloned from the provided ordered doubles collection.
     */
    public static ModifiableOrderedDoubleCollection of(final OrderedDoubleCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered doubles collection cloned from a range in the provided ordered doubles
     * collection.
     *
     * @param collection The original ordered doubles collection.
     * @param fromIndex  The index of the first element to be included in the new ordered doubles collection.
     * @param toIndex    The index of the first element not to be included in the new ordered doubles collection.
     * @return A new modifiable ordered doubles collection cloned from a range in the provided ordered doubles
     *         collection.
     */
    public static ModifiableOrderedDoubleCollection of(final OrderedDoubleCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedDoubleCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public Double putAt(final int index, final Double element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
    }

    @Override
    public boolean remove(final Double element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Double> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Double removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Double> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Double> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Double[] toArray() {
        return collection.toArray(EmptyArrays.DOUBLES);
    }
}
