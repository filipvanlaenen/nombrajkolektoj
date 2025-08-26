package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.ModifiableCollection;
import net.filipvanlaenen.kolektoj.array.ModifiableArrayCollection;
import net.filipvanlaenen.kolektoj.linkedlist.ModifiableLinkedListCollection;
import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} interface
 * for floats and containing inner classes with concrete implementations.
 */
public abstract class ModifiableFloatCollection extends AbstractModifiableFloatCollection
        implements ModifiableNumericCollection<Float> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableFloatCollection {
        /**
         * Constructs a collection from another collection, with the same floats and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new ModifiableArrayCollection<Float>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public ArrayCollection(final Float... numbers) {
            super(new ModifiableArrayCollection<Float>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableFloatCollection {
        /**
         * Constructs a collection from another collection, with the same floats and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Float> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
        }

        /**
         * Constructs a collection with the given floats and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The floats of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Float... numbers) {
            super(new ModifiableLinkedListCollection<Float>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given floats. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The floats of the collection.
         */
        public LinkedListCollection(final Float... numbers) {
            super(new ModifiableLinkedListCollection<Float>(numbers));
        }
    }

    /**
     * The modifiable collection holding the floats.
     */
    private final ModifiableCollection<Float> collection;

    /**
     * Private constructor taking a collection with the floats as its parameter.
     *
     * @param numbers The collection holding the floats.
     */
    private ModifiableFloatCollection(final ModifiableCollection<Float> numbers) {
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
     * Returns a new empty modifiable float collection.
     *
     * @return A new empty modifiable float collection.
     */
    static ModifiableFloatCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Float get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Float> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new modifiable floats collection with the specified floats.
     *
     * @param numbers The floats for the new modifiable floats collection.
     * @return A new modifiable floats collection with the specified floats.
     */
    static ModifiableFloatCollection of(final Float... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable floats collection with the specified element cardinality and the floats.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The floats for the new modifiable floats collection.
     * @return A new modifiable floats collection with the specified element cardinality and the floats.
     */
    static ModifiableFloatCollection of(final ElementCardinality elementCardinality, final Float... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
