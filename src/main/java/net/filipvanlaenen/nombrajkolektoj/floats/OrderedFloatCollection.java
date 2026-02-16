package net.filipvanlaenen.nombrajkolektoj.floats;

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
 * floats and containing inner classes with concrete implementations.
 */
public abstract class OrderedFloatCollection extends AbstractOrderedFloatCollection
        implements OrderedNumericCollection<Float> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedFloatCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same floats and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs an ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Float>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the ordered collection.
         */
        public ArrayCollection(final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Float>(numbers));
        }
    }

    /**
     * The ordered collection holding the floats.
     */
    private final OrderedCollection<Float> collection;

    /**
     * Private constructor taking an ordered collection with the floats as its parameter.
     *
     * @param numbers The ordered collection holding the floats.
     */
    private OrderedFloatCollection(final OrderedCollection<Float> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Float element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
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
    public static OrderedFloatCollection createSequence(final Float firstElement,
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
    public static OrderedFloatCollection createSequence(final Float firstElement,
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
    public static OrderedFloatCollection createSequence(final Function<Integer, Float> generator,
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
    public static OrderedFloatCollection createSequence(final Function<Integer, Float> generator,
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
    public static OrderedFloatCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Float element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Float element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Float> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Float element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered floats collection with the specified floats collection.
     *
     * @param numbers The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified floats.
     */
    public static OrderedFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new ordered floats collection.
     * @return A new ordered floats collection with the specified element cardinality and the floats.
     */
    public static OrderedFloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered floats collection cloned from the provided ordered floats collection.
     *
     * @param collection The original ordered floats collection.
     * @return A new ordered floats collection cloned from the provided ordered floats collection.
     */
    public static OrderedFloatCollection of(final OrderedNumericCollection<Float> collection) {
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
    public static OrderedFloatCollection of(final OrderedNumericCollection<Float> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedFloatCollection slice =
                ModifiableOrderedFloatCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.addLast(collection.getAt(i));
        }
        return new ArrayCollection(slice);
    }

    /**
     * Returns a new ordered floats collection as the matrix direct product of two ordered floats collections.
     *
     * @param collectionA The first ordered floats collection.
     * @param collectionB The second ordered floats collection.
     * @return The matrix direct product of the two provided ordered floats collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedFloatCollection ofMatrixDirectProduct(final OrderedNumericCollection<Float> collectionA,
            final OrderedNumericCollection<Float> collectionB) throws IllegalArgumentException {
        ModifiableOrderedFloatCollection collection = ModifiableOrderedFloatCollection.empty();
        for (Float a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException("One of the collections contains null.");
            }
            for (Float b : collectionB) {
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
    public Spliterator<Float> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Float[] toArray() {
        return collection.toArray(EmptyArrays.FLOATS);
    }
}
