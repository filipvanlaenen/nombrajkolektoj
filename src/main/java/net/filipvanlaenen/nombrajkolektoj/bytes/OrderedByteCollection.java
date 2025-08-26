package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;

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
     * Returns a new empty ordered bytes collection.
     *
     * @return A new empty ordered bytes collection.
     */
    static OrderedByteCollection empty() {
        return new ArrayCollection();
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
    public Iterator<Byte> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new ordered bytes collection with the specified bytes.
     *
     * @param numbers The bytes for the new ordered bytes collection.
     * @return A new ordered bytes collection with the specified bytes.
     */
    static OrderedByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new ordered bytes collection.
     * @return A new ordered bytes collection with the specified element cardinality and the bytes.
     */
    static OrderedByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
