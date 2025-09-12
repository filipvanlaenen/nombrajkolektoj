package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class ModifiableBigDecimalCollection extends AbstractModifiableBigDecimalCollection
        implements ModifiableNumericCollection<BigDecimal> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableBigDecimalCollection {
        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new ModifiableArrayCollection<BigDecimal>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            super(new ModifiableArrayCollection<BigDecimal>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableBigDecimalCollection {
        /**
         * Constructs a collection from another collection, with the same BigDecimals and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new ModifiableLinkedListCollection<BigDecimal>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public LinkedListCollection(final BigDecimal... numbers) {
            super(new ModifiableLinkedListCollection<BigDecimal>(numbers));
        }
    }

    /**
     * The modifiable collection holding the BigDecimals.
     */
    private final ModifiableCollection<BigDecimal> collection;

    /**
     * Private constructor taking a collection with the BigDecimals as its parameter.
     *
     * @param numbers The collection holding the BigDecimals.
     */
    private ModifiableBigDecimalCollection(final ModifiableCollection<BigDecimal> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final BigDecimal element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends BigDecimal> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable BigDecimal collection.
     *
     * @return A new empty modifiable BigDecimal collection.
     */
    static ModifiableBigDecimalCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new modifiable BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new modifiable BigDecimals collection.
     * @return A new modifiable BigDecimals collection with the specified BigDecimals.
     */
    static ModifiableBigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new modifiable BigDecimals collection.
     * @return A new modifiable BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    static ModifiableBigDecimalCollection of(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public boolean remove(final BigDecimal element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends BigDecimal> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public boolean removeIf(final Predicate<? super BigDecimal> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends BigDecimal> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return collection.toArray(EmptyArrays.BIG_DECIMALS);
    }
}
