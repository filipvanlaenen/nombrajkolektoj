package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.function.Function;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * bytes and containing inner classes with concrete implementations.
 */
public interface OrderedByteCollection extends OrderedNumericCollection<Byte>, ByteCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedByteCollectionDecorator {
        private net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte> decoratedCollection;

        @Override
        OrderedCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs an ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the ordered collection.
         */
        public ArrayCollection(final Byte... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte>(numbers);
        }

        /**
         * Constructs an ordered collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The bytes of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte>(elementCardinality, numbers);
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same bytes and the provided
         * element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Byte> source) {
            this(elementCardinality, source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs an ordered collection from another ordered collection, with the same bytes and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Byte> source) {
            this(source.getElementCardinality(), source);
        }
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

    /**
     * Returns a new ordered bytes collection as the matrix direct product of two ordered bytes collections.
     *
     * @param collectionA The first ordered bytes collection.
     * @param collectionB The second ordered bytes collection.
     * @return The matrix direct product of the two provided ordered bytes collections.
     * @throws IllegalArgumentException Thrown if one of the collections contains <code>null</code>.
     */
    public static OrderedByteCollection matrixDirectProductOf(final OrderedNumericCollection<Byte> collectionA,
            final OrderedNumericCollection<Byte> collectionB) throws IllegalArgumentException {
        ModifiableOrderedByteCollection collection = ModifiableOrderedByteCollection.empty();
        for (Byte a : collectionA) {
            if (a == null) {
                throw new IllegalArgumentException(
                        "Cannot produce a matrix direct product when one of the collections contains null.");
            }
            for (Byte b : collectionB) {
                if (b == null) {
                    throw new IllegalArgumentException(
                            "Cannot produce a matrix direct product when one of the collections contains null.");
                }
                collection.add((byte) (a * b));
            }
        }
        return new ArrayCollection(collection);
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
     * Returns a new ordered bytes collection cloned from the provided ordered bytes collection with the specified
     * element cardinality.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered bytes collection.
     * @return A new ordered bytes collection cloned from the provided ordered bytes collection with the specified
     *         element cardinality.
     */
    public static OrderedByteCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, collection);
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

    /**
     * Returns a new ordered bytes collection with the specified element cardinality containing all the elements from
     * the provided ordered bytes collections.
     *
     * @param elementCardinality The element cardinality.
     * @param collections        The ordered bytes collections from which to copy all the elements.
     * @return A new ordered bytes collection with the specified element cardinality containing all the elements from
     *         the provided ordered bytes collections.
     */
    public static OrderedByteCollection unionOf(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Byte>... collections) {
        ModifiableOrderedByteCollection result = ModifiableOrderedByteCollection.of(elementCardinality);
        for (OrderedNumericCollection<Byte> collection : collections) {
            result.addAllLast(collection);
        }
        return new ArrayCollection(result);
    }

    /**
     * Returns a new ordered bytes collection containing all the elements from the provided ordered bytes
     * collections.
     *
     * @param collections The ordered bytes collections from which to copy all the elements.
     * @return A new ordered bytes collection containing all the elements from the provided ordered bytes
     *         collections.
     */
    public static OrderedByteCollection unionOf(final OrderedNumericCollection<Byte>... collections) {
        return unionOf(ElementCardinality.DUPLICATE_ELEMENTS, collections);
    }
}
