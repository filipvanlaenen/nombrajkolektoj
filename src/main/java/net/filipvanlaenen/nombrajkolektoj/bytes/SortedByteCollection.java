package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.Comparator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.Range;
import net.filipvanlaenen.kolektoj.SortedCollection;
import net.filipvanlaenen.kolektoj.array.SortedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.SortedNumericCollection} interface for
 * bytes and containing inner classes with concrete implementations.
 */
public interface SortedByteCollection extends SortedNumericCollection<Byte>, OrderedByteCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    final class ArrayCollection extends SortedByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private SortedArrayCollection<Byte> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same bytes and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super Byte> comparator, final Collection<Byte> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The bytes of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super Byte> comparator, final Byte... numbers) {
            decoratedCollection = new SortedArrayCollection<Byte>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The bytes collection to create a new sorted bytes collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Byte> comparator,
                final Collection<Byte> source) {
            decoratedCollection = new SortedArrayCollection<Byte>(elementCardinality, comparator,
                    source.toArray(EmptyArrays.BYTES));
        }

        /**
         * Constructs a sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The bytes of the sorted collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Byte> comparator,
                final Byte... numbers) {
            decoratedCollection = new SortedArrayCollection<Byte>(elementCardinality, comparator, numbers);
        }

        @Override
        SortedCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    final class SortedTreeCollection extends SortedByteCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Byte> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same bytes and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Byte> comparator, final Collection<Byte> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given bytes. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The bytes of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Byte> comparator, final Byte... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Byte>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The bytes of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Byte> comparator, final Byte... numbers) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Byte>(
                    elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given bytes and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted bytes collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Byte> comparator, final Collection<Byte> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Byte>(
                    elementCardinality, comparator, source.toArray(EmptyArrays.BYTES));
        }

        @Override
        SortedCollection<Byte> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty sorted bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted bytes collection.
     */
    static SortedByteCollection empty(final Comparator<? super Byte> comparator) {
        return new ArrayCollection(comparator);
    }

    /**
     * Returns a new sorted bytes collection with the specified bytes.
     *
     * @param numbers    The bytes for the new sorted bytes collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted bytes collection with the specified bytes.
     */
    static SortedByteCollection of(final Comparator<? super Byte> comparator, final Byte... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted bytes collection cloned from the provided bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original bytes collection.
     * @return A new sorted bytes collection cloned from the provided bytes collection.
     */
    static SortedByteCollection of(final Comparator<? super Byte> comparator,
            final NumericCollection<Byte> collection) {
        return new ArrayCollection(comparator, collection);
    }

    /**
     * Returns a new sorted bytes collection cloned from a range in the provided ordered bytes collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered bytes collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new sorted bytes collection cloned from a range in the provided ordered collection.
     */
    static SortedByteCollection of(final Comparator<? super Byte> comparator,
            final OrderedNumericCollection<Byte> collection, final int fromIndex, final int toIndex) {
        ModifiableByteCollection slice = ModifiableByteCollection.of(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            slice.add(collection.getAt(i));
        }
        return new ArrayCollection(comparator, slice);
    }

    /**
     * Returns a new sorted bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The bytes for the new sorted bytes collection.
     * @return A new sorted bytes collection with the specified element cardinality and the bytes.
     */
    static SortedByteCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Byte> comparator, final Byte... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted bytes collection with the specified element cardinality and the bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original bytes collection.
     * @return A new sorted bytes collection with the specified element cardinality and the bytes.
     */
    static SortedByteCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Byte> comparator, final NumericCollection<Byte> collection) {
        return new ArrayCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new sorted bytes collection cloned from the provided sorted bytes collection.
     *
     * @param collection The original sorted bytes collection.
     * @return A new sorted bytes collection cloned from the provided sorted bytes collection.
     */
    static SortedByteCollection of(final SortedNumericCollection<Byte> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted bytes collection cloned from the provided sorted bytes collection.
     *
     * @param collection The original sorted bytes collection.
     * @param range      The range.
     * @return A new sorted bytes collection cloned from the provided sorted bytes collection.
     */
    static SortedByteCollection of(final SortedNumericCollection<Byte> collection, final Range<Byte> range) {
        ModifiableByteCollection slice = ModifiableByteCollection.of(collection.getElementCardinality());
        boolean below = true;
        for (Byte element : collection) {
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
}
