package net.filipvanlaenen.nombrajkolektoj.shorts;

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
 * interface for shorts and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedShortCollection
        extends ModifiableSortedNumericCollection<Short>, SortedShortCollection, ModifiableShortCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    final class SortedTreeCollection extends ModifiableSortedShortCollectionDecorator {
        /**
         * The internal decorated collection.
         */
        private ModifiableSortedTreeCollection<Short> decoratedCollection;

        @Override
        ModifiableSortedCollection<Short> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same shorts and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(source.getElementCardinality(), comparator, source);
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
            decoratedCollection = new ModifiableSortedTreeCollection<Short>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same shorts and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Short> comparator, final Collection<Short> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a modifiable sorted collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The shorts of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Short> comparator, final Short... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Short>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted shorts collection.
     */
    static ModifiableSortedShortCollection empty(final Comparator<Short> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted shorts collection with the specified shorts.
     *
     * @param numbers    The shorts for the new modifiable sorted shorts collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted shorts collection with the specified shorts.
     */
    static ModifiableSortedShortCollection of(final Comparator<? super Short> comparator, final Short... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from the provided shorts collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original shorts collection.
     * @return A new sorted modifiable shorts collection cloned from the provided shorts collection.
     */
    static ModifiableSortedShortCollection of(final Comparator<? super Short> comparator,
            final NumericCollection<Short> collection) {
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
    static ModifiableSortedShortCollection of(final Comparator<? super Short> comparator,
            final OrderedNumericCollection<Short> collection, final int fromIndex, final int toIndex) {
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
    static ModifiableSortedShortCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Short> comparator, final Short... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted shorts collection with the specified element cardinality cloned from the
     * provided shorts collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original shorts collection.
     * @return A new modifiable sorted shorts collection with the specified element cardinality cloned from the
     *         provided shorts collection.
     */
    static ModifiableSortedShortCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Short> comparator, final NumericCollection<Short> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @return A new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     */
    static ModifiableSortedShortCollection of(final SortedNumericCollection<Short> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     *
     * @param collection The original sorted shorts collection.
     * @param range      The range.
     * @return A new modifiable sorted shorts collection cloned from the provided sorted shorts collection.
     */
    static ModifiableSortedShortCollection of(final SortedNumericCollection<Short> collection,
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
}
