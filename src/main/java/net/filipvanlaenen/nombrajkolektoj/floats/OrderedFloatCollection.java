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
    public static final class OrderedArrayCollection extends OrderedFloatCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same floats and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public OrderedArrayCollection(final OrderedCollection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs an ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param floats            The floats of the ordered collection.
         */
        public OrderedArrayCollection(final ElementCardinality elementCardinality, final Float... floats) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Float>(elementCardinality, floats));
        }

        /**
         * Constructs an ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param floats The floats of the ordered collection.
         */
        public OrderedArrayCollection(final Float... floats) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Float>(floats));
        }
    }

    /**
     * The ordered collection holding the floats.
     */
    private final OrderedCollection<Float> floats;

    /**
     * Private constructor taking an ordered collection with the floats as its parameter.
     *
     * @param floats The ordered collection holding the floats.
     */
    private OrderedFloatCollection(final OrderedCollection<Float> floats) {
        this.floats = floats;
    }

    @Override
    public boolean contains(final Float element) {
        return floats.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return floats.containsAll(collection);
    }

    /**
     * Returns a new empty ordered floats collection.
     *
     * @return A new empty ordered floats collection.
     */
    static OrderedFloatCollection empty() {
        return new OrderedArrayCollection();
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return floats.get();
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return floats.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return floats.getElementCardinality();
    }

    @Override
    public Iterator<Float> iterator() {
        return floats.iterator();
    }

    /**
     * Returns a new ordered floats collection with the specified floats.
     *
     * @param floats The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified floats.
     */
    static OrderedFloatCollection of(final Float... floats) {
        return new OrderedArrayCollection(floats);
    }

    /**
     * Returns a new ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param floats            The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified element cardinality and the floats.
     */
    static OrderedFloatCollection of(final ElementCardinality elementCardinality, final Float... floats) {
        return new OrderedArrayCollection(elementCardinality, floats);
    }

    @Override
    public int size() {
        return floats.size();
    }

    @Override
    public Spliterator<Float> spliterator() {
        return floats.spliterator();
    }

    @Override
    public Float[] toArray() {
        return floats.toArray(EmptyArrays.FLOATS);
    }
}
