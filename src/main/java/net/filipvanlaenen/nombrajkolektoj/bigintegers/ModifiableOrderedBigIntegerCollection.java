package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedBigIntegerCollection extends AbstractModifiableOrderedBigIntegerCollection
        implements ModifiableOrderedNumericCollection<BigInteger> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedBigIntegerCollection {
        /**
         * Constructs a modifiable ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            super(new ModifiableOrderedArrayCollection<BigInteger>(numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new ModifiableOrderedArrayCollection<BigInteger>(elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<BigInteger> source) {
            super(new ModifiableOrderedArrayCollection<BigInteger>(elementCardinality, source));
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigIntegers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<BigInteger> source) {
            super(new ModifiableOrderedArrayCollection<BigInteger>(source));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedBigIntegerCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same BigIntegers and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<BigInteger>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public LinkedListCollection(final BigInteger... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<BigInteger>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the BigIntegers.
     */
    private final ModifiableOrderedCollection<BigInteger> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the BigIntegers as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the BigIntegers.
     */
    private ModifiableOrderedBigIntegerCollection(final ModifiableOrderedCollection<BigInteger> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final BigInteger element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends BigInteger> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends BigInteger> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final BigInteger element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
    }

    @Override
    public void clear() {
        collection.clear();
    }

    @Override
    public boolean contains(final BigInteger element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty modifiable BigIntegers collection.
     *
     * @return A new empty modifiable BigIntegers collection.
     */
    public static ModifiableOrderedBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final BigInteger element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public BigInteger getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final BigInteger element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final BigInteger element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new modifiable ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified BigIntegers.
     */
    public static ModifiableOrderedBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new modifiable ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableOrderedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableOrderedBigIntegerCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<BigInteger> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection cloned from the provided ordered BigIntegers collection.
     */
    public static ModifiableOrderedBigIntegerCollection of(final OrderedNumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered BigIntegers collection cloned from a range in the provided ordered BigIntegers
     * collection.
     *
     * @param collection The original ordered BigIntegers collection.
     * @param fromIndex  The index of the first element to be included in the new ordered BigIntegers collection.
     * @param toIndex    The index of the first element not to be included in the new ordered BigIntegers collection.
     * @return A new modifiable ordered BigIntegers collection cloned from a range in the provided ordered BigIntegers
     *         collection.
     */
    public static ModifiableOrderedBigIntegerCollection of(final OrderedNumericCollection<BigInteger> collection,
            final int fromIndex, final int toIndex) {
        ModifiableOrderedBigIntegerCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public BigInteger putAt(final int index, final BigInteger element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
    }

    @Override
    public boolean remove(final BigInteger element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends BigInteger> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public BigInteger removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super BigInteger> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends BigInteger> otherCollection) {
        return collection.retainAll(otherCollection);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<BigInteger> spliterator() {
        return collection.spliterator();
    }

    @Override
    public BigInteger[] toArray() {
        return collection.toArray(EmptyArrays.BIG_INTEGERS);
    }
}
