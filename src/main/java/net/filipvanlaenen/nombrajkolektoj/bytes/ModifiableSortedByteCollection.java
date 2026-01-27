package net.filipvanlaenen.nombrajkolektoj.bytes;

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
 * interface for bytes and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedByteCollection extends AbstractModifiableSortedByteCollection
        implements ModifiableSortedNumericCollection<Byte> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedByteCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same bytes and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Byte> comparator, final Collection<Byte> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a modifiable sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The bytes of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Byte> comparator, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Byte>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The bytes of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Byte> comparator, final Byte... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Byte>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the bytes.
     */
    private final ModifiableSortedCollection<Byte> collection;

    /**
     * Private constructor taking a sorted collection with the bytes as its parameter.
     *
     * @param collection The sorted collection holding the bytes.
     */
    private ModifiableSortedByteCollection(final ModifiableSortedCollection<Byte> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(final Byte element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Byte> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Byte element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable sorted bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted bytes collection.
     */
    public static ModifiableSortedByteCollection empty(final Comparator<Byte> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Byte element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Byte get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Byte getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Byte> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Byte getGreaterThan(final Byte element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Byte getGreaterThanOrEqualTo(final Byte element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Byte getLessThan(final Byte element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Byte getLessThanOrEqualTo(final Byte element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Byte element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Byte> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Byte element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted bytes collection with the specified bytes.
     *
     * @param numbers    The bytes for the new modifiable sorted bytes collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted bytes collection with the specified bytes.
     */
    public static ModifiableSortedByteCollection of(final Comparator<? super Byte> comparator,
            final Byte... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from the provided bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original bytes collection.
     * @return A new sorted modifiable bytes collection cloned from the provided bytes collection.
     */
    public static ModifiableSortedByteCollection of(final Comparator<? super Byte> comparator,
            final NumericCollection<Byte> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from a range in the provided ordered bytes
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered bytes collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted bytes collection cloned from a range in the provided ordered bytes
     *         collection.
     */
    public static ModifiableSortedByteCollection of(final Comparator<? super Byte> comparator,
            final OrderedNumericCollection<Byte> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedByteCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The bytes for the new modifiable sorted bytes collection.
     * @return A new modifiable sorted bytes collection with the specified element cardinality and the bytes.
     */
    public static ModifiableSortedByteCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Byte> comparator, final Byte... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     *
     * @param collection The original sorted bytes collection.
     * @return A new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     */
    public static ModifiableSortedByteCollection of(final SortedNumericCollection<Byte> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     *
     * @param collection The original sorted bytes collection.
     * @param range      The range.
     * @return A new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     */
    public static ModifiableSortedByteCollection of(final SortedNumericCollection<Byte> collection,
            final Range<Byte> range) {
        ModifiableSortedByteCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Byte element : collection) {
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
    public boolean remove(final Byte element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Byte> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Byte removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Byte> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Byte> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Byte> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Byte[] toArray() {
        return collection.toArray(EmptyArrays.BYTES);
    }
}
