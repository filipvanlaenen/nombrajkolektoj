package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ByteCollectionTestBase<T extends NumericCollection<Byte>> {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final NumericCollection<Byte> collection123 = createByteCollection((byte) 1, (byte) 2, (byte) 3);

    /**
     * Creates an empty bytes collection.
     *
     * @return An empty bytes collection.
     */
    protected abstract T createEmptyByteCollection();

    /**
     * Creates a bytes collection from a collection of bytes.
     *
     * @param source The collection of bytes.
     * @return A bytes collection containing the provided bytes.
     */
    protected abstract T createByteCollection(Collection<Byte> source);

    /**
     * Creates a bytes collection with the provided element cardinality containing the provided bytes.
     *
     * @param elementCardinality The element cardinality.
     * @param numbers            The bytes to be included in the bytes collection.
     * @return A bytes collection with the provided element cardinality containing the provided bytes.
     */
    protected abstract T createByteCollection(ElementCardinality elementCardinality, Byte... numbers);

    /**
     * Creates a bytes collection containing the provided bytes.
     *
     * @param numbers The bytes to be included in the bytes collection.
     * @return An bytes collection containing the provided bytes.
     */
    protected abstract T createByteCollection(Byte... numbers);

    /**
     * Verifies that an empty bytes collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyByteCollection() {
        assertTrue(createEmptyByteCollection().isEmpty());
    }

    /**
     * Verifies that a bytes collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnAByteCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, createByteCollection(DISTINCT_ELEMENTS, (byte) 1).getElementCardinality());
    }

    /**
     * Verifies that a bytes collection created from another collection has the same element cardinality and bytes.
     */
    @Test
    public void ofWithCollectionShouldReturnAByteCollectionWithTheSameElementCardinalityAndBytes() {
        Collection<Byte> source = Collection.of(DISTINCT_ELEMENTS, (byte) 1);
        T actual = createByteCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains((byte) 1));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains((byte) 1));
        assertFalse(collection123.contains((byte) 0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.containsAll(createByteCollection((byte) 1)));
        assertFalse(collection123.containsAll(createByteCollection((byte) 0)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(collection123.contains(collection123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, collection123.toArray().length);
    }
}
