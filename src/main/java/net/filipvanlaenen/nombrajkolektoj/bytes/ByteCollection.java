package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for bytes
 * and containing inner classes with concrete implementations.
 */
public abstract class ByteCollection extends AbstractByteCollection implements NumericCollection<Byte> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends ByteCollection {
        /**
         * Constructs a collection from another collection, with the same bytes and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Byte> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param bytes            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... bytes) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(elementCardinality, bytes));
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param bytes The bytes of the collection.
         */
        public ArrayCollection(final Byte... bytes) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(bytes));
        }
    }

    /**
     * The collection holding the bytes.
     */
    private final Collection<Byte> bytes;

    /**
     * Private constructor taking a collection with the bytes as its parameter.
     *
     * @param bytes The collection holding the bytes.
     */
    private ByteCollection(final Collection<Byte> bytes) {
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
     * Returns a new empty bytes collection.
     *
     * @return A new empty bytes collection.
     */
    static ByteCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return bytes.get();
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
     * Returns a new bytes collection with the specified bytes.
     *
     * @param bytes The bytes for the new bytes collection.
     * @return A new bytes collection with the specified bytes.
     */
    static ByteCollection of(final Byte... bytes) {
        return new ArrayCollection(bytes);
    }

    /**
     * Returns a new bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param bytes            The bytes for the new bytes collection.
     * @return A new bytes collection with the specified element cardinality and the bytes.
     */
    static ByteCollection of(final ElementCardinality elementCardinality, final Byte... bytes) {
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
