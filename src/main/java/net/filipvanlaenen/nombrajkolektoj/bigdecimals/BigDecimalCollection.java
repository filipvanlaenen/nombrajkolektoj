package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.NumericCollection} interface for
 * BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class BigDecimalCollection extends AbstractBigDecimalCollection
        implements NumericCollection<BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.Collection} interface.
     */
    public static final class ArrayCollection extends BigDecimalCollection {
        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray());
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param bigDecimals        The bigDecimals of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... bigDecimals) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigDecimal>(elementCardinality, bigDecimals));
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param bigDecimals The bigDecimals of the collection.
         */
        public ArrayCollection(final BigDecimal... bigDecimals) {
            super(new net.filipvanlaenen.kolektoj.array.ArrayCollection<BigDecimal>(bigDecimals));
        }
    }

    /**
     * The collection holding the BigDecimals.
     */
    private final Collection<BigDecimal> bigDecimals;

    /**
     * Private constructor taking a collection with the bigDecimals as its parameter.
     *
     * @param bigDecimals The collection holding the bigDecimals.
     */
    private BigDecimalCollection(final Collection<BigDecimal> bigDecimals) {
        this.bigDecimals = bigDecimals;
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return bigDecimals.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> collection) {
        return bigDecimals.containsAll(collection);
    }

    /**
     * Returns a new empty BbigDecimals collection.
     *
     * @return A new empty BigDecimals collection.
     */
    static BigDecimalCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return bigDecimals.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return bigDecimals.getElementCardinality();
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return bigDecimals.iterator();
    }

    /**
     * Returns a new BigDecimals collection with the specified BigDecimals.
     *
     * @param bigDecimals The BigDecimals for the new bigDecimals collection.
     * @return A new BigDecimals collection with the specified BigDecimals.
     */
    static BigDecimalCollection of(final BigDecimal... bigDecimals) {
        return new ArrayCollection(bigDecimals);
    }

    /**
     * Returns a new BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param bigDecimals        The BigDecimals for the new BigDecimals collection.
     * @return A new BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static BigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... bigDecimals) {
        return new ArrayCollection(elementCardinality, bigDecimals);
    }

    @Override
    public int size() {
        return bigDecimals.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return bigDecimals.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return bigDecimals.toArray();
    }
}
