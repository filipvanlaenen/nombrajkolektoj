package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for integers
 * and containing inner classes with concrete implementations.
 */
public abstract class IntegerCollection extends AbstractIntegerCollection implements NumericCollection<Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends IntegerCollection {
        /**
         * Constructs a collection from another collection, with the same integers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Integer> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(source));
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the collection.
         */
        public ArrayCollection(final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(numbers));
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Integer> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(elementCardinality, source));
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(elementCardinality, numbers));
        }
    }

    /**
     * The collection holding the integers.
     */
    private final Collection<Integer> numbers;

    /**
     * Private constructor taking a collection with the integers as its parameter.
     *
     * @param numbers The collection holding the integers.
     */
    private IntegerCollection(final Collection<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Integer element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty integers collection.
     *
     * @return A new empty integers collection.
     */
    public static IntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new integers collection with the specified integers.
     *
     * @param numbers The integers for the new integers collection.
     * @return A new integers collection with the specified integers.
     */
    public static IntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new integers collection.
     * @return A new integers collection with the specified element cardinality and the integers.
     */
    public static IntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new integers collection with the specified element cardinality cloned from the provided integers
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original integers collection.
     * @return A new integers collection with the specified element cardinality cloned from the provided integers
     *         collection.
     */
    public static IntegerCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new integers collection cloned from the provided integers collection.
     *
     * @param collection The original integers collection.
     * @return A new integers collection cloned from the provided integers collection.
     */
    public static IntegerCollection of(final NumericCollection<Integer> collection) {
        return new ArrayCollection(collection);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return numbers.toArray(EmptyArrays.INTEGERS);
    }
}
