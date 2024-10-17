package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * shorts and containing inner classes with concrete implementations.
 */
public abstract class OrderedShortCollection extends AbstractOrderedShortCollection
        implements OrderedNumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class OrderedArrayCollection extends OrderedShortCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same shorts and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public OrderedArrayCollection(final OrderedCollection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs an ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param shorts            The shorts of the ordered collection.
         */
        public OrderedArrayCollection(final ElementCardinality elementCardinality, final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Short>(elementCardinality, shorts));
        }

        /**
         * Constructs an ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param shorts The shorts of the ordered collection.
         */
        public OrderedArrayCollection(final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Short>(shorts));
        }
    }

    /**
     * The ordered collection holding the shorts.
     */
    private final OrderedCollection<Short> shorts;

    /**
     * Private constructor taking an ordered collection with the shorts as its parameter.
     *
     * @param shorts The ordered collection holding the shorts.
     */
    private OrderedShortCollection(final OrderedCollection<Short> shorts) {
        this.shorts = shorts;
    }

    @Override
    public boolean contains(final Short element) {
        return shorts.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return shorts.containsAll(collection);
    }

    /**
     * Returns a new empty ordered shorts collection.
     *
     * @return A new empty ordered shorts collection.
     */
    static OrderedShortCollection empty() {
        return new OrderedArrayCollection();
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return shorts.get();
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return shorts.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return shorts.getElementCardinality();
    }

    @Override
    public Iterator<Short> iterator() {
        return shorts.iterator();
    }

    /**
     * Returns a new ordered shorts collection with the specified shorts.
     *
     * @param shorts The shorts for the new ordered shorts collection.
     * @return A new ordered shorts collection with the specified shorts.
     */
    static OrderedShortCollection of(final Short... shorts) {
        return new OrderedArrayCollection(shorts);
    }

    /**
     * Returns a new ordered shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param shorts            The shorts for the new ordered shorts collection.
     * @return A new ordered shorts collection with the specified element cardinality and the shorts.
     */
    static OrderedShortCollection of(final ElementCardinality elementCardinality, final Short... shorts) {
        return new OrderedArrayCollection(elementCardinality, shorts);
    }

    @Override
    public int size() {
        return shorts.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return shorts.spliterator();
    }

    @Override
    public Short[] toArray() {
        return shorts.toArray(EmptyArrays.SHORTS);
    }
}
