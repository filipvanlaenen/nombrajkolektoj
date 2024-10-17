package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * doubles and containing inner classes with concrete implementations.
 */
public abstract class OrderedDoubleCollection extends AbstractOrderedDoubleCollection
        implements OrderedNumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedDoubleCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same doubles and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs an ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param doubles            The doubles of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Double>(elementCardinality, doubles));
        }

        /**
         * Constructs an ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param doubles The doubles of the ordered collection.
         */
        public ArrayCollection(final Double... doubles) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Double>(doubles));
        }
    }

    /**
     * The ordered collection holding the doubles.
     */
    private final OrderedCollection<Double> doubles;

    /**
     * Private constructor taking an ordered collection with the doubles as its parameter.
     *
     * @param doubles The ordered collection holding the doubles.
     */
    private OrderedDoubleCollection(final OrderedCollection<Double> doubles) {
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
     * Returns a new empty ordered doubles collection.
     *
     * @return A new empty ordered doubles collection.
     */
    static OrderedDoubleCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return doubles.get();
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return doubles.getAt(index);
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
     * Returns a new ordered doubles collection with the specified doubles.
     *
     * @param doubles The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified doubles.
     */
    static OrderedDoubleCollection of(final Double... doubles) {
        return new ArrayCollection(doubles);
    }

    /**
     * Returns a new ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param doubles            The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified element cardinality and the doubles.
     */
    static OrderedDoubleCollection of(final ElementCardinality elementCardinality, final Double... doubles) {
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
        return doubles.toArray(EmptyArrays.DOUBLES);
    }
}
