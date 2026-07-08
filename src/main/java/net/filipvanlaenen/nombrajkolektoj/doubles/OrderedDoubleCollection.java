package net.filipvanlaenen.nombrajkolektoj.doubles;

import java.util.function.Function;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.OrderedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An ordered numeric collection containing doubles. It doesn't support any new functionality in addition to the
 * functionality of ordered collections in general and doubles collections but has an extra factory method for the
 * matrix direct product.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface
 * binding the type parameter to Double. It contains one nested class implementing this interface, backed by an
 * {@link net.filipvanlaenen.kolektoj.array.OrderedArrayCollection}, and factory methods mirroring the factory methods
 * of {@link net.filipvanlaenen.kolektoj.OrderedCollection}.
 */
public interface OrderedDoubleCollection extends OrderedNumericCollection<Double>, DoubleCollection {
    /**
     * An ordered numeric collection containing doubles and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.OrderedArrayCollection}.
     */
    final class ArrayCollection extends OrderedDoubleCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private OrderedArrayCollection<Double> decoratedCollection;

        @Override
        OrderedCollection<Double> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs an ordered collection with the given doubles. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The doubles of the ordered collection.
         */
        public ArrayCollection(final Double... numbers) {
            decoratedCollection = new OrderedArrayCollection<Double>(numbers);
        }

        /**
         * Constructs an ordered collection with the given doubles and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The doubles of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Double... numbers) {
            decoratedCollection = new OrderedArrayCollection<Double>(elementCardinality, numbers);
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same doubles and the provided
         * element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Double> source) {
            this(elementCardinality, source.toArray(EmptyArrays.DOUBLES));
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same doubles and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Double> source) {
            this(source.getElementCardinality(), source);
        }
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
    static OrderedDoubleCollection createSequence(final Double firstElement,
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
    static OrderedDoubleCollection createSequence(final Double firstElement,
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
    static OrderedDoubleCollection createSequence(final Function<Integer, Double> generator,
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
    static OrderedDoubleCollection createSequence(final Function<Integer, Double> generator,
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
    static OrderedDoubleCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new ordered doubles collection as the matrix direct product of two ordered doubles collections.
     *
     * @param collectionA The first ordered doubles collection.
     * @param collectionB The second ordered doubles collection.
     * @return The matrix direct product of the two provided ordered doubles collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    static OrderedDoubleCollection matrixDirectProductOf(final OrderedNumericCollection<Double> collectionA,
            final OrderedNumericCollection<Double> collectionB) throws IllegalArgumentException {
        ModifiableOrderedDoubleCollection collection = ModifiableOrderedDoubleCollection.empty();
        for (Double a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException(
                        "Cannot produce a matrix direct product when one of the collections contains null.");
            }
            for (Double b : collectionB) {
                if (b == null) {
                    throw new IllegalArgumentException(
                            "Cannot produce a matrix direct product when one of the collections contains null.");
                }
                collection.add(a * b);
            }
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered doubles collection with the specified doubles collection.
     *
     * @param numbers The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified doubles.
     */
    static OrderedDoubleCollection of(final Double... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered doubles collection with the specified element cardinality and the doubles.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The doubles for the new ordered doubles collection.
     * @return A new ordered doubles collection with the specified element cardinality and the doubles.
     */
    static OrderedDoubleCollection of(final ElementCardinality elementCardinality, final Double... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered doubles collection cloned from the provided ordered doubles collection with the specified
     * element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered doubles collection.
     * @return A new ordered doubles collection cloned from the provided ordered doubles collection with the specified
     *         element cardinality.
     */
    static OrderedDoubleCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Double> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new ordered doubles collection cloned from the provided ordered doubles collection.
     *
     * @param collection The original ordered doubles collection.
     * @return A new ordered doubles collection cloned from the provided ordered doubles collection.
     */
    static OrderedDoubleCollection of(final OrderedNumericCollection<Double> collection) {
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
    static OrderedDoubleCollection of(final OrderedNumericCollection<Double> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedDoubleCollection slice =
                ModifiableOrderedDoubleCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered doubles collection with the specified element cardinality containing all the elements from
     * the provided ordered doubles collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered doubles collections from which to copy all the elements.
     * @return A new ordered doubles collection with the specified element cardinality containing all the elements from
     *         the provided ordered doubles collections.
     */
    static OrderedDoubleCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Double>... collections) {
        ModifiableOrderedDoubleCollection result = ModifiableOrderedDoubleCollection.of(elementCardinality);
        for (OrderedNumericCollection<Double> collection : collections) {
            result.addAllLast(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new ordered doubles collection containing all the elements from the provided ordered doubles
     * collections.
     *
     * @param collections The ordered doubles collections from which to copy all the elements.
     * @return A new ordered doubles collection containing all the elements from the provided ordered doubles
     *         collections.
     */
    static OrderedDoubleCollection unionOf(final OrderedNumericCollection<Double>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
