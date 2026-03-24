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
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(source));
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

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Long> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Long>(elementCardinality, source));
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
    }

    /**
     * Returns a new empty longs collection.
     *
     * @return A new empty longs collection.
     */
    public static LongCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new longs collection containing all the elements present in each of the provided longs collections.
     *
     * @param collections The longs collections from which to calculate the intersection.
     * @return A new longs collection containing all the elements present in each of the provided longs collections.
     */
    public static LongCollection intersectionOf(final NumericCollection<Long>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableLongCollection result = ModifiableLongCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
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

    /**
     * Returns a new longs collection with the specified element cardinality cloned from the provided longs
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original longs collection.
     * @return A new longs collection with the specified element cardinality cloned from the provided longs
     *         collection.
     */
    public static LongCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Long> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new longs collection cloned from the provided longs collection.
     *
     * @param collection The original longs collection.
     * @return A new longs collection cloned from the provided longs collection.
     */
    public static LongCollection of(final NumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new longs collection containing all the elements from the provided longs collections.
     *
     * @param collections The longs collections from which to copy all the elements.
     * @return A new longs collection containing all the elements from the provided longs collections.
     */
    public static LongCollection unionOf(final NumericCollection<Long>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new longs collection with the specified element cardinality containing all the elements from the
     * provided longs collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The longs collections from which to copy all the elements.
     * @return A new longs collection with the specified element cardinality containing all the elements from the
     *         provided longs collections.
     */
    public static LongCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Long>... collections) {
        ModifiableLongCollection result = ModifiableLongCollection.of(elementCardinality);
        for (NumericCollection<Long> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
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
