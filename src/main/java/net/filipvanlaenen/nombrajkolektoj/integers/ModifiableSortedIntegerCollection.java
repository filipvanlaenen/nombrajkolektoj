package net.filipvanlaenen.nombrajkolektoj.integers;

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
 * interface for integers and containing inner classes with concrete implementations.
 */
public abstract class ModifiableSortedIntegerCollection extends AbstractModifiableSortedIntegerCollection
        implements ModifiableSortedNumericCollection<Integer> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableSortedCollection}
     * interface backed by a sorted tree.
     */
    public static final class SortedTreeCollection extends ModifiableSortedIntegerCollection {
        /**
         * Constructs a modifiable sorted collection from a collection, with the same integers and the same element
         * cardinality.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param source     The sorted collection to create a new collection from.
         */
        public SortedTreeCollection(final Comparator<Integer> comparator, final Collection<Integer> source) {
            this(source.getElementCardinality(), comparator, source.toArray(EmptyArrays.INTEGERS));
        }

        /**
         * Constructs a modifiable sorted collection with the given integers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param comparator         The comparator by which to sort the elements.
         * @param numbers            The integers of the sorted collection.
         */
        public SortedTreeCollection(final ElementCardinality elementCardinality, final Comparator<Integer> comparator,
                final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Integer>(elementCardinality,
                    comparator, numbers));
        }

        /**
         * Constructs a modifiable sorted collection with the given integers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param comparator The comparator by which to sort the elements.
         * @param numbers    The integers of the sorted collection.
         */
        public SortedTreeCollection(final Comparator<Integer> comparator, final Integer... numbers) {
            super(new net.filipvanlaenen.kolektoj.sortedtree.ModifiableSortedTreeCollection<Integer>(comparator,
                    numbers));
        }
    }

    /**
     * The modifiable sorted collection holding the integers.
     */
    private final ModifiableSortedCollection<Integer> collection;

    /**
     * Private constructor taking a sorted collection with the integers as its parameter.
     *
     * @param collection The sorted collection holding the integers.
     */
    private ModifiableSortedIntegerCollection(final ModifiableSortedCollection<Integer> collection) {
        this.collection = collection;
    }

    @Override
    public boolean add(final Integer element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Integer> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final Integer element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable sorted integers collection.
     *
     * @param comparator The comparator by which to sort the elements.
     * @return A new empty sorted integers collection.
     */
    static ModifiableSortedIntegerCollection empty(final Comparator<Integer> comparator) {
        return new SortedTreeCollection(comparator);
    }

    @Override
    public int firstIndexOf(final Integer element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Integer get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Integer getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public Comparator<? super Integer> getComparator() {
        return collection.getComparator();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Integer getGreaterThan(final Integer element) throws IndexOutOfBoundsException {
        return collection.getGreaterThan(element);
    }

    @Override
    public Integer getGreaterThanOrEqualTo(final Integer element) throws IndexOutOfBoundsException {
        return collection.getGreaterThanOrEqualTo(element);
    }

    @Override
    public Integer getLessThan(final Integer element) throws IndexOutOfBoundsException {
        return collection.getLessThan(element);
    }

    @Override
    public Integer getLessThanOrEqualTo(final Integer element) throws IndexOutOfBoundsException {
        return collection.getLessThanOrEqualTo(element);
    }

    @Override
    public int indexOf(final Integer element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Integer> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Integer element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable sorted integers collection with the specified integers.
     *
     * @param numbers    The integers for the new modifiable sorted integers collection.
     * @param comparator The comparator by which to sort the elements.
     * @return A new modifiable sorted integers collection with the specified integers.
     */
    static ModifiableSortedIntegerCollection of(final Comparator<Integer> comparator, final Integer... numbers) {
        return new SortedTreeCollection(comparator, numbers);
    }

    /**
     * Returns a new modifiable sorted integers collection with the specified element cardinality and the integers.
     *
     * @param elementCardinality The element cardinality.
     * @param comparator         The comparator by which to sort the elements.
     * @param numbers            The integers for the new modifiable sorted integers collection.
     * @return A new modifiable sorted integers collection with the specified element cardinality and the integers.
     */
    static ModifiableSortedIntegerCollection of(final ElementCardinality elementCardinality,
            final Comparator<Integer> comparator, final Integer... numbers) {
        return new SortedTreeCollection(elementCardinality, comparator, numbers);
    }

    @Override
    public boolean remove(final Integer element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Integer> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Integer removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Integer> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Integer> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Integer[] toArray() {
        return collection.toArray(EmptyArrays.INTEGERS);
    }
}
