package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * floats and containing inner classes with concrete implementations.
 */
public abstract class OrderedFloatCollection extends AbstractOrderedFloatCollection
        implements OrderedNumericCollection<Float> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedFloatCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same floats and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs an ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Float>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the ordered collection.
         */
        public ArrayCollection(final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Float>(numbers));
        }
    }

    /**
     * The ordered collection holding the floats.
     */
    private final OrderedCollection<Float> collection;

    /**
     * Private constructor taking an ordered collection with the floats as its parameter.
     *
     * @param numbers The ordered collection holding the floats.
     */
    private OrderedFloatCollection(final OrderedCollection<Float> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Float element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty ordered floats collection.
     *
     * @return A new empty ordered floats collection.
     */
    static OrderedFloatCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Float> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new ordered floats collection with the specified floats.
     *
     * @param numbers The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified floats.
     */
    static OrderedFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified element cardinality and the floats.
     */
    static OrderedFloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Float> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Float[] toArray() {
        return collection.toArray(EmptyArrays.FLOATS);
    }
}
