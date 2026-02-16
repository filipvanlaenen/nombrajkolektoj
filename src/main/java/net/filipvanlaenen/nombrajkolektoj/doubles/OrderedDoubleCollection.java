package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * doubles and containing inner classes with concrete implementations.
 */
public abstract class OrderedDoubleCollection extends AbstractOrderedDoubleCollection
        implements OrderedNumericCollection<Double> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedDoubleCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same doubles and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs an ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Double>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the ordered collection.
         */
        public ArrayCollection(final Double... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Double>(numbers));
        }
    }

    /**
     * The ordered collection holding the doubles.
     */
    private final OrderedCollection<Double> collection;

    /**
     * Private constructor taking an ordered collection with the doubles as its parameter.
     *
     * @param numbers The ordered collection holding the doubles.
     */
    private OrderedDoubleCollection(final OrderedCollection<Double> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Double element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns an ordered doubles collection holding a sequence of doubles, starting with the provided first double, and
     * with the next doubles generated recursively from the first double.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered doubles collection holding a sequence of doubles.
     */
    public static OrderedDoubleCollection createSequence(final Double firstElement,
            final Function<? super Double, Double> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection.of(firstElement);
        Double element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered doubles collection holding a sequence of doubles, starting with the provided first double, and
     * with the next doubles generated recursively from the first double until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered doubles collection holding a sequence of doubles.
     */
    public static OrderedDoubleCollection createSequence(final Double firstElement,
            final Function<? super Double, Double> generator, final Predicate<? super Double> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection.of(firstElement);
        Double element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered doubles collection holding a sequence of doubles generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered doubles collection holding a sequence of doubles.
     */
    public static OrderedDoubleCollection createSequence(final Function<Integer, Double> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered doubles collection holding a sequence of doubles generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered doubles collection holding a sequence of doubles.
     */
    public static OrderedDoubleCollection createSequence(final Function<Integer, Double> generator,
            final Predicate<? super Double> whileCondition) {
        Double firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection.of(firstElement);
        int index = 1;
        Double element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered doubles collection.
     *
     * @return A new empty ordered doubles collection.
     */
    public static OrderedDoubleCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Double element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Double get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Double getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Double element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Double> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Double element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered doubles collection with the specified doubles collection.
     *
     * @param numbers The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified doubles.
     */
    public static OrderedDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified element cardinality and the doubles.
     */
    public static OrderedDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered doubles collection cloned from the provided ordered doubles collection.
     *
     * @param collection The original ordered doubles collection.
     * @return A new ordered doubles collection cloned from the provided ordered doubles collection.
     */
    public static OrderedDoubleCollection of(final OrderedNumericCollection<Double> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered doubles collection cloned from a range in the provided ordered doubles collection.
     *
     * @param collection The original ordered doubles collection.
     * @param fromIndex  The index of the first element to be included in the new ordered doubles collection.
     * @param toIndex    The index of the first element not to be included in the new ordered doubles collection.
     * @return A new ordered doubles collection cloned from a range in the provided ordered doubles collection.
     */
    public static OrderedDoubleCollection of(final OrderedNumericCollection<Double> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedDoubleCollection slice =
                ModifiableOrderedDoubleCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered doubles collection as the matrix direct product of two ordered doubles collections.
     *
     * @param collectionA The first ordered doubles collection.
     * @param collectionB The second ordered doubles collection.
     * @return The matrix direct product of the two provided ordered doubles collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedDoubleCollection ofMatrixDirectProduct(final OrderedNumericCollection<Double> collectionA,
            final OrderedNumericCollection<Double> collectionB) throws IllegalArgumentException {
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection.empty();
        for (Double a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException("One of the collections contains null.");
            }
            for (Double b : collectionB) {
                if (b == null) {
                    throw new IllegalArgumentException("One of the collections contains null.");
                }
                collection.add(a * b);
            }
        }
        return new ArrayCollection(collection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Double> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Double[] toArray() {
        return collection.toArray(EmptyArrays.DOUBLES);
    }
}
