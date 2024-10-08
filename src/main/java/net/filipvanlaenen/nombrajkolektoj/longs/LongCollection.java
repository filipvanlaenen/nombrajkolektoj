package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
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
         * @param longs              The longs of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(elementCardinality, longs));
        }

        /**
         * Constructs a collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param longs The longs of the collection.
         */
        public ArrayCollection(final Long... longs) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(longs));
        }
    }

    /**
     * The collection holding the longs.
     */
    private final Collection<Long> longs;

    /**
     * Private constructor taking a collection with the longs as its parameter.
     *
     * @param longs The collection holding the longs.
     */
    private LongCollection(final Collection<Long> longs) {
        this.longs = longs;
    }

    @Override
    public boolean contains(final Long element) {
        return longs.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return longs.containsAll(collection);
    }

    /**
     * Returns a new empty longs collection.
     *
     * @return A new empty longs collection.
     */
    static LongCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return longs.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return longs.getElementCardinality();
    }

    @Override
    public Iterator<Long> iterator() {
        return longs.iterator();
    }

    /**
     * Returns a new longs collection with the specified longs.
     *
     * @param longs The longs for the new longs collection.
     * @return A new longs collection with the specified longs.
     */
    static LongCollection of(final Long... longs) {
        return new ArrayCollection(longs);
    }

    /**
     * Returns a new longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param longs              The longs for the new longs collection.
     * @return A new longs collection with the specified element cardinality and the longs.
     */
    static LongCollection of(final ElementCardinality elementCardinality, final Long... longs) {
        return new ArrayCollection(elementCardinality, longs);
    }

    @Override
    public int size() {
        return longs.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return longs.spliterator();
    }

    @Override
    public Long[] toArray() {
        return longs.toArray(EmptyArrays.LONGS);
    }
}
