package net.filipvanlaenen.nombrajkolektoj.longs;

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
 * longs and containing inner classes with concrete implementations.
 */
public abstract class OrderedLongCollection extends AbstractOrderedLongCollection
        implements OrderedNumericCollection<Long> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedLongCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same longs and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Long> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs an ordered collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The longs of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Long>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The longs of the ordered collection.
         */
        public ArrayCollection(final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Long>(numbers));
        }
    }

    /**
     * The ordered collection holding the longs.
     */
    private final OrderedCollection<Long> collection;

    /**
     * Private constructor taking an ordered collection with the longs as its parameter.
     *
     * @param numbers The ordered collection holding the longs.
     */
    private OrderedLongCollection(final OrderedCollection<Long> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Long element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns an ordered longs collection holding a sequence of longs, starting with the provided first long, and
     * with the next longs generated recursively from the first long.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered longs collection holding a sequence of longs.
     */
    public static OrderedLongCollection createSequence(final Long firstElement,
            final Function<? super Long, Long> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedLongCollection collection = ModifiableOrderedLongCollection.of(firstElement);
        Long element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered longs collection holding a sequence of longs, starting with the provided first long, and
     * with the next longs generated recursively from the first long until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered longs collection holding a sequence of longs.
     */
    public static OrderedLongCollection createSequence(final Long firstElement,
            final Function<? super Long, Long> generator, final Predicate<? super Long> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedLongCollection collection = ModifiableOrderedLongCollection.of(firstElement);
        Long element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered longs collection holding a sequence of longs generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered longs collection holding a sequence of longs.
     */
    public static OrderedLongCollection createSequence(final Function<Integer, Long> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedLongCollection collection = ModifiableOrderedLongCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered longs collection holding a sequence of longs generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered longs collection holding a sequence of longs.
     */
    public static OrderedLongCollection createSequence(final Function<Integer, Long> generator,
            final Predicate<? super Long> whileCondition) {
        Long firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedLongCollection collection = ModifiableOrderedLongCollection.of(firstElement);
        int index = 1;
        Long element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered longs collection.
     *
     * @return A new empty ordered longs collection.
     */
    public static OrderedLongCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Long element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Long element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Long element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered longs collection with the specified longs collection.
     *
     * @param numbers The longs for the new ordered longs collection.
     * @return A new ordered longs collection with the specified longs.
     */
    public static OrderedLongCollection of(final Long... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The longs for the new ordered longs collection.
     * @return A new ordered longs collection with the specified element cardinality and the longs.
     */
    public static OrderedLongCollection of(final ElementCardinality elementCardinality, final Long... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered longs collection cloned from the provided ordered longs collection.
     *
     * @param collection The original ordered longs collection.
     * @return A new ordered longs collection cloned from the provided ordered longs collection.
     */
    public static OrderedLongCollection of(final OrderedNumericCollection<Long> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered longs collection cloned from a range in the provided ordered longs collection.
     *
     * @param collection The original ordered longs collection.
     * @param fromIndex  The index of the first element to be included in the new ordered longs collection.
     * @param toIndex    The index of the first element not to be included in the new ordered longs collection.
     * @return A new ordered longs collection cloned from a range in the provided ordered longs collection.
     */
    public static OrderedLongCollection of(final OrderedNumericCollection<Long> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedLongCollection slice =
                ModifiableOrderedLongCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered longs collection as the matrix direct product of two ordered longs collections.
     *
     * @param collectionA The first ordered longs collection.
     * @param collectionB The second ordered longs collection.
     * @return The matrix direct product of the two provided ordered longs collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedLongCollection ofMatrixDirectProduct(final OrderedNumericCollection<Long> collectionA,
            final OrderedNumericCollection<Long> collectionB) throws IllegalArgumentException {
        ModifiableOrderedLongCollection collection = ModifiableOrderedLongCollection.empty();
        for (Long a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException("One of the collections contains null.");
            }
            for (Long b : collectionB) {
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
    public Spliterator<Long> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Long[] toArray() {
        return collection.toArray(EmptyArrays.LONGS);
    }
}
