package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for floats
 * and containing inner classes with concrete implementations.
 */
public abstract class FloatCollection extends AbstractFloatCollection implements NumericCollection<Float> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends FloatCollection {
        /**
         * Constructs a collection from another collection, with the same floats and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Float> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Float>(source));
        }

        /**
         * Constructs a collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public ArrayCollection(final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Float>(numbers));
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Float> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Float>(elementCardinality, source));
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Float>(elementCardinality, numbers));
        }
    }

    /**
     * Returns a new empty floats collection.
     *
     * @return A new empty floats collection.
     */
    public static FloatCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new floats collection containing all the elements present in each of the provided floats collections.
     *
     * @param collections The floats collections from which to calculate the intersection.
     * @return A new floats collection containing all the elements present in each of the provided floats collections.
     */
    public static FloatCollection intersectionOf(final NumericCollection<Float>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableFloatCollection result = ModifiableFloatCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new floats collection with the specified floats.
     *
     * @param numbers The floats for the new floats collection.
     * @return A new floats collection with the specified floats.
     */
    public static FloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new floats collection.
     * @return A new floats collection with the specified element cardinality and the floats.
     */
    public static FloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new floats collection with the specified element cardinality cloned from the provided floats
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original floats collection.
     * @return A new floats collection with the specified element cardinality cloned from the provided floats
     *         collection.
     */
    public static FloatCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Float> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new floats collection cloned from the provided floats collection.
     *
     * @param collection The original floats collection.
     * @return A new floats collection cloned from the provided floats collection.
     */
    public static FloatCollection of(final NumericCollection<Float> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new floats collection containing all the elements from the provided floats collections.
     *
     * @param collections The floats collections from which to copy all the elements.
     * @return A new floats collection containing all the elements from the provided floats collections.
     */
    public static FloatCollection unionOf(final NumericCollection<Float>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new floats collection with the specified element cardinality containing all the elements from the
     * provided floats collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The floats collections from which to copy all the elements.
     * @return A new floats collection with the specified element cardinality containing all the elements from the
     *         provided floats collections.
     */
    public static FloatCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Float>... collections) {
        ModifiableFloatCollection result = ModifiableFloatCollection.of(elementCardinality);
        for (NumericCollection<Float> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * The collection holding the floats.
     */
    private final Collection<Float> numbers;

    /**
     * Private constructor taking a collection with the floats as its parameter.
     *
     * @param numbers The collection holding the floats.
     */
    private FloatCollection(final Collection<Float> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Float element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Float> iterator() {
        return numbers.iterator();
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Float> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Float[] toArray() {
        return numbers.toArray(EmptyArrays.FLOATS);
    }
}
