package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
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
            this(source.getElementCardinality(), source.toArray());
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param doubles            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(elementCardinality, doubles));
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param doubles The doubles of the collection.
         */
        public ArrayCollection(final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(doubles));
        }
    }

    /**
     * The collection holding the doubles.
     */
    private final Collection<Double> doubles;

    /**
     * Private constructor taking a collection with the doubles as its parameter.
     *
     * @param doubles The collection holding the doubles.
     */
    private DoubleCollection(final Collection<Double> doubles) {
        this.doubles = doubles;
    }

    @Override
    public boolean contains(final Double element) {
        return doubles.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return doubles.containsAll(collection);
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
        return doubles.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return doubles.getElementCardinality();
    }

    @Override
    public Iterator<Double> iterator() {
        return doubles.iterator();
    }

    /**
     * Returns a new doubles collection with the specified doubles.
     *
     * @param doubles The doubles for the new doubles collection.
     * @return A new doubles collection with the specified doubles.
     */
    static DoubleCollection of(final Double... doubles) {
        return new ArrayCollection(doubles);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param doubles            The doubles for the new doubles collection.
     * @return A new doubles collection with the specified element cardinality and the doubles.
     */
    static DoubleCollection of(final ElementCardinality elementCardinality, final Double... doubles) {
        return new ArrayCollection(elementCardinality, doubles);
    }

    @Override
    public int size() {
        return doubles.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return doubles.spliterator();
    }

    @Override
    public Double[] toArray() {
        return doubles.toArray();
    }
}
