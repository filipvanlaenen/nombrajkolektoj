package net.filipvanlaenen.nombrajkolektoj.longs;

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
 * interface for longs and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedLongCollection extends AbstractModifiableSortedLongCollection
        implements ModifiableSortedNumericCollection<Long> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedLongCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same longs and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Long> comparator, final Collection<Long> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.LONGS));
        }

        /**
         * Constructs a modifiable sorted collection with the given longs and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The longs of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Long> comparator, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Long>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given longs. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The longs of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Long> comparator, final Long... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Long>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the longs.
     */
    private final ModifiableSortedCollection<Long> collection;

    /**
     * Private constructor taking a sorted collection with the longs as its parameter.
     *
     * @param collection The sorted collection holding the longs.
     */
    private ModifiableSortedLongCollection(final ModifiableSortedCollection<Long> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(final Long element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Long> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Long element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable sorted longs collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted longs collection.
     */
    public static ModifiableSortedLongCollection empty(final Comparator<Long> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Long element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Long get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Long getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Long> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Long getGreaterThan(final Long element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Long getGreaterThanOrEqualTo(final Long element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Long getLessThan(final Long element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Long getLessThanOrEqualTo(final Long element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Long element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Long> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Long element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted longs collection with the specified longs.
     *
     * @param numbers    The longs for the new modifiable sorted longs collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted longs collection with the specified longs.
     */
    public static ModifiableSortedLongCollection of(final Comparator<? super Long> comparator,
            final Long... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from the provided longs collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original longs collection.
     * @return A new sorted modifiable longs collection cloned from the provided longs collection.
     */
    public static ModifiableSortedLongCollection of(final Comparator<? super Long> comparator,
            final NumericCollection<Long> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from a range in the provided ordered longs
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered longs collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted longs collection cloned from a range in the provided ordered longs
     *         collection.
     */
    public static ModifiableSortedLongCollection of(final Comparator<? super Long> comparator,
            final OrderedNumericCollection<Long> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedLongCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted longs collection with the specified element cardinality and the longs.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The longs for the new modifiable sorted longs collection.
     * @return A new modifiable sorted longs collection with the specified element cardinality and the longs.
     */
    public static ModifiableSortedLongCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Long> comparator, final Long... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from the provided sorted longs collection.
     *
     * @param collection The original sorted longs collection.
     * @return A new modifiable sorted longs collection cloned from the provided sorted longs collection.
     */
    public static ModifiableSortedLongCollection of(final SortedNumericCollection<Long> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted longs collection cloned from the provided sorted longs collection.
     *
     * @param collection The original sorted longs collection.
     * @param range      The range.
     * @return A new modifiable sorted longs collection cloned from the provided sorted longs collection.
     */
    public static ModifiableSortedLongCollection of(final SortedNumericCollection<Long> collection,
            final Range<Long> range) {
        ModifiableSortedLongCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Long element : collection) {
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
    public boolean remove(final Long element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Long> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Long removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Long> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Long> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Long> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Long[] toArray() {
        return collection.toArray(EmptyArrays.LONGS);
    }
}
