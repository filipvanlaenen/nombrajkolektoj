package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for BigIntegers and containing inner classes with concrete implementations.
 */
public abstract class ModifiableBigIntegerCollection extends AbstractModifiableBigIntegerCollection
        implements ModifiableNumericCollection<BigInteger> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableBigIntegerCollection {
        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new ModifiableArrayCollection<BigInteger>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public ArrayCollection(final BigInteger... numbers) {
            super(new ModifiableArrayCollection<BigInteger>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableBigIntegerCollection {
        /**
         * Constructs a collection from another collection, with the same BigIntegers and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<BigInteger> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
        }

        /**
         * Constructs a collection with the given BigIntegers and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The BigIntegers of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final BigInteger... numbers) {
            super(new ModifiableLinkedListCollection<BigInteger>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given BigIntegers. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The BigIntegers of the collection.
         */
        public LinkedListCollection(final BigInteger... numbers) {
            super(new ModifiableLinkedListCollection<BigInteger>(numbers));
        }
    }

    /**
     * The modifiable collection holding the BigIntegers.
     */
    private final ModifiableCollection<BigInteger> collection;

    /**
     * Private constructor taking a collection with the BigIntegers as its parameter.
     *
     * @param numbers The collection holding the BigIntegers.
     */
    private ModifiableBigIntegerCollection(final ModifiableCollection<BigInteger> numbers) {
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
    public static ModifiableBigIntegerCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public BigInteger get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<BigInteger> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new BigIntegers modifiable collection cloned from the provided BigIntegers collection.
     *
     * @param collection The original BigIntegers collection.
     * @return A new modifiable BigIntegers collection cloned from the provided BigIntegers collection.
     */
    public static ModifiableBigIntegerCollection of(final NumericCollection<BigInteger> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable BigIntegers collection with the specified BigIntegers.
     *
     * @param numbers The BigIntegers for the new modifiable BigIntegers collection.
     * @return A new modifiable BigIntegers collection with the specified BigIntegers.
     */
    public static ModifiableBigIntegerCollection of(final BigInteger... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable BigIntegers collection with the specified element cardinality and the BigIntegers.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The BigIntegers for the new modifiable BigIntegers collection.
     * @return A new modifiable BigIntegers collection with the specified element cardinality and the BigIntegers.
     */
    public static ModifiableBigIntegerCollection of(final ElementCardinality elementCardinality, final BigInteger... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
