package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.array.ArrayCollection;
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
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Short>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public ArrayCollection(final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Short>(numbers));
        }
    }

    /**
     * The collection holding the shorts.
     */
    private final Collection<Short> numbers;

    /**
     * Private constructor taking a collection with the shorts as its parameter.
     *
     * @param numbers The collection holding the shorts.
     */
    private ShortCollection(final Collection<Short> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Short element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty shorts collection.
     *
     * @return A new empty shorts collection.
     */
    public static ShortCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Short> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new shorts collection cloned from the provided shorts collection.
     *
     * @param collection The original shorts collection.
     * @return A new shorts collection cloned from the provided shorts collection.
     */
    public static ShortCollection of(final ShortCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new shorts collection with the specified shorts.
     *
     * @param numbers The shorts for the new shorts collection.
     * @return A new shorts collection with the specified shorts.
     */
    public static ShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new shorts collection.
     * @return A new shorts collection with the specified element cardinality and the shorts.
     */
    public static ShortCollection of(final ElementCardinality elementCardinality, final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Short[] toArray() {
        return numbers.toArray(EmptyArrays.SHORTS);
    }
}
