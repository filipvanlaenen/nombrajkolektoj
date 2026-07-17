package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection}
 * interface for bytes and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedByteCollection
        extends ModifiableSortedNumericCollection<Byte>, SortedByteCollection, ModifiableByteCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    final class SortedTreeCollection extends ModifiableSortedByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableSortedTreeCollection<Byte> decoratedCollection;

        @Override
        ModifiableSortedCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same bytes and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Byte> comparator, final Collection<Byte> source) {
            this(source.getElementCardinality(), comparator, source);
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
            decoratedCollection = new ModifiableSortedTreeCollection<Byte>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same bytes and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Byte> comparator, final Collection<Byte> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a modifiable sorted collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The bytes of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Byte> comparator, final Byte... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Byte>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted bytes collection.
     */
    static ModifiableSortedByteCollection empty(final Comparator<Byte> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted bytes collection with the specified bytes.
     *
     * @param numbers    The bytes for the new modifiable sorted bytes collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted bytes collection with the specified bytes.
     */
    static ModifiableSortedByteCollection of(final Comparator<? super Byte> comparator, final Byte... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from the provided bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original bytes collection.
     * @return A new sorted modifiable bytes collection cloned from the provided bytes collection.
     */
    static ModifiableSortedByteCollection of(final Comparator<? super Byte> comparator,
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
    static ModifiableSortedByteCollection of(final Comparator<? super Byte> comparator,
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
    static ModifiableSortedByteCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Byte> comparator, final Byte... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted bytes collection with the specified element cardinality cloned from the
     * provided bytes collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original bytes collection.
     * @return A new modifiable sorted bytes collection with the specified element cardinality cloned from the
     *         provided bytes collection.
     */
    static ModifiableSortedByteCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Byte> comparator, final NumericCollection<Byte> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     *
     * @param collection The original sorted bytes collection.
     * @return A new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     */
    static ModifiableSortedByteCollection of(final SortedNumericCollection<Byte> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     *
     * @param collection The original sorted bytes collection.
     * @param range      The range.
     * @return A new modifiable sorted bytes collection cloned from the provided sorted bytes collection.
     */
    static ModifiableSortedByteCollection of(final SortedNumericCollection<Byte> collection,
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
}
