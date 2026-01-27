package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * shorts and containing inner classes with concrete implementations.
 */
public abstract class SortedShortCollection extends AbstractSortedShortCollection
        implements SortedNumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    public static final class ArrayCollection extends SortedShortCollection {
        /**
         * Constructs a sorted collection from a collection, with the same shorts and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The shorts of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Short> comparator,
                final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Short>(elementCardinality, comparator,
                    numbers));
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.SortedArrayCollection<Short>(comparator, numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    public static final class SortedTreeCollection extends SortedShortCollection {
        /**
         * Constructs a sorted collection from a collection, with the same shorts and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The shorts of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(comparator, numbers));
        }
    }

    /**
     * The sorted collection holding the shorts.
     */
    private final SortedCollection<Short> collection;

    /**
     * Private constructor taking a sorted collection with the shorts as its parameter.
     *
     * @param collection The sorted collection holding the shorts.
     */
    private SortedShortCollection(final SortedCollection<Short> collection) {
        this.collection = collection;
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
     * Returns a new empty sorted shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted shorts collection.
     */
    public static SortedShortCollection empty(final Comparator<? super Short> comparator) {
        return new ArrayCollection(comparator);
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

    /**
     * Returns a new sorted shorts collection with the specified shorts.
     *
     * @param numbers    The shorts for the new sorted shorts collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted shorts collection with the specified shorts.
     */
    public static SortedShortCollection of(final Comparator<? super Short> comparator, final Short... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted shorts collection cloned from the provided shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original shorts collection.
     * @return A new sorted shorts collection cloned from the provided shorts collection.
     */
    public static SortedShortCollection of(final Comparator<? super Short> comparator,
            final NumericCollection<Short> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted shorts collection cloned from a range in the provided ordered shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered shorts collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted shorts collection cloned from a range in the provided ordered collection.
     */
    public static SortedShortCollection of(final Comparator<? super Short> comparator,
            final OrderedNumericCollection<Short> collection, final int fromIndex, final int toIndex) {
        ModifiableShortCollection slice = ModifiableShortCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The shorts for the new sorted shorts collection.
     * @return A new sorted shorts collection with the specified element cardinality and the shorts.
     */
    public static SortedShortCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Short> comparator, final Short... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @return A new sorted shorts collection cloned from the provided sorted shorts collection.
     */
    public static SortedShortCollection of(final SortedNumericCollection<Short> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @param range      The range.
     * @return A new sorted shorts collection cloned from the provided sorted shorts collection.
     */
    public static SortedShortCollection of(final SortedNumericCollection<Short> collection,
            final Range<Short> range) {
        ModifiableShortCollection slice = ModifiableShortCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (Short element : collection) {
            if (below && !range.isBelow(collection.getComparator(), element)) {
                below = false;
            }
            if (!below) {
                if (range.isAbove(collection.getComparator(), element)) {
                    break;
                }
                slice.add(element);
            }
        }
        return new ArrayCollection(collection.getComparator(), slice);
    }

    @Override
    public int lastIndexOf(final Short element) {
        return collection.lastIndexOf(element);
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
