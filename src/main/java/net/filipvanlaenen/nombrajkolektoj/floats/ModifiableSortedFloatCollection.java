package net.filipvanlaenen.nombrajkolektoj.floats;

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
 * interface for floats and containing inner classes with concrete implementations.
 */
public interface ModifiableSortedFloatCollection
        extends ModifiableSortedNumericCollection<Float>, SortedFloatCollection, ModifiableFloatCollection {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedFloatCollectionDecorator {
        private ModifiableSortedTreeCollection<Float> decoratedCollection;

        @Override
        ModifiableSortedCollection<Float> getDecoratedCollection() {
            return decoratedCollection;
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same floats and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<? super Float> comparator, final Collection<Float> source) {
            this(source.getElementCardinality(), comparator, source);
        }

        /**
         * Constructs a modifiable sorted collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The floats of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Float> comparator, final Float... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Float>(elementCardinality, comparator, numbers);
        }

        /**
         * Constructs a modifiable sorted collection from a collection, with the same floats and the provided element
         * cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param source             The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality,
                final Comparator<? super Float> comparator, final Collection<Float> source) {
            this(elementCardinality, comparator, source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a modifiable sorted collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The floats of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<? super Float> comparator, final Float... numbers) {
            decoratedCollection = new ModifiableSortedTreeCollection<Float>(comparator, numbers);
        }
    }

    /**
     * Returns a new empty modifiable sorted floats collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted floats collection.
     */
    public static ModifiableSortedFloatCollection empty(final Comparator<Float> comparator) {
        return new SortedTreeCollection(comparator);
    }

    /**
     * Returns a new modifiable sorted floats collection with the specified floats.
     *
     * @param numbers    The floats for the new modifiable sorted floats collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted floats collection with the specified floats.
     */
    public static ModifiableSortedFloatCollection of(final Comparator<? super Float> comparator,
            final Float... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted floats collection cloned from the provided floats collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original floats collection.
     * @return A new sorted modifiable floats collection cloned from the provided floats collection.
     */
    public static ModifiableSortedFloatCollection of(final Comparator<? super Float> comparator,
            final NumericCollection<Float> collection) {
        return new SortedTreeCollection(comparator, collection);
    }

    /**
     * Returns a new modifiable sorted floats collection cloned from a range in the provided ordered floats
     * collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @param collection The original ordered floats collection.
     * @param fromIndex  The index of the first element to be included in the new sorted collection.
     * @param toIndex    The index of the first element not to be included in the new sorted collection.
     * @return A new modifiable sorted floats collection cloned from a range in the provided ordered floats
     *         collection.
     */
    public static ModifiableSortedFloatCollection of(final Comparator<? super Float> comparator,
            final OrderedNumericCollection<Float> collection, final int fromIndex, final int toIndex) {
        ModifiableSortedFloatCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), comparator);
        for (int i = fromIndex; i < toIndex; i++) {
            result.add(collection.getAt(i));
        }
        return result;
    }

    /**
     * Returns a new modifiable sorted floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The floats for the new modifiable sorted floats collection.
     * @return A new modifiable sorted floats collection with the specified element cardinality and the floats.
     */
    public static ModifiableSortedFloatCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Float> comparator, final Float... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted floats collection with the specified element cardinality cloned from the
     * provided floats collection.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param collection         The original floats collection.
     * @return A new modifiable sorted floats collection with the specified element cardinality cloned from the
     *         provided floats collection.
     */
    public static ModifiableSortedFloatCollection of(final ElementCardinality elementCardinality,
            final Comparator<? super Float> comparator, final NumericCollection<Float> collection) {
        return new SortedTreeCollection(elementCardinality, comparator, collection);
    }

    /**
     * Returns a new modifiable sorted floats collection cloned from the provided sorted floats collection.
     *
     * @param collection The original sorted floats collection.
     * @return A new modifiable sorted floats collection cloned from the provided sorted floats collection.
     */
    public static ModifiableSortedFloatCollection of(final SortedNumericCollection<Float> collection) {
        return new SortedTreeCollection(collection.getComparator(), collection);
    }

    /**
     * Returns a new modifiable sorted floats collection cloned from the provided sorted floats collection.
     *
     * @param collection The original sorted floats collection.
     * @param range      The range.
     * @return A new modifiable sorted floats collection cloned from the provided sorted floats collection.
     */
    public static ModifiableSortedFloatCollection of(final SortedNumericCollection<Float> collection,
            final Range<Float> range) {
        ModifiableSortedFloatCollection result =
                new SortedTreeCollection(collection.getElementCardinality(), collection.getComparator());
        boolean below = true;
        for (Float element : collection) {
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
