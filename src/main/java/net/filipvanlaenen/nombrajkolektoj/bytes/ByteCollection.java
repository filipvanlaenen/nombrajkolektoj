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
         * @param numbers            The bytes of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The bytes of the collection.
         */
        public ArrayCollection(final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<Byte>(numbers));
        }
    }

    /**
     * The collection holding the bytes.
     */
    private final Collection<Byte> numbers;

    /**
     * Private constructor taking a collection with the bytes as its parameter.
     *
     * @param numbers The collection holding the bytes.
     */
    private ByteCollection(final Collection<Byte> numbers) {
        this.numbers = numbers;
    }

    @Override
    public boolean contains(final Byte element) {
        return numbers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return numbers.containsAll(collection);
    }

    /**
     * Returns a new empty bytes collection.
     *
     * @return A new empty bytes collection.
     */
    public static ByteCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return numbers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return numbers.getElementCardinality();
    }

    @Override
    public Iterator<Byte> iterator() {
        return numbers.iterator();
    }

    /**
     * Returns a new bytes collection cloned from the provided bytes collection.
     *
     * @param collection The original bytes collection.
     * @return A new bytes collection cloned from the provided bytes collection.
     */
    public static ByteCollection of(final NumericCollection<Byte> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new bytes collection with the specified bytes.
     *
     * @param numbers The bytes for the new bytes collection.
     * @return A new bytes collection with the specified bytes.
     */
    public static ByteCollection of(final Byte... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes for the new bytes collection.
     * @return A new bytes collection with the specified element cardinality and the bytes.
     */
    public static ByteCollection of(final ElementCardinality elementCardinality, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return numbers.size();
    }

    @Override
    public Spliterator<Byte> spliterator() {
        return numbers.spliterator();
    }

    @Override
    public Byte[] toArray() {
        return numbers.toArray(EmptyArrays.BYTES);
    }
}
