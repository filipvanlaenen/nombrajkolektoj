package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for doubles
 * and containing inner classes with concrete implementations.
 */
public abstract class DoubleCollection extends AbstractDoubleCollection implements NumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends DoubleCollection {
        /**
         * Constructs a collection from another collection, with the same doubles and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Double> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(source));
        }

        /**
         * Constructs a collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the collection.
         */
        public ArrayCollection(final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(numbers));
        }

        /**
         * Constructs a collection from another collection with the provided element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Collection<Double> source) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(elementCardinality, source));
        }

        /**
         * Constructs a collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Double>(elementCardinality, numbers));
        }
    }

    /**
     * Returns a new empty doubles collection.
     *
     * @return A new empty doubles collection.
     */
    public static DoubleCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new doubles collection containing all the elements present in each of the provided doubles collections.
     *
     * @param collections The doubles collections from which to calculate the intersection.
     * @return A new doubles collection containing all the elements present in each of the provided doubles collections.
     */
    public static DoubleCollection intersectionOf(final NumericCollection<Double>... collections) {
        if (collections.length == 0) {
            return empty();
        }
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(collections[0]);
        for (int i = 1; i < collections.length; i++) {
            result.retainAll(collections[i]);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new doubles collection with the specified doubles.
     *
     * @param numbers The doubles for the new doubles collection.
     * @return A new doubles collection with the specified doubles.
     */
    public static DoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new doubles collection.
     * @return A new doubles collection with the specified element cardinality and the doubles.
     */
    public static DoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality cloned from the provided doubles
     * collection.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original doubles collection.
     * @return A new doubles collection with the specified element cardinality cloned from the provided doubles
     *         collection.
     */
    public static DoubleCollection of(final ElementCardinality elementCardinality,
            final NumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new doubles collection cloned from the provided doubles collection.
     *
     * @param collection The original doubles collection.
     * @return A new doubles collection cloned from the provided doubles collection.
     */
    public static DoubleCollection of(final NumericCollection<Double> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new doubles collection containing all the elements from the provided doubles collections.
     *
     * @param collections The doubles collections from which to copy all the elements.
     * @return A new doubles collection containing all the elements from the provided doubles collections.
     */
    public static DoubleCollection unionOf(final NumericCollection<Double>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }

    /**
     * Returns a new doubles collection with the specified element cardinality containing all the elements from the
     * provided doubles collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The doubles collections from which to copy all the elements.
     * @return A new doubles collection with the specified element cardinality containing all the elements from the
     *         provided doubles collections.
     */
    public static DoubleCollection unionOf(final ElementCardinality elementCardinality,
            final NumericCollection<Double>... collections) {
        ModifiableDoubleCollection result = ModifiableDoubleCollection.of(elementCardinality);
        for (NumericCollection<Double> collection : collections) {
            result.addAll(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * The collection holding the doubles.
     */
    private final Collection<Double> numbers;

    /**
     * Private constructor taking a collection with the doubles as its parameter.
     *
     * @param numbers The collection holding the doubles.
     */
    private DoubleCollection(final Collection<Double> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Double element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Double> iterator() {
        return numbers.iterator();
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Double[] toArray() {
        return numbers.toArray(EmptyArrays.DOUBLES);
    }
}
