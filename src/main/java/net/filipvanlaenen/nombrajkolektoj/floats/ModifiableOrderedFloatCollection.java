package net.filipvanlaenen.nombrajkolektoj.floats;

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
 * interface for floats and containing inner classes with concrete implementations.
 */
public abstract class ModifiableOrderedFloatCollection extends AbstractModifiableOrderedFloatCollection
        implements ModifiableOrderedNumericCollection<Float> {
    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by an array.
     */
    public static final class ArrayCollection extends ModifiableOrderedFloatCollection {
        /**
         * Constructs a modifiable ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public ArrayCollection(final Float... numbers) {
            super(new ModifiableOrderedArrayCollection<Float>(numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new ModifiableOrderedArrayCollection<Float>(elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param source             The ordered collection to create a new collection from.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final OrderedCollection<Float> source) {
            super(new ModifiableOrderedArrayCollection<Float>(elementCardinality, source));
        }

        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same floats and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public ArrayCollection(final OrderedCollection<Float> source) {
            super(new ModifiableOrderedArrayCollection<Float>(source));
        }
    }

    /**
     * Inner class using an implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableOrderedCollection}
     * interface backed by a linked list.
     */
    public static final class LinkedListCollection extends ModifiableOrderedFloatCollection {
        /**
         * Constructs a modifiable ordered collection from another ordered collection, with the same floats and the
         * same element cardinality.
         *
         * @param source The ordered collection to create a new collection from.
         */
        public LinkedListCollection(final OrderedCollection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a modifiable ordered collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Float>(
                    elementCardinality, numbers));
        }

        /**
         * Constructs a modifiable ordered collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public LinkedListCollection(final Float... numbers) {
            super(new net.filipvanlaenen.kolektoj.linkedlist.ModifiableOrderedLinkedListCollection<Float>(numbers));
        }
    }

    /**
     * The modifiable ordered collection holding the floats.
     */
    private final ModifiableOrderedCollection<Float> collection;

    /**
     * Private constructor taking a modifiable ordered collection with the floats as its parameter.
     *
     * @param numbers The modifiable ordered collection holding the floats.
     */
    private ModifiableOrderedFloatCollection(final ModifiableOrderedCollection<Float> numbers) {
        this.collection = numbers;
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
    public boolean addAllAt(final int index, final OrderedCollection<? extends Float> otherCollection)
            throws IndexOutOfBoundsException {
        return collection.addAllAt(index, otherCollection);
    }

    @Override
    public boolean addAt(final int index, final Float element) throws IndexOutOfBoundsException {
        return collection.addAt(index, element);
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
     * Returns a new empty modifiable floats collection.
     *
     * @return A new empty modifiable floats collection.
     */
    public static ModifiableOrderedFloatCollection empty() {
        return new ArrayCollection();
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
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
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
     * Returns a new modifiable ordered floats collection with the specified floats.
     *
     * @param numbers The floats for the new modifiable ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified floats.
     */
    public static ModifiableOrderedFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new modifiable ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified element cardinality and the floats.
     */
    public static ModifiableOrderedFloatCollection of(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
    }

    /**
     * Returns a new modifiable ordered floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param collection         The original ordered floats collection.
     * @return A new modifiable ordered floats collection with the specified element cardinality and the floats.
     */
    public static ModifiableOrderedFloatCollection of(final ElementCardinality elementCardinality,
            final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(elementCardinality, collection);
    }

    /**
     * Returns a new modifiable ordered floats collection cloned from the provided ordered floats collection.
     *
     * @param collection The original ordered floats collection.
     * @return A new modifiable ordered floats collection cloned from the provided ordered floats collection.
     */
    public static ModifiableOrderedFloatCollection of(final OrderedNumericCollection<Float> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable ordered floats collection cloned from a range in the provided ordered floats
     * collection.
     *
     * @param collection The original ordered floats collection.
     * @param fromIndex  The index of the first element to be included in the new ordered floats collection.
     * @param toIndex    The index of the first element not to be included in the new ordered floats collection.
     * @return A new modifiable ordered floats collection cloned from a range in the provided ordered floats
     *         collection.
     */
    public static ModifiableOrderedFloatCollection of(final OrderedNumericCollection<Float> collection,
            final int fromIndex, final int toIndex) {
        ModifiableOrderedFloatCollection result = new ArrayCollection(collection.getElementCardinality());
        for (int i = fromIndex; i < toIndex; i++) {
            result.addLast(collection.getAt(i));
        }
        return result;
    }

    @Override
    public Float putAt(final int index, final Float element)
            throws IllegalArgumentException, IndexOutOfBoundsException {
        return collection.putAt(index, element);
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
