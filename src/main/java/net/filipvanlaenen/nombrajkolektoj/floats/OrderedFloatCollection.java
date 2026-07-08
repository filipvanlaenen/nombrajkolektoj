package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.function.Function;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.OrderedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An ordered numeric collection containing floats. It doesn't support any new functionality in addition to the
 * functionality of ordered collections in general and floats collections but has an extra factory method for the
 * matrix direct product.
 *
 * This interface extends the generic {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface
 * binding the type parameter to Float. It contains one nested class implementing this interface, backed by an
 * {@link net.filipvanlaenen.kolektoj.array.OrderedArrayCollection}, and factory methods mirroring the factory methods
 * of {@link net.filipvanlaenen.kolektoj.OrderedCollection}.
 */
public interface OrderedFloatCollection extends OrderedNumericCollection<Float>, FloatCollection {
    /**
     * An ordered numeric collection containing floats and backed by an array. It implements the
     * {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} interface by decorating an
     * {@link net.filipvanlaenen.kolektoj.array.OrderedArrayCollection}.
     */
    final class ArrayCollection extends OrderedFloatCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private OrderedArrayCollection<Float> decoratedCollection;

        @Override
        OrderedCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs an ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the ordered collection.
         */
        public ArrayCollection(final Float... numbers) {
            decoratedCollection = new OrderedArrayCollection<Float>(numbers);
        }

        /**
         * Constructs an ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            decoratedCollection = new OrderedArrayCollection<Float>(elementCardinality, numbers);
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same floats and the provided
         * element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Float> source) {
            this(elementCardinality, source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same floats and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Float> source) {
            this(source.getElementCardinality(), source);
        }
    }

    /**
     * Returns an ordered floats collection holding a sequence of floats, starting with the provided first float, and
     * with the next floats generated recursively from the first float.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered floats collection holding a sequence of floats.
     */
    static OrderedFloatCollection createSequence(final Float firstElement,
            final Function<? super Float, Float> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection.of(firstElement);
        Float element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered floats collection holding a sequence of floats, starting with the provided first float, and
     * with the next floats generated recursively from the first float until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered floats collection holding a sequence of floats.
     */
    static OrderedFloatCollection createSequence(final Float firstElement,
            final Function<? super Float, Float> generator, final Predicate<? super Float> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection.of(firstElement);
        Float element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered floats collection holding a sequence of floats generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered floats collection holding a sequence of floats.
     */
    static OrderedFloatCollection createSequence(final Function<Integer, Float> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered floats collection holding a sequence of floats generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered floats collection holding a sequence of floats.
     */
    static OrderedFloatCollection createSequence(final Function<Integer, Float> generator,
            final Predicate<? super Float> whileCondition) {
        Float firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection.of(firstElement);
        int index = 1;
        Float element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered floats collection.
     *
     * @return A new empty ordered floats collection.
     */
    static OrderedFloatCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new ordered floats collection as the matrix direct product of two ordered floats collections.
     *
     * @param collectionA The first ordered floats collection.
     * @param collectionB The second ordered floats collection.
     * @return The matrix direct product of the two provided ordered floats collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    static OrderedFloatCollection matrixDirectProductOf(final OrderedNumericCollection<Float> collectionA,
            final OrderedNumericCollection<Float> collectionB) throws IllegalArgumentException {
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection.empty();
        for (Float a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException(
                        "Cannot produce a matrix direct product when one of the collections contains null.");
            }
            for (Float b : collectionB) {
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
     * Returns a new ordered floats collection with the specified floats collection.
     *
     * @param numbers The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified floats.
     */
    static OrderedFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified element cardinality and the floats.
     */
    static OrderedFloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered floats collection cloned from the provided ordered floats collection with the specified
     * element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered floats collection.
     * @return A new ordered floats collection cloned from the provided ordered floats collection with the specified
     *         element cardinality.
     */
    static OrderedFloatCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new ordered floats collection cloned from the provided ordered floats collection.
     *
     * @param collection The original ordered floats collection.
     * @return A new ordered floats collection cloned from the provided ordered floats collection.
     */
    static OrderedFloatCollection of(final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered floats collection cloned from a range in the provided ordered floats collection.
     *
     * @param collection The original ordered floats collection.
     * @param fromIndex  The index of the first element to be included in the new ordered floats collection.
     * @param toIndex    The index of the first element not to be included in the new ordered floats collection.
     * @return A new ordered floats collection cloned from a range in the provided ordered floats collection.
     */
    static OrderedFloatCollection of(final OrderedNumericCollection<Float> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedFloatCollection slice =
                ModifiableOrderedFloatCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered floats collection with the specified element cardinality containing all the elements from
     * the provided ordered floats collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered floats collections from which to copy all the elements.
     * @return A new ordered floats collection with the specified element cardinality containing all the elements from
     *         the provided ordered floats collections.
     */
    static OrderedFloatCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Float>... collections) {
        ModifiableOrderedFloatCollection result = ModifiableOrderedFloatCollection.of(elementCardinality);
        for (OrderedNumericCollection<Float> collection : collections) {
            result.addAllLast(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new ordered floats collection containing all the elements from the provided ordered floats
     * collections.
     *
     * @param collections The ordered floats collections from which to copy all the elements.
     * @return A new ordered floats collection containing all the elements from the provided ordered floats
     *         collections.
     */
    static OrderedFloatCollection unionOf(final OrderedNumericCollection<Float>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
