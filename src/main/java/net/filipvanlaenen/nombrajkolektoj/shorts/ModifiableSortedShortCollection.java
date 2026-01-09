package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection}
 * interface for shorts and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedShortCollection extends AbstractModifiableSortedShortCollection
        implements ModifiableSortedNumericCollection<Short> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedShortCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same shorts and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a modifiable sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The shorts of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Short>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Short>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the shorts.
     */
    private final ModifiableSortedCollection<Short> collection;

    /**
     * Private constructor taking a sorted collection with the shorts as its parameter.
     *
     * @param collection The sorted collection holding the shorts.
     */
    private ModifiableSortedShortCollection(final ModifiableSortedCollection<Short> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(final Short element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Short> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Short element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable sorted shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted shorts collection.
     */
    public static ModifiableSortedShortCollection empty(final Comparator<Short> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Short element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Short> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Short getGreaterThan(final Short element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Short getGreaterThanOrEqualTo(final Short element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Short getLessThan(final Short element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Short getLessThanOrEqualTo(final Short element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Short element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Short> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Short element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted shorts collection with the specified shorts.
     *
     * @param numbers    The shorts for the new modifiable sorted shorts collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted shorts collection with the specified shorts.
     */
    public static ModifiableSortedShortCollection of(final Comparator<? super Short> comparator,
            final Short... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from the provided shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original shorts collection.
     * @return A new sorted modifiable shorts collection cloned from the provided shorts collection.
     */
    public static ModifiableSortedShortCollection of(final Comparator<? super Short> comparator,
            final ShortCollection collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from a range in the provided ordered shorts
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered shorts collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted shorts collection cloned from a range in the provided ordered shorts
     *         collection.
     */
    public static ModifiableSortedShortCollection of(final Comparator<? super Short> comparator,
            final OrderedShortCollection collection, final int fromIndex, final int toIndex) {
        ModifiableSortedShortCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The shorts for the new modifiable sorted shorts collection.
     * @return A new modifiable sorted shorts collection with the specified element cardinality and the shorts.
     */
    public static ModifiableSortedShortCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Short> comparator, final Short... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @return A new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     */
    public static ModifiableSortedShortCollection of(final SortedShortCollection collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @param range      The range.
     * @return A new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     */
    public static ModifiableSortedShortCollection of(final SortedShortCollection collection,
            final Range<Short> range) {
        ModifiableSortedShortCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Short element : collection) {
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
    public boolean remove(final Short element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Short> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Short removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Short> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Short> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Short[] toArray() {
        return collection.toArray(EmptyArrays.SHORTS);
    }
}
