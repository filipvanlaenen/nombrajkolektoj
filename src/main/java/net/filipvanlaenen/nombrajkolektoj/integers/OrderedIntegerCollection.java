package net.filipvanlaenen.nombrajkolektoj.integers;

import java.util.function.Function;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.OrderedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An ordered numeric collection containing integers. It doesn't support any new functionality in addition to the
 * functionality of ordered collections in general and integers collections but has an extra factory method for the
 * matrix direct product.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface
 * binding the type parameter to Integer. It contains one nested class implementing this interface, backed by an
 * {@link net.filipvanlaenen.kolektoj.array.OrderedArrayCollection}, and factory methods mirroring the factory methods
 * of {@link net.filipvanlaenen.kolektoj.OrderedCollection}.
 */
public interface OrderedIntegerCollection extends OrderedNumericCollection<Integer>, IntegerCollection {
    /**
     * An ordered numeric collection containing integers and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.integers.OrderedIntegerCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.OrderedArrayCollection}.
     */
    final class ArrayCollection extends OrderedIntegerCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private OrderedArrayCollection<Integer> decoratedCollection;

        @Override
        OrderedCollection<Integer> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs an ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the ordered collection.
         */
        public ArrayCollection(final Integer... numbers) {
            decoratedCollection = new OrderedArrayCollection<Integer>(numbers);
        }

        /**
         * Constructs an ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            decoratedCollection = new OrderedArrayCollection<Integer>(elementCardinality, numbers);
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same integers and the provided
         * element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Integer> source) {
            this(elementCardinality, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same integers and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Integer> source) {
            this(source.getElementCardinality(), source);
        }
    }

    /**
     * Returns an ordered integers collection holding a sequence of integers, starting with the provided first int, and
     * with the next integers generated recursively from the first int.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered integers collection holding a sequence of integers.
     */
    static OrderedIntegerCollection createSequence(final Integer firstElement,
            final Function<? super Integer, Integer> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedIntegerCollection collection = ModifiableOrderedIntegerCollection.of(firstElement);
        Integer element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered integers collection holding a sequence of integers, starting with the provided first int, and
     * with the next integers generated recursively from the first int until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered integers collection holding a sequence of integers.
     */
    static OrderedIntegerCollection createSequence(final Integer firstElement,
            final Function<? super Integer, Integer> generator, final Predicate<? super Integer> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedIntegerCollection collection = ModifiableOrderedIntegerCollection.of(firstElement);
        Integer element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered integers collection holding a sequence of integers generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered integers collection holding a sequence of integers.
     */
    static OrderedIntegerCollection createSequence(final Function<Integer, Integer> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedIntegerCollection collection = ModifiableOrderedIntegerCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered integers collection holding a sequence of integers generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered integers collection holding a sequence of integers.
     */
    static OrderedIntegerCollection createSequence(final Function<Integer, Integer> generator,
            final Predicate<? super Integer> whileCondition) {
        Integer firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedIntegerCollection collection = ModifiableOrderedIntegerCollection.of(firstElement);
        int index = 1;
        Integer element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered integers collection.
     *
     * @return A new empty ordered integers collection.
     */
    static OrderedIntegerCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new ordered integers collection as the matrix direct product of two ordered integers collections.
     *
     * @param collectionA The first ordered integers collection.
     * @param collectionB The second ordered integers collection.
     * @return The matrix direct product of the two provided ordered integers collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    static OrderedIntegerCollection matrixDirectProductOf(final OrderedNumericCollection<Integer> collectionA,
            final OrderedNumericCollection<Integer> collectionB) throws IllegalArgumentException {
        ModifiableOrderedIntegerCollection collection = ModifiableOrderedIntegerCollection.empty();
        for (Integer a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException(
                        "Cannot produce a matrix direct product when one of the collections contains null.");
            }
            for (Integer b : collectionB) {
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
     * Returns a new ordered integers collection with the specified integers collection.
     *
     * @param numbers The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified integers.
     */
    static OrderedIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified element cardinality and the integers.
     */
    static OrderedIntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered integers collection cloned from the provided ordered integers collection with the specified
     * element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered integers collection.
     * @return A new ordered integers collection cloned from the provided ordered integers collection with the specified
     *         element cardinality.
     */
    static OrderedIntegerCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Integer> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new ordered integers collection cloned from the provided ordered integers collection.
     *
     * @param collection The original ordered integers collection.
     * @return A new ordered integers collection cloned from the provided ordered integers collection.
     */
    static OrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered integers collection cloned from a range in the provided ordered integers collection.
     *
     * @param collection The original ordered integers collection.
     * @param fromIndex  The index of the first element to be included in the new ordered integers collection.
     * @param toIndex    The index of the first element not to be included in the new ordered integers collection.
     * @return A new ordered integers collection cloned from a range in the provided ordered integers collection.
     */
    static OrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedIntegerCollection slice =
                ModifiableOrderedIntegerCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered integers collection with the specified element cardinality containing all the elements from
     * the provided ordered integers collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered integers collections from which to copy all the elements.
     * @return A new ordered integers collection with the specified element cardinality containing all the elements from
     *         the provided ordered integers collections.
     */
    static OrderedIntegerCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Integer>... collections) {
        ModifiableOrderedIntegerCollection result = ModifiableOrderedIntegerCollection.of(elementCardinality);
        for (OrderedNumericCollection<Integer> collection : collections) {
            result.addAllLast(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new ordered integers collection containing all the elements from the provided ordered integers
     * collections.
     *
     * @param collections The ordered integers collections from which to copy all the elements.
     * @return A new ordered integers collection containing all the elements from the provided ordered integers
     *         collections.
     */
    static OrderedIntegerCollection unionOf(final OrderedNumericCollection<Integer>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
