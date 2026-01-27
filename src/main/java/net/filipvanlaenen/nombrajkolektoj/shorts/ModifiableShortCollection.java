package net.filipvanlaenen.nombrajkolektoj.shorts;

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
 * for shorts and containing inner classes with concrete implementations.
 */
public abstract class ModifiableShortCollection extends AbstractModifiableShortCollection
        implements ModifiableNumericCollection<Short> {
    /**
     * Inner class using an array backed implementation of the {@link net.filipvanlaenen.kolektoj.ModifiableCollection}
     * interface.
     */
    public static final class ArrayCollection extends ModifiableShortCollection {
        /**
         * Constructs a collection from another collection, with the same shorts and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public ArrayCollection(final Collection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public ArrayCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new ModifiableArrayCollection<Short>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public ArrayCollection(final Short... numbers) {
            super(new ModifiableArrayCollection<Short>(numbers));
        }
    }

    /**
     * Inner class using a linked list backed implementation of the
     * {@link net.filipvanlaenen.kolektoj.ModifiableCollection} interface.
     */
    public static final class LinkedListCollection extends ModifiableShortCollection {
        /**
         * Constructs a collection from another collection, with the same shorts and the same element cardinality.
         *
         * @param source The collection to create a new collection from.
         */
        public LinkedListCollection(final Collection<Short> source) {
            this(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS));
        }

        /**
         * Constructs a collection with the given shorts and element cardinality.
         *
         * @param elementCardinality The element cardinality.
         * @param numbers            The shorts of the collection.
         */
        public LinkedListCollection(final ElementCardinality elementCardinality, final Short... numbers) {
            super(new ModifiableLinkedListCollection<Short>(elementCardinality, numbers));
        }

        /**
         * Constructs a collection with the given shorts. The element cardinality is defaulted to
         * <code>DUPLICATE_ELEMENTS</code>.
         *
         * @param numbers The shorts of the collection.
         */
        public LinkedListCollection(final Short... numbers) {
            super(new ModifiableLinkedListCollection<Short>(numbers));
        }
    }

    /**
     * The modifiable collection holding the shorts.
     */
    private final ModifiableCollection<Short> collection;

    /**
     * Private constructor taking a collection with the shorts as its parameter.
     *
     * @param numbers The collection holding the shorts.
     */
    private ModifiableShortCollection(final ModifiableCollection<Short> numbers) {
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
    public static ModifiableShortCollection empty() {
        return new ArrayCollection();
    }

    @Override
    public Short get() throws IndexOutOfBoundsException {
        return collection.get();
    }

    @Override
    public ElementCardinality getElementCardinality() {
        return collection.getElementCardinality();
    }

    @Override
    public Iterator<Short> iterator() {
        return collection.iterator();
    }

    /**
     * Returns a new shorts modifiable collection cloned from the provided shorts collection.
     *
     * @param collection The original shorts collection.
     * @return A new modifiable shorts collection cloned from the provided shorts collection.
     */
    public static ModifiableShortCollection of(final NumericCollection<Short> collection) {
        return new ArrayCollection(collection);
    }

    /**
     * Returns a new modifiable shorts collection with the specified shorts.
     *
     * @param numbers The shorts for the new modifiable shorts collection.
     * @return A new modifiable shorts collection with the specified shorts.
     */
    public static ModifiableShortCollection of(final Short... numbers) {
        return new ArrayCollection(numbers);
    }

    /**
     * Returns a new modifiable shorts collection with the specified element cardinality and the shorts.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The shorts for the new modifiable shorts collection.
     * @return A new modifiable shorts collection with the specified element cardinality and the shorts.
     */
    public static ModifiableShortCollection of(final ElementCardinality elementCardinality, final Short... numbers) {
        return new ArrayCollection(elementCardinality, numbers);
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
