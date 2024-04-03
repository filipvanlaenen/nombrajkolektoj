package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for shorts
 * and containing inner classes with concrete implementations.
 */
public abstract class ShortCollection extends AbstractShortCollection implements NumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends ShortCollection {
        /**
         * Constructs a collection from another collection, with the same shorts and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Short> source) {
            this(source.getElementCardinality(), source.toArray());
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param shorts              The shorts of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Short>(elementCardinality, shorts));
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param shorts The shorts of the collection.
         */
        public ArrayCollection(final Short... shorts) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Short>(shorts));
        }
    }

    /**
     * The collection holding the shorts.
     */
    private final Collection<Short> shorts;

    /**
     * Private constructor taking a collection with the shorts as its parameter.
     *
     * @param shorts The collection holding the shorts.
     */
    private ShortCollection(final Collection<Short> shorts) {
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
     * Returns a new empty shorts collection.
     *
     * @return A new empty shorts collection.
     */
    static ShortCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return shorts.get();
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
     * Returns a new shorts collection with the specified shorts.
     *
     * @param shorts The shorts for the new shorts collection.
     * @return A new shorts collection with the specified shorts.
     */
    static ShortCollection of(final Short... shorts) {
        return new ArrayCollection(shorts);
    }

    /**
     * Returns a new shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param shorts              The shorts for the new shorts collection.
     * @return A new shorts collection with the specified element cardinality and the shorts.
     */
    static ShortCollection of(final ElementCardinality elementCardinality, final Short... shorts) {
        return new ArrayCollection(elementCardinality, shorts);
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
        return shorts.toArray();
    }
}
