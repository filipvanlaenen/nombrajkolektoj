package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
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
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Short>(source));
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

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Short> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Short>(elementCardinality, source));
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
    }

    /**
     * Returns a new empty shorts collection.
     *
     * @return A new empty shorts collection.
     */
    public static ShortCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new shorts collection containing all the elements present in each of the provided shorts collections.
     *
     * @param collections The shorts collections from which to calculate the intersection.
     * @return A new shorts collection containing all the elements present in each of the provided shorts collections.
     */
    public static ShortCollection intersectionOf(final NumericCollection<Short>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableShortCollection result = ModifiableShortCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
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

    /**
     * Returns a new shorts collection with the specified element cardinality cloned from the provided shorts
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original shorts collection.
     * @return A new shorts collection with the specified element cardinality cloned from the provided shorts
     *         collection.
     */
    public static ShortCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Short> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new shorts collection cloned from the provided shorts collection.
     *
     * @param collection The original shorts collection.
     * @return A new shorts collection cloned from the provided shorts collection.
     */
    public static ShortCollection of(final NumericCollection<Short> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new shorts collection containing all the elements from the provided shorts collections.
     *
     * @param collections The shorts collections from which to copy all the elements.
     * @return A new shorts collection containing all the elements from the provided shorts collections.
     */
    public static ShortCollection unionOf(final NumericCollection<Short>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new shorts collection with the specified element cardinality containing all the elements from the
     * provided shorts collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The shorts collections from which to copy all the elements.
     * @return A new shorts collection with the specified element cardinality containing all the elements from the
     *         provided shorts collections.
     */
    public static ShortCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Short>... collections) {
        ModifiableShortCollection result = ModifiableShortCollection.of(elementCardinality);
        for (NumericCollection<Short> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
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
