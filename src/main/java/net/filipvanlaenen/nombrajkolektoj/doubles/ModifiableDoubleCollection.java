package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for doubles and containing inner classes with concrete implementations.
 */
public abstract class ModifiableDoubleCollection extends AbstractModifiableDoubleCollection
        implements ModifiableNumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableDoubleCollection {
        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new ModifiableArrayCollection<Double>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            super(new ModifiableArrayCollection<Double>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableDoubleCollection {
        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new ModifiableLinkedListCollection<Double>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public LinkedListCollection(final Double... numbers) {
            super(new ModifiableLinkedListCollection<Double>(numbers));
        }
    }

    /**
     * The modifiable collection holding the doubles.
     */
    private final ModifiableCollection<Double> collection;

    /**
     * Private constructor taking a collection with the doubles as its parameter.
     *
     * @param numbers The collection holding the doubles.
     */
    private ModifiableDoubleCollection(final ModifiableCollection<Double> numbers) {
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
    public static ModifiableDoubleCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Double> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new doubles modifiable collection cloned from the provided doubles collection.
     *
     * @param collection The original doubles collection.
     * @return A new modifiable doubles collection cloned from the provided doubles collection.
     */
    public static ModifiableDoubleCollection of(final DoubleCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new modifiable doubles collection.
     * @return A new modifiable doubles collection with the specified doubles.
     */
    public static ModifiableDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new modifiable doubles collection.
     * @return A new modifiable doubles collection with the specified element cardinality and the doubles.
     */
    public static ModifiableDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
