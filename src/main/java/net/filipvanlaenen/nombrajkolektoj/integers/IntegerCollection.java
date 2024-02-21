package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for
 * integers and containing inner classes with concrete implementations.
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
            this(source.getElementCardinality(), source.toArray());
        }

        /**
         * Constructs a collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param integers           The integers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(elementCardinality, integers));
        }

        /**
         * Constructs a collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param integers The integers of the collection.
         */
        public ArrayCollection(final Integer... integers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Integer>(integers));
        }
    }

    /**
     * The collection holding the integers.
     */
    private final Collection<Integer> integers;

    /**
     * Private constructor taking a collection with the integers as its parameter.
     *
     * @param integers The collection holding the integers.
     */
    private IntegerCollection(final Collection<Integer> integers) {
        this.integers = integers;
    }

    @Override
    public boolean contains(final Integer element) {
        return integers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return collection.containsAll(collection);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return integers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return integers.getElementCardinality();
    }

    @Override
    public Iterator<Integer> iterator() {
        return integers.iterator();
    }

    @Override
    public int size() {
        return integers.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return integers.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return integers.toArray();
    }
}
