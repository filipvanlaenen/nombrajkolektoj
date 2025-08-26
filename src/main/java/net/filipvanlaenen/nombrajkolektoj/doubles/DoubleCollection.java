package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for doubles
 * and containing inner classes with concrete implementations.
 */
public abstract class DoubleCollection extends AbstractDoubleCollection implements NumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends DoubleCollection {
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
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(numbers));
        }
    }

    /**
     * The collection holding the doubles.
     */
    private final Collection<Double> numbers;

    /**
     * Private constructor taking a collection with the doubles as its parameter.
     *
     * @param numbers The collection holding the doubles.
     */
    private DoubleCollection(final Collection<Double> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Double element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty doubles collection.
     *
     * @return A new empty doubles collection.
     */
    static DoubleCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Double> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new doubles collection.
     * @return A new doubles collection with the specified doubles.
     */
    static DoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new doubles collection.
     * @return A new doubles collection with the specified element cardinality and the doubles.
     */
    static DoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Double[] toArray() {
        return numbers.toArray(EmptyArrays.DOUBLES);
    }
}
