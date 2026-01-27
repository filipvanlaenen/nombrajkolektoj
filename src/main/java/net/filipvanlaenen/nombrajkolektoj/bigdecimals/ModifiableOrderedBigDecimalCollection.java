package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for BigDecimals and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedBigDecimalCollection extends AbstractModifiableOrderedBigDecimalCollection
        implements ModifiableOrderedNumericCollection<BigDecimal> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedBigDecimalCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigDecimals and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<BigDecimal>(elementCardinality,
                    numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public ArrayCollection(final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<BigDecimal>(numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedBigDecimalCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigDecimals and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<BigDecimal> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigDecimals of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<BigDecimal>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigDecimals. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigDecimals of the collection.
         */
        public LinkedListCollection(final BigDecimal... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<BigDecimal>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the BigDecimals.
     */
    private final ModifiableOrderedCollection<BigDecimal> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the BigDecimals as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the BigDecimals.
     */
    private ModifiableOrderedBigDecimalCollection(final ModifiableOrderedCollection<BigDecimal> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final BigDecimal element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends BigDecimal> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends BigDecimal> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final BigDecimal element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final BigDecimal element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable BigDecimals collection.
     *
     * @return A new empty modifiable BigDecimals collection.
     */
    public static ModifiableOrderedBigDecimalCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final BigDecimal element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigDecimal get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigDecimal getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final BigDecimal element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigDecimal> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigDecimal element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection with the specified BigDecimals.
     *
     * @param numbers The BigDecimals for the new modifiable ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection with the specified BigDecimals.
     */
    public static ModifiableOrderedBigDecimalCollection of(final BigDecimal... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigDecimals for the new modifiable ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection with the specified element cardinality and the BigDecimals.
     */
    public static ModifiableOrderedBigDecimalCollection of(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection cloned from the provided ordered BigDecimals collection.
     */
    public static ModifiableOrderedBigDecimalCollection of(final OrderedNumericCollection<BigDecimal> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered BigDecimals collection cloned from a range in the provided ordered BigDecimals
     * collection.
     *
     * @param collection The original ordered BigDecimals collection.
     * @param fromIndex  The index of the first element to be included in the new ordered BigDecimals collection.
     * @param toIndex    The index of the first element not to be included in the new ordered BigDecimals collection.
     * @return A new modifiable ordered BigDecimals collection cloned from a range in the provided ordered BigDecimals
     *         collection.
     */
    public static ModifiableOrderedBigDecimalCollection of(final OrderedBigDecimalCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedBigDecimalCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public BigDecimal putAt(final int index, final BigDecimal element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
    }

    @Override
    public boolean remove(final BigDecimal element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends BigDecimal> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public BigDecimal removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super BigDecimal> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends BigDecimal> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigDecimal> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigDecimal[] toArray() {
        return collection.toArray(EmptyArrays.BIG_DECIMALS);
    }
}
