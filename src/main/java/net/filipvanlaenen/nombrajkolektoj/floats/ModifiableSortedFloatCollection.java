package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableSortedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericCollection}
 * interface for floats and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedFloatCollection extends AbstractModifiableSortedFloatCollection
        implements ModifiableSortedNumericCollection<Float> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedFloatCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same floats and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Float> comparator, final Collection<Float> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a modifiable sorted collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The floats of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Float> comparator,
                final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Float>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The floats of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Float> comparator, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Float>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the floats.
     */
    private final ModifiableSortedCollection<Float> collection;

    /**
     * Private constructor taking a sorted collection with the floats as its parameter.
     *
     * @param collection The sorted collection holding the floats.
     */
    private ModifiableSortedFloatCollection(final ModifiableSortedCollection<Float> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(final Float element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Float> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Float element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable sorted floats collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted floats collection.
     */
    static ModifiableSortedFloatCollection empty(final Comparator<Float> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Float element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Float getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Float> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Float getGreaterThan(final Float element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Float getGreaterThanOrEqualTo(final Float element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Float getLessThan(final Float element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Float getLessThanOrEqualTo(final Float element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Float element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Float> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Float element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted floats collection with the specified floats.
     *
     * @param numbers    The floats for the new modifiable sorted floats collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted floats collection with the specified floats.
     */
    static ModifiableSortedFloatCollection of(final Comparator<Float> comparator, final Float... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The floats for the new modifiable sorted floats collection.
     * @return A new modifiable sorted floats collection with the specified element cardinality and the floats.
     */
    static ModifiableSortedFloatCollection of(final ElementCardinality elementCardinality,
            final Comparator<Float> comparator, final Float... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public boolean remove(final Float element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Float> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Float removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Float> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Float> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Float> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Float[] toArray() {
        return collection.toArray(EmptyArrays.FLOATS);
    }
}
