package net.filipvanlaenen.nombrajkolektoj.shorts;

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
 * shorts and containing inner classes with concrete implementations.
 */
public interface SortedShortCollection extends SortedNumericCollection<Short>, OrderedShortCollection {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection}
     * interface.
     */
    final class ArrayCollection extends SortedShortCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private SortedArrayCollection<Short> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same shorts and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public ArrayCollection(final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public ArrayCollection(final Comparator<? super Short> comparator, final Short... numbers) {
            decoratedCollection = new SortedArrayCollection<Short>(comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The shorts collection to create a new sorted shorts collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Comparator<? super Short> comparator,
                final Collection<Short> source) {
            decoratedCollection = new SortedArrayCollection<Short>(elementCardinality, comparator,
                    source.toArray(EmptyArrays.SHORTS));
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
            decoratedCollection = new SortedArrayCollection<Short>(elementCardinality, comparator, numbers);
        }

        @Override
        SortedCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.SortedCollection} interface backed
     * by a sorted tree.
     */
    final class SortedTreeCollection extends SortedShortCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short> decoratedCollection;

        /**
         * Constructs a sorted collection from a collection, with the same shorts and the same element cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Short... numbers) {
            decoratedCollection =
                    new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(comparator, numbers);
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
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(
                    elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a sorted collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted shorts collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Short> comparator, final Collection<Short> source) {
            decoratedCollection = new net.filipvanlaenen.kolektoj.sortedtree.SortedTreeCollection<Short>(
                    elementCardinality, comparator, source.toArray(EmptyArrays.SHORTS));
        }

        @Override
        SortedCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }
    }

    /**
     * Returns a new empty sorted shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted shorts collection.
     */
    static SortedShortCollection empty(final Comparator<? super Short> comparator) {
        return new ArrayCollection(comparator);
    }

    /**
     * Returns a new sorted shorts collection with the specified shorts.
     *
     * @param numbers    The shorts for the new sorted shorts collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new sorted shorts collection with the specified shorts.
     */
    static SortedShortCollection of(final Comparator<? super Short> comparator, final Short... numbers) {
        return new ArrayCollection(comparator, numbers);
    }

    /**
     * Returns a new sorted shorts collection cloned from the provided shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original shorts collection.
     * @return A new sorted shorts collection cloned from the provided shorts collection.
     */
    static SortedShortCollection of(final Comparator<? super Short> comparator,
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
    static SortedShortCollection of(final Comparator<? super Short> comparator,
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
    static SortedShortCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Short> comparator, final Short... numbers) {
        return new ArrayCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new sorted shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original shorts collection.
     * @return A new sorted shorts collection with the specified element cardinality and the shorts.
     */
    static SortedShortCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Short> comparator, final NumericCollection<Short> collection) {
        return new ArrayCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @return A new sorted shorts collection cloned from the provided sorted shorts collection.
     */
    static SortedShortCollection of(final SortedNumericCollection<Short> collection) {
        return new ArrayCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @param range      The range.
     * @return A new sorted shorts collection cloned from the provided sorted shorts collection.
     */
    static SortedShortCollection of(final SortedNumericCollection<Short> collection, final Range<Short> range) {
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
}
