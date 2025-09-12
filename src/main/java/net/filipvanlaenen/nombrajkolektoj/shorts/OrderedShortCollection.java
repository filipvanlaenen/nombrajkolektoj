package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection} interface for
 * shorts and containing inner classes with concrete implementations.
 */
public abstract class OrderedShortCollection extends AbstractOrderedShortCollection
        implements OrderedNumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.OrderedCollection}
     * interface.
     */
    public static final class ArrayCollection extends OrderedShortCollection {
        /**
         * Constructs an ordered collection from another ordered collection, with the same shorts and the same element
         * cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs an ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the ordered collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Short>(elementCardinality, numbers));
        }

        /**
         * Constructs an ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the ordered collection.
         */
        public ArrayCollection(final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.OrderedArrayCollection<Short>(numbers));
        }
    }

    /**
     * The ordered collection holding the shorts.
     */
    private final OrderedCollection<Short> collection;

    /**
     * Private constructor taking an ordered collection with the shorts as its parameter.
     *
     * @param numbers The ordered collection holding the shorts.
     */
    private OrderedShortCollection(final OrderedCollection<Short> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean contains(final Short element) {
        return collection.contains(element);
    }

    @Override
    public boolean containsAll(final Collection<?> otherCollection) {
        return collection.containsAll(otherCollection);
    }

    /**
     * Returns a new empty ordered shorts collection.
     *
     * @return A new empty ordered shorts collection.
     */
    static OrderedShortCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public int firstIndexOf(final Short element) {
        return collection.firstIndexOf(element);
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public Short getAt(final int index) throws IndexOutOfBoundsException {
        return collection.getAt(index);
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public int indexOf(final Short element) {
        return collection.indexOf(element);
    }

    @Override
    public Iterator<Short> iterator() {
        return collection.iterator();
    }

    @Override
    public int lastIndexOf(final Short element) {
        return collection.lastIndexOf(element);
    }

    /**
     * Returns a new ordered shorts collection with the specified shorts.
     *
     * @param numbers The shorts for the new ordered shorts collection.
     * @return A new ordered shorts collection with the specified shorts.
     */
    static OrderedShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new ordered shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new ordered shorts collection.
     * @return A new ordered shorts collection with the specified element cardinality and the shorts.
     */
    static OrderedShortCollection of(final ElementCardinality elementCardinality, final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    @Override
    public int size() {
        return collection.size();
    }

    @Override
    public Spliterator<Short> spliterator() {
        return collection.spliterator();
    }

    @Override
    public Short[] toArray() {
        return collection.toArray(EmptyArrays.SHORTS);
    }
}
