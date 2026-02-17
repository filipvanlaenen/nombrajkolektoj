package net.filipvanlaenen.nombrajkolektoj.shorts;

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
 * shorts and containing inner classes with concrete implementations.
 */
public abstract class OrderedShortCollection extends AbstractOrderedShortCollection
        implements OrderedNumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedShortCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same shorts and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs an ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Short>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the ordered collection.
         */
        public ArrayCollection(final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Short>(numbers));
        }
    }

    /**
     * The ordered collection holding the shorts.
     */
    private final OrderedCollection<Short> collection;

    /**
     * Private constructor taking an ordered collection with the shorts as its parameter.
     *
     * @param numbers The ordered collection holding the shorts.
     */
    private OrderedShortCollection(final OrderedCollection<Short> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Short element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns an ordered shorts collection holding a sequence of shorts, starting with the provided first short, and
     * with the next shorts generated recursively from the first short.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered shorts collection holding a sequence of shorts.
     */
    public static OrderedShortCollection createSequence(final Short firstElement,
            final Function<? super Short, Short> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedShortCollection collection = ModifiableOrderedShortCollection.of(firstElement);
        Short element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered shorts collection holding a sequence of shorts, starting with the provided first short, and
     * with the next shorts generated recursively from the first short until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered shorts collection holding a sequence of shorts.
     */
    public static OrderedShortCollection createSequence(final Short firstElement,
            final Function<? super Short, Short> generator, final Predicate<? super Short> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedShortCollection collection = ModifiableOrderedShortCollection.of(firstElement);
        Short element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered shorts collection holding a sequence of shorts generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered shorts collection holding a sequence of shorts.
     */
    public static OrderedShortCollection createSequence(final Function<Integer, Short> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedShortCollection collection = ModifiableOrderedShortCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered shorts collection holding a sequence of shorts generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered shorts collection holding a sequence of shorts.
     */
    public static OrderedShortCollection createSequence(final Function<Integer, Short> generator,
            final Predicate<? super Short> whileCondition) {
        Short firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedShortCollection collection = ModifiableOrderedShortCollection.of(firstElement);
        int index = 1;
        Short element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered shorts collection.
     *
     * @return A new empty ordered shorts collection.
     */
    public static OrderedShortCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Short element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Short element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Short> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Short element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered shorts collection with the specified shorts collection.
     *
     * @param numbers The shorts for the new ordered shorts collection.
     * @return A new ordered shorts collection with the specified shorts.
     */
    public static OrderedShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new ordered shorts collection.
     * @return A new ordered shorts collection with the specified element cardinality and the shorts.
     */
    public static OrderedShortCollection of(final ElementCardinality elementCardinality, final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered shorts collection cloned from the provided ordered shorts collection.
     *
     * @param collection The original ordered shorts collection.
     * @return A new ordered shorts collection cloned from the provided ordered shorts collection.
     */
    public static OrderedShortCollection of(final OrderedNumericCollection<Short> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered shorts collection cloned from a range in the provided ordered shorts collection.
     *
     * @param collection The original ordered shorts collection.
     * @param fromIndex  The index of the first element to be included in the new ordered shorts collection.
     * @param toIndex    The index of the first element not to be included in the new ordered shorts collection.
     * @return A new ordered shorts collection cloned from a range in the provided ordered shorts collection.
     */
    public static OrderedShortCollection of(final OrderedNumericCollection<Short> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedShortCollection slice =
                ModifiableOrderedShortCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered shorts collection as the matrix direct product of two ordered shorts collections.
     *
     * @param collectionA The first ordered shorts collection.
     * @param collectionB The second ordered shorts collection.
     * @return The matrix direct product of the two provided ordered shorts collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedShortCollection ofMatrixDirectProduct(final OrderedNumericCollection<Short> collectionA,
            final OrderedNumericCollection<Short> collectionB) throws IllegalArgumentException {
        ModifiableOrderedShortCollection collection = ModifiableOrderedShortCollection.empty();
        for (Short a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException(
                        "Cannot produce a matrix direct product when one of the collections contains null.");
            }
            for (Short b : collectionB) {
                if (b == null) {
                    throw new IllegalArgumentException(
                            "Cannot produce a matrix direct product when one of the collections contains null.");
                }
                collection.add((short) (a * b));
            }
        }
        return new ArrayCollection(collection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Short[] toArray() {
        return collection.toArray(EmptyArrays.SHORTS);
    }
}
