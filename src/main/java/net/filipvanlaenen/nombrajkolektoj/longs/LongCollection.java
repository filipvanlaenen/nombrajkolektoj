package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.array.ArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for longs
 * and containing inner classes with concrete implementations.
 */
public abstract class LongCollection extends AbstractLongCollection implements NumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends LongCollection {
        /**
         * Constructs a collection from another collection, with the same longs and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the collection.
         */
        public ArrayCollection(final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(numbers));
        }
    }

    /**
     * The collection holding the longs.
     */
    private final Collection<Long> numbers;

    /**
     * Private constructor taking a collection with the longs as its parameter.
     *
     * @param numbers The collection holding the longs.
     */
    private LongCollection(final Collection<Long> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Long element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty longs collection.
     *
     * @return A new empty longs collection.
     */
    public static LongCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Long> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new longs collection cloned from the provided longs collection.
     *
     * @param collection The original longs collection.
     * @return A new longs collection cloned from the provided longs collection.
     */
    public static LongCollection of(final LongCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new longs collection with the specified longs.
     *
     * @param numbers The longs for the new longs collection.
     * @return A new longs collection with the specified longs.
     */
    public static LongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new longs collection.
     * @return A new longs collection with the specified element cardinality and the longs.
     */
    public static LongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Long[] toArray() {
        return numbers.toArray(EmptyArrays.LONGS);
    }
}
