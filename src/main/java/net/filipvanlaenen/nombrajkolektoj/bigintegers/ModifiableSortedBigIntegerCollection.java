package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection}
 * interface for BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedBigIntegerCollection extends AbstractModifiableSortedBigIntegerCollection
        implements ModifiableSortedNumericCollection<BigInteger> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedBigIntegerCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same BigIntegers and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<BigInteger> comparator, final Collection<BigInteger> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a modifiable sorted collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<BigInteger> comparator,
                final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<BigInteger>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigIntegers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<BigInteger> comparator, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<BigInteger>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the BigIntegers.
     */
    private final ModifiableSortedCollection<BigInteger> collection;

    /**
     * Private constructor taking a sorted collection with the BigIntegers as its parameter.
     *
     * @param collection The sorted collection holding the BigIntegers.
     */
    private ModifiableSortedBigIntegerCollection(final ModifiableSortedCollection<BigInteger> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(final BigInteger element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends BigInteger> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final BigInteger element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable sorted BigIntegers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigIntegers collection.
     */
    static ModifiableSortedBigIntegerCollection empty(final Comparator<BigInteger> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final BigInteger element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super BigInteger> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public BigInteger getGreaterThan(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public BigInteger getGreaterThanOrEqualTo(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public BigInteger getLessThan(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public BigInteger getLessThanOrEqualTo(final BigInteger element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final BigInteger element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigInteger element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers    The BigIntegers for the new modifiable sorted BigIntegers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted BigIntegers collection with the specified BigIntegers.
     */
    static ModifiableSortedBigIntegerCollection of(final Comparator<BigInteger> comparator, final BigInteger... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The BigIntegers for the new modifiable sorted BigIntegers collection.
     * @return A new modifiable sorted BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    static ModifiableSortedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<BigInteger> comparator, final BigInteger... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public boolean remove(final BigInteger element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends BigInteger> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public BigInteger removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super BigInteger> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends BigInteger> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return collection.toArray(EmptyArrays.BIG_INTEGERS);
    }
}
