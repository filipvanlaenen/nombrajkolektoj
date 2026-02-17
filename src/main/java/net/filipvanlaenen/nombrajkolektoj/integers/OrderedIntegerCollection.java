package net.filipvanlaenen.nombrajkolektoj.integers;

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
 * integers and containing inner classes with concrete implementations.
 */
public abstract class OrderedIntegerCollection extends AbstractOrderedIntegerCollection
        implements OrderedNumericCollection<Integer> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedIntegerCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same integers and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Integer> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs an ordered collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The integers of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Integer>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The integers of the ordered collection.
         */
        public ArrayCollection(final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Integer>(numbers));
        }
    }

    /**
     * The ordered collection holding the integers.
     */
    private final OrderedCollection<Integer> collection;

    /**
     * Private constructor taking an ordered collection with the integers as its parameter.
     *
     * @param numbers The ordered collection holding the integers.
     */
    private OrderedIntegerCollection(final OrderedCollection<Integer> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Integer element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
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
    public static OrderedIntegerCollection createSequence(final Integer firstElement,
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
    public static OrderedIntegerCollection createSequence(final Integer firstElement,
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
    public static OrderedIntegerCollection createSequence(final Function<Integer, Integer> generator,
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
    public static OrderedIntegerCollection createSequence(final Function<Integer, Integer> generator,
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
    public static OrderedIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Integer element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Integer element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Integer element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered integers collection with the specified integers collection.
     *
     * @param numbers The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified integers.
     */
    public static OrderedIntegerCollection of(final Integer... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The integers for the new ordered integers collection.
     * @return A new ordered integers collection with the specified element cardinality and the integers.
     */
    public static OrderedIntegerCollection of(final ElementCardinality elementCardinality, final Integer... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered integers collection cloned from the provided ordered integers collection.
     *
     * @param collection The original ordered integers collection.
     * @return A new ordered integers collection cloned from the provided ordered integers collection.
     */
    public static OrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection) {
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
    public static OrderedIntegerCollection of(final OrderedNumericCollection<Integer> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedIntegerCollection slice =
                ModifiableOrderedIntegerCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered integers collection as the matrix direct product of two ordered integers collections.
     *
     * @param collectionA The first ordered integers collection.
     * @param collectionB The second ordered integers collection.
     * @return The matrix direct product of the two provided ordered integers collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedIntegerCollection ofMatrixDirectProduct(final OrderedNumericCollection<Integer> collectionA,
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

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return collection.toArray(EmptyArrays.INTEGERS);
    }
}
