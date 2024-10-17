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
         * @param bytes            The bytes of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... bytes) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte>(elementCardinality, bytes));
        }

        /**
         * Constructs an ordered collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param bytes The bytes of the ordered collection.
         */
        public ArrayCollection(final Byte... bytes) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Byte>(bytes));
        }
    }

    /**
     * The ordered collection holding the bytes.
     */
    private final OrderedCollection<Byte> bytes;

    /**
     * Private constructor taking an ordered collection with the bytes as its parameter.
     *
     * @param bytes The ordered collection holding the bytes.
     */
    private OrderedByteCollection(final OrderedCollection<Byte> bytes) {
        this.bytes = bytes;
    }

    @Override
    public boolean contains(final Byte element) {
        return bytes.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return bytes.containsAll(collection);
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
        return bytes.get();
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return bytes.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return bytes.getElementCardinality();
    }

    @Override
    public Iterator<Byte> iterator() {
        return bytes.iterator();
    }

    /**
     * Returns a new ordered bytes collection with the specified bytes.
     *
     * @param bytes The bytes for the new ordered bytes collection.
     * @return A new ordered bytes collection with the specified bytes.
     */
    static OrderedByteCollection of(final Byte... bytes) {
        return new ArrayCollection(bytes);
    }

    /**
     * Returns a new ordered bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param bytes            The bytes for the new ordered bytes collection.
     * @return A new ordered bytes collection with the specified element cardinality and the bytes.
     */
    static OrderedByteCollection of(final ElementCardinality elementCardinality, final Byte... bytes) {
        return new ArrayCollection(elementCardinality, bytes);
    }

    @Override
    public int size() {
        return bytes.size();
    }

    @Override
    public Spliterator<Byte> spliterator() {
        return bytes.spliterator();
    }

    @Override
    public Byte[] toArray() {
        return bytes.toArray(EmptyArrays.BYTES);
    }
}
