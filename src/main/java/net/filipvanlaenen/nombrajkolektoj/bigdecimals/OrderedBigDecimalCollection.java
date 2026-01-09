package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
 * BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class OrderedBigDecimalCollection extends AbstractOrderedBigDecimalCollection
        implements OrderedNumericCollection<BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedBigDecimalCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same BigDecimals and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs an ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the ordered collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigDecimal>(numbers));
        }
    }

    /**
     * The ordered collection holding the BigDecimals.
     */
    private final OrderedCollection<BigDecimal> collection;

    /**
     * Private constructor taking an ordered collection with the BigDecimals as its parameter.
     *
     * @param numbers The ordered collection holding the BigDecimals.
     */
    private OrderedBigDecimalCollection(final OrderedCollection<BigDecimal> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
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

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final BigDecimal element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return collection.lastIndexOf(element);
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
     * Returns a new ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @return A new ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     */
    public static OrderedBigDecimalCollection of(final OrderedBigDecimalCollection collection) {
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
    public static OrderedBigDecimalCollection of(final OrderedBigDecimalCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedBigDecimalCollection slice =
                ModifiableOrderedBigDecimalCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return collection.toArray(EmptyArrays.BIG_DECIMALS);
    }
}
