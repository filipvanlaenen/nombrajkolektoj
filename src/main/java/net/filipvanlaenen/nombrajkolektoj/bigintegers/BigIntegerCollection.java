package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for
 * BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class BigIntegerCollection extends AbstractBigIntegerCollection
        implements NumericCollection<BigInteger> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends BigIntegerCollection {
        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray());
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param bigIntegers        The bigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... bigIntegers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(elementCardinality, bigIntegers));
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param bigIntegers The bigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... bigIntegers) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigInteger>(bigIntegers));
        }
    }

    /**
     * The collection holding the BigIntegers.
     */
    private final Collection<BigInteger> bigIntegers;

    /**
     * Private constructor taking a collection with the BigIntegers as its parameter.
     *
     * @param bigIntegers The collection holding the BigIntegers.
     */
    private BigIntegerCollection(final Collection<BigInteger> bigIntegers) {
        this.bigIntegers = bigIntegers;
    }

    @Override
    public boolean contains(final BigInteger element) {
        return bigIntegers.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return bigIntegers.containsAll(collection);
    }

    /**
     * Returns a new empty BigIntegers collection.
     *
     * @return A new empty BigIntegers collection.
     */
    static BigIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return bigIntegers.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return bigIntegers.getElementCardinality();
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return bigIntegers.iterator();
    }

    /**
     * Returns a new BigIntegers collection with the specified BigIntegers.
     *
     * @param bigIntegers The BigIntegers for the new bigIntegers collection.
     * @return A new BigIntegers collection with the specified BigIntegers.
     */
    static BigIntegerCollection of(final BigInteger... bigIntegers) {
        return new ArrayCollection(bigIntegers);
    }

    /**
     * Returns a new BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param bigIntegers        The BigIntegers for the new BigIntegers collection.
     * @return A new BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static BigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... bigIntegers) {
        return new ArrayCollection(elementCardinality, bigIntegers);
    }

    @Override
    public int size() {
        return bigIntegers.size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return bigIntegers.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return bigIntegers.toArray();
    }
}
