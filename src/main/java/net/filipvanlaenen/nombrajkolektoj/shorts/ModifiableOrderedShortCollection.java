package net.filipvanlaenen.nombrajkolektoj.shorts;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableOrderedCollection;
import net.filipvanlaenen.kolektoj.OrderedCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableOrderedNumericCollection}
 * interface for shorts and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedShortCollection extends AbstractModifiableOrderedShortCollection
        implements ModifiableOrderedNumericCollection<Short> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedShortCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same shorts and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Short>(elementCardinality,
                    numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public ArrayCollection(final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.array.ModifiableOrderedArrayCollection<Short>(numbers));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedShortCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same shorts and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Short>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public LinkedListCollection(final Short... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Short>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the shorts.
     */
    private final ModifiableOrderedCollection<Short> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the shorts as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the shorts.
     */
    private ModifiableOrderedShortCollection(final ModifiableOrderedCollection<Short> numbers) {
        this.collection = numbers;
    }

    @Override
    public boolean add(final Short element) {
        return collection.add(element);
    }

    @Override
    public boolean addAll(final Collection<? extends Short> otherCollection) {
        return collection.addAll(otherCollection);
    }

    @Override
    public boolean addAllAt(final int index, final OrderedCollection<? extends Short> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Short element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
    }

    @Override
    public void clear() {
        collection.clear();
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
     * Returns a new empty modifiable shorts collection.
     *
     * @return A new empty modifiable shorts collection.
     */
    public static ModifiableOrderedShortCollection empty() {
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
     * Returns a new modifiable ordered shorts collection with the specified shorts.
     *
     * @param numbers The shorts for the new modifiable ordered shorts collection.
     * @return A new modifiable ordered shorts collection with the specified shorts.
     */
    public static ModifiableOrderedShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new modifiable ordered shorts collection.
     * @return A new modifiable ordered shorts collection with the specified element cardinality and the shorts.
     */
    public static ModifiableOrderedShortCollection of(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered shorts collection cloned from the provided ordered shorts collection.
     *
     * @param collection The original ordered shorts collection.
     * @return A new modifiable ordered shorts collection cloned from the provided ordered shorts collection.
     */
    public static ModifiableOrderedShortCollection of(final OrderedShortCollection collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered shorts collection cloned from a range in the provided ordered shorts
     * collection.
     *
     * @param collection The original ordered shorts collection.
     * @param fromIndex  The index of the first element to be included in the new ordered shorts collection.
     * @param toIndex    The index of the first element not to be included in the new ordered shorts collection.
     * @return A new modifiable ordered shorts collection cloned from a range in the provided ordered shorts
     *         collection.
     */
    public static ModifiableOrderedShortCollection of(final OrderedShortCollection collection, final int fromIndex,
            final int toIndex) {
        ModifiableOrderedShortCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public Short putAt(final int index, final Short element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
    }

    @Override
    public boolean remove(final Short element) {
        return collection.remove(element);
    }

    @Override
    public boolean removeAll(final Collection<? extends Short> otherCollection) {
        return collection.removeAll(otherCollection);
    }

    @Override
    public Short removeAt(final int index) throws IndexOutOfBoundsException {
        return collection.removeAt(index);
    }

    @Override
    public boolean removeIf(final Predicate<? super Short> predicate) {
        return collection.removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Collection<? extends Short> otherCollection) {
        return collection.retainAll(otherCollection);
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
