package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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
 * BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class OrderedBigIntegerCollection extends AbstractOrderedBigIntegerCollection
        implements OrderedNumericCollection<BigInteger> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedBigIntegerCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same BigIntegers and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs an ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigInteger>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the ordered collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<BigInteger>(numbers));
        }
    }

    /**
     * The ordered collection holding the BigIntegers.
     */
    private final OrderedCollection<BigInteger> collection;

    /**
     * Private constructor taking an ordered collection with the BigIntegers as its parameter.
     *
     * @param numbers The ordered collection holding the BigIntegers.
     */
    private OrderedBigIntegerCollection(final OrderedCollection<BigInteger> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final BigInteger element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns an ordered BigIntegers collection holding a sequence of BigIntegers, starting with the provided first BigInteger, and
     * with the next BigIntegers generated recursively from the first BigInteger.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered BigIntegers collection holding a sequence of BigIntegers.
     */
    public static OrderedBigIntegerCollection createSequence(final BigInteger firstElement,
            final Function<? super BigInteger, BigInteger> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedBigIntegerCollection collection = ModifiableOrderedBigIntegerCollection.of(firstElement);
        BigInteger element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered BigIntegers collection holding a sequence of BigIntegers, starting with the provided first BigInteger, and
     * with the next BigIntegers generated recursively from the first BigInteger until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered BigIntegers collection holding a sequence of BigIntegers.
     */
    public static OrderedBigIntegerCollection createSequence(final BigInteger firstElement,
            final Function<? super BigInteger, BigInteger> generator, final Predicate<? super BigInteger> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedBigIntegerCollection collection = ModifiableOrderedBigIntegerCollection.of(firstElement);
        BigInteger element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered BigIntegers collection holding a sequence of BigIntegers generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered BigIntegers collection holding a sequence of BigIntegers.
     */
    public static OrderedBigIntegerCollection createSequence(final Function<Integer, BigInteger> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedBigIntegerCollection collection = ModifiableOrderedBigIntegerCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered BigIntegers collection holding a sequence of BigIntegers generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered BigIntegers collection holding a sequence of BigIntegers.
     */
    public static OrderedBigIntegerCollection createSequence(final Function<Integer, BigInteger> generator,
            final Predicate<? super BigInteger> whileCondition) {
        BigInteger firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedBigIntegerCollection collection = ModifiableOrderedBigIntegerCollection.of(firstElement);
        int index = 1;
        BigInteger element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered BigIntegers collection.
     *
     * @return A new empty ordered BigIntegers collection.
     */
    public static OrderedBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final BigInteger element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final BigInteger element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigInteger element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered BigIntegers collection with the specified BigIntegers collection.
     *
     * @param numbers The BigIntegers for the new ordered BigIntegers collection.
     * @return A new ordered BigIntegers collection with the specified BigIntegers.
     */
    public static OrderedBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new ordered BigIntegers collection.
     * @return A new ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static OrderedBigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @return A new ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     */
    public static OrderedBigIntegerCollection of(final OrderedBigIntegerCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered BigIntegers collection cloned from a range in the provided ordered BigIntegers collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @param fromIndex  The index of the first element to be included in the new ordered BigIntegers collection.
     * @param toIndex    The index of the first element not to be included in the new ordered BigIntegers collection.
     * @return A new ordered BigIntegers collection cloned from a range in the provided ordered BigIntegers collection.
     */
    public static OrderedBigIntegerCollection of(final OrderedBigIntegerCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedBigIntegerCollection slice =
                ModifiableOrderedBigIntegerCollection.of(collection.getElementCardinality());
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
    public Spliterator<BigInteger> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return collection.toArray(EmptyArrays.BIG_INTEGERS);
    }
}
