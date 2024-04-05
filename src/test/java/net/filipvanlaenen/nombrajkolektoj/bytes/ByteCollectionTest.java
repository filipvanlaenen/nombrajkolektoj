package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteCollection} class.
 */
public class ByteCollectionTest {
    /**
     * The magic number three.
     */
    private static final int THREE = 3;
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private static final ByteCollection COLLECTION123 = ByteCollection.of((byte) 1, (byte) 2, (byte) 3);

    /**
     * Verifies that an empty bytes collection is empty.
     */
    @Test
    public void isEmptyShouldReturnTrueForAnEmptyByteCollection() {
        assertTrue(ByteCollection.empty().isEmpty());
    }

    /**
     * Verifies that a bytes collection with a specific element cardinality receives that element cardinality.
     */
    @Test
    public void ofWithElementCardinalityShouldReturnABytesCollectionWithTheElementCardinality() {
        assertEquals(DISTINCT_ELEMENTS, ByteCollection.of(DISTINCT_ELEMENTS, (byte) 1).getElementCardinality());
    }

    /**
     * Verifies that a bytes collection created from another collection has the same element cardinality and bytes.
     */
    @Test
    public void ofWithCollectionShouldReturnABytesCollectionWithTheSameElementCardinalityAndBytes() {
        Collection<Byte> source = Collection.of(DISTINCT_ELEMENTS, (byte) 1);
        ByteCollection actual = new ByteCollection.ArrayCollection(source);
        assertEquals(DISTINCT_ELEMENTS, actual.getElementCardinality());
        assertEquals(1, actual.size());
        assertTrue(actual.contains((byte) 1));
    }

    /**
     * Verifies that the <code>contains</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains((byte) 1));
        assertFalse(COLLECTION123.contains((byte) 0));
    }

    /**
     * Verifies that the <code>containsAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void containsAllShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.containsAll(ByteCollection.of((byte) 1)));
        assertFalse(COLLECTION123.containsAll(ByteCollection.of((byte) 0)));
    }

    /**
     * Verifies that the <code>get</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getShouldBeWiredCorrectlyToTheInternalCollection() {
        assertTrue(COLLECTION123.contains(COLLECTION123.get()));
    }

    /**
     * Verifies that the <code>spliterator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void spliteratorShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, COLLECTION123.spliterator().estimateSize());
    }

    /**
     * Verifies that the <code>toArray</code> method is wired correctly to the internal collection.
     */
    @Test
    public void toArrayShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(THREE, COLLECTION123.toArray().length);
    }
}
