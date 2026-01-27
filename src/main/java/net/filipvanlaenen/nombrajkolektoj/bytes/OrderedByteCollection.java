package net.filipvanlaenen.nombrajkolektoj.bytes;

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
 * bytes and containing inner classes with concrete implementations.
 */
public abstract class OrderedByteCollection extends AbstractOrderedByteCollection
        implements OrderedNumericCollection<Byte> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedByteCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same bytes and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Byte> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs an ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the ordered collection.
         */
        public ArrayCollection(final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte>(numbers));
        }
    }

    /**
     * The ordered collection holding the bytes.
     */
    private final OrderedCollection<Byte> collection;

    /**
     * Private constructor taking an ordered collection with the bytes as its parameter.
     *
     * @param numbers The ordered collection holding the bytes.
     */
    private OrderedByteCollection(final OrderedCollection<Byte> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Byte element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns an ordered bytes collection holding a sequence of bytes, starting with the provided first byte, and
     * with the next bytes generated recursively from the first byte.
     *
     * @param firstElement     The first element of the sequence.
     * @param generator        A function generating a next element when given an element.
     * @param numberOfElements The requested number of elements.
     * @return An ordered bytes collection holding a sequence of bytes.
     */
    public static OrderedByteCollection createSequence(final Byte firstElement,
            final Function<? super Byte, Byte> generator, final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedByteCollection collection = ModifiableOrderedByteCollection.of(firstElement);
        Byte element = firstElement;
        for (int i = 1; i < numberOfElements; i++) {
            element = generator.apply(element);
            collection.add(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered bytes collection holding a sequence of bytes, starting with the provided first byte, and
     * with the next bytes generated recursively from the first byte until a condition evaluates to false.
     *
     * @param firstElement   The first element of the sequence.
     * @param generator      A function generating a next element when given an element.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered bytes collection holding a sequence of bytes.
     */
    public static OrderedByteCollection createSequence(final Byte firstElement,
            final Function<? super Byte, Byte> generator, final Predicate<? super Byte> whileCondition) {
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedByteCollection collection = ModifiableOrderedByteCollection.of(firstElement);
        Byte element = generator.apply(firstElement);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(element);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered bytes collection holding a sequence of bytes generated from a function taking an index as
     * its parameter.
     *
     * @param generator        A function generating an element from an index.
     * @param numberOfElements The requested number of elements.
     * @return An ordered bytes collection holding a sequence of bytes.
     */
    public static OrderedByteCollection createSequence(final Function<Integer, Byte> generator,
            final int numberOfElements) {
        if (numberOfElements < 1) {
            return empty();
        }
        ModifiableOrderedByteCollection collection = ModifiableOrderedByteCollection.of(generator.apply(0));
        for (int i = 1; i < numberOfElements; i++) {
            collection.add(generator.apply(i));
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns an ordered bytes collection holding a sequence of bytes generated from a function taking an index as
     * its parameter until a condition evaluates to false.
     *
     * @param generator      A function generating an element from an index.
     * @param whileCondition A predicate defining a condition to be met by the generated elements to be part of the
     *                       sequence.
     * @return An ordered bytes collection holding a sequence of bytes.
     */
    public static OrderedByteCollection createSequence(final Function<Integer, Byte> generator,
            final Predicate<? super Byte> whileCondition) {
        Byte firstElement = generator.apply(0);
        if (!whileCondition.test(firstElement)) {
            return empty();
        }
        ModifiableOrderedByteCollection collection = ModifiableOrderedByteCollection.of(firstElement);
        int index = 1;
        Byte element = generator.apply(index);
        while (whileCondition.test(element)) {
            collection.add(element);
            element = generator.apply(++index);
        }
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new empty ordered bytes collection.
     *
     * @return A new empty ordered bytes collection.
     */
    public static OrderedByteCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Byte element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Byte element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Byte> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Byte element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered bytes collection with the specified bytes collection.
     *
     * @param numbers The bytes for the new ordered bytes collection.
     * @return A new ordered bytes collection with the specified bytes.
     */
    public static OrderedByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new ordered bytes collection.
     * @return A new ordered bytes collection with the specified element cardinality and the bytes.
     */
    public static OrderedByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new ordered bytes collection cloned from the provided ordered bytes collection.
     *
     * @param collection The original ordered bytes collection.
     * @return A new ordered bytes collection cloned from the provided ordered bytes collection.
     */
    public static OrderedByteCollection of(final OrderedNumericCollection<Byte> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new ordered bytes collection cloned from a range in the provided ordered bytes collection.
     *
     * @param collection The original ordered bytes collection.
     * @param fromIndex  The index of the first element to be included in the new ordered bytes collection.
     * @param toIndex    The index of the first element not to be included in the new ordered bytes collection.
     * @return A new ordered bytes collection cloned from a range in the provided ordered bytes collection.
     */
    public static OrderedByteCollection of(final OrderedNumericCollection<Byte> collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedByteCollection slice =
                ModifiableOrderedByteCollection.of(collection.getElementCardinality());
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
    public Spliterator<Byte> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Byte[] toArray() {
        return collection.toArray(EmptyArrays.BYTES);
    }
}
