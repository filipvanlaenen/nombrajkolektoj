package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.function.Function;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * BigDecimals and containing inner classes with concrete implementations.
 */
public interface OrderedBigDecimalCollection extends OrderedNumericCollection<BigDecimal>, BigDecimalCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedBigDecimalCollectionDecorator {
        private net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal> decoratedCollection;

        @Override
        OrderedCollection<BigDecimal> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs an ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the ordered collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal>(numbers);
        }

        /**
         * Constructs an ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal>(elementCardinality, numbers);
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same BigDecimals and the provided
         * element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<BigDecimal> source) {
            this(elementCardinality, source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same BigDecimals and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigDecimal> source) {
            this(source.getElementCardinality(), source);
        }
    }

    /**
     * Returns an ordered BigDecimals collection holding a sequence of BigDecimals, starting with the provided first BigDecimal, and
     * with the next BigDecimals generated recursively from the first BigDecimal.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered BigDecimals collection holding a sequence of BigDecimals.
     */
    public static OrderedBigDecimalCollection createSequence(final BigDecimal firstElement,
            final Function<? super BigDecimal, BigDecimal> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedBigDecimalCollection collection = ModifiableOrderedBigDecimalCollection.of(firstElement);
        BigDecimal element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered BigDecimals collection holding a sequence of BigDecimals, starting with the provided first BigDecimal, and
     * with the next BigDecimals generated recursively from the first BigDecimal until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered BigDecimals collection holding a sequence of BigDecimals.
     */
    public static OrderedBigDecimalCollection createSequence(final BigDecimal firstElement,
            final Function<? super BigDecimal, BigDecimal> generator, final Predicate<? super BigDecimal> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedBigDecimalCollection collection = ModifiableOrderedBigDecimalCollection.of(firstElement);
        BigDecimal element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered BigDecimals collection holding a sequence of BigDecimals generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered BigDecimals collection holding a sequence of BigDecimals.
     */
    public static OrderedBigDecimalCollection createSequence(final Function<Integer, BigDecimal> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedBigDecimalCollection collection = ModifiableOrderedBigDecimalCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered BigDecimals collection holding a sequence of BigDecimals generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered BigDecimals collection holding a sequence of BigDecimals.
     */
    public static OrderedBigDecimalCollection createSequence(final Function<Integer, BigDecimal> generator,
            final Predicate<? super BigDecimal> whileCondition) {
        BigDecimal firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedBigDecimalCollection collection = ModifiableOrderedBigDecimalCollection.of(firstElement);
        int index = 1;
        BigDecimal element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered BigDecimals collection.
     *
     * @return A new empty ordered BigDecimals collection.
     */
    public static OrderedBigDecimalCollection empty() {
        return new ArrayCollection();
    }

    /**
     * Returns a new ordered BigDecimals collection as the matrix direct product of two ordered BigDecimals collections.
     *
     * @param collectionA The first ordered BigDecimals collection.
     * @param collectionB The second ordered BigDecimals collection.
     * @return The matrix direct product of the two provided ordered BigDecimals collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedBigDecimalCollection matrixDirectProductOf(final OrderedNumericCollection<BigDecimal> collectionA,
            final OrderedNumericCollection<BigDecimal> collectionB) throws IllegalArgumentException {
        ModifiableOrderedBigDecimalCollection collection = ModifiableOrderedBigDecimalCollection.empty();
        for (BigDecimal a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException(
                        "Cannot produce a matrix direct product when one of the collections contains null.");
            }
            for (BigDecimal b : collectionB) {
                if (b == null) {
                    throw new IllegalArgumentException(
                            "Cannot produce a matrix direct product when one of the collections contains null.");
                }
                collection.add(a.multiply(b));
            }
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered BigDecimals collection with the specified BigDecimals collection.
     *
     * @param numbers The BigDecimals for the new ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection with the specified BigDecimals.
     */
    public static OrderedBigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    public static OrderedBigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered BigDecimals collection cloned from the provided ordered BigDecimals collection with the specified
     * element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection cloned from the provided ordered BigDecimals collection with the specified
     *         element cardinality.
     */
    public static OrderedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigDecimal> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     */
    public static OrderedBigDecimalCollection of(final OrderedNumericCollection<BigDecimal> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered BigDecimals collection cloned from a range in the provided ordered BigDecimals collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @param fromIndex  The index of the first element to be included in the new ordered BigDecimals collection.
     * @param toIndex    The index of the first element not to be included in the new ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection cloned from a range in the provided ordered BigDecimals collection.
     */
    public static OrderedBigDecimalCollection of(final OrderedNumericCollection<BigDecimal> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedBigDecimalCollection slice =
                ModifiableOrderedBigDecimalCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered BigDecimals collection with the specified element cardinality containing all the elements from
     * the provided ordered BigDecimals collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered BigDecimals collections from which to copy all the elements.
     * @return A new ordered BigDecimals collection with the specified element cardinality containing all the elements from
     *         the provided ordered BigDecimals collections.
     */
    public static OrderedBigDecimalCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigDecimal>... collections) {
        ModifiableOrderedBigDecimalCollection result = ModifiableOrderedBigDecimalCollection.of(elementCardinality);
        for (OrderedNumericCollection<BigDecimal> collection : collections) {
            result.addAllLast(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new ordered BigDecimals collection containing all the elements from the provided ordered BigDecimals
     * collections.
     *
     * @param collections The ordered BigDecimals collections from which to copy all the elements.
     * @return A new ordered BigDecimals collection containing all the elements from the provided ordered BigDecimals
     *         collections.
     */
    public static OrderedBigDecimalCollection unionOf(final OrderedNumericCollection<BigDecimal>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
