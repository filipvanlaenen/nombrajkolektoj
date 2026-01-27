package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection}
 * interface for BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedBigDecimalCollection extends AbstractModifiableSortedBigDecimalCollection
        implements ModifiableSortedNumericCollection<BigDecimal> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedBigDecimalCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same BigDecimals and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final Collection<BigDecimal> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a modifiable sorted collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<BigDecimal>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The BigDecimals of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<BigDecimal>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the BigDecimals.
     */
    private final ModifiableSortedCollection<BigDecimal> collection;

    /**
     * Private constructor taking a sorted collection with the BigDecimals as its parameter.
     *
     * @param collection The sorted collection holding the BigDecimals.
     */
    private ModifiableSortedBigDecimalCollection(final ModifiableSortedCollection<BigDecimal> collection) {
        this.collection = collection;
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
     * Returns a new empty modifiable sorted BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted BigDecimals collection.
     */
    public static ModifiableSortedBigDecimalCollection empty(final Comparator<BigDecimal> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super BigDecimal> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public BigDecimal getGreaterThan(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public BigDecimal getGreaterThanOrEqualTo(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public BigDecimal getLessThan(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public BigDecimal getLessThanOrEqualTo(final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final BigDecimal element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers    The BigDecimals for the new modifiable sorted BigDecimals collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted BigDecimals collection with the specified BigDecimals.
     */
    public static ModifiableSortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final BigDecimal... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from the provided BigDecimals collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original BigDecimals collection.
     * @return A new sorted modifiable BigDecimals collection cloned from the provided BigDecimals collection.
     */
    public static ModifiableSortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final NumericCollection<BigDecimal> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from a range in the provided ordered BigDecimals
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered BigDecimals collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted BigDecimals collection cloned from a range in the provided ordered BigDecimals
     *         collection.
     */
    public static ModifiableSortedBigDecimalCollection of(final Comparator<? super BigDecimal> comparator,
            final OrderedNumericCollection<BigDecimal> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedBigDecimalCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The BigDecimals for the new modifiable sorted BigDecimals collection.
     * @return A new modifiable sorted BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    public static ModifiableSortedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super BigDecimal> comparator, final BigDecimal... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @return A new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    public static ModifiableSortedBigDecimalCollection of(final SortedNumericCollection<BigDecimal> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     *
     * @param collection The original sorted BigDecimals collection.
     * @param range      The range.
     * @return A new modifiable sorted BigDecimals collection cloned from the provided sorted BigDecimals collection.
     */
    public static ModifiableSortedBigDecimalCollection of(final SortedNumericCollection<BigDecimal> collection,
            final Range<BigDecimal> range) {
        ModifiableSortedBigDecimalCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (BigDecimal element : collection) {
            if (below && !range.isBelow(collection.getComparator(), element)) {
                below = false;
            }
            if (!below) {
                if (range.isAbove(collection.getComparator(), element)) {
                    break;
                }
                result.add(element);
            }
        }
        return result;
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
    public BigDecimal removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
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
