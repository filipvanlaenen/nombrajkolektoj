package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} class.
 *
 * @param <T> The subclass type to be tested.
 */
public abstract class ModifiableByteCollectionTestBase<T extends ModifiableNumericCollection<Byte>>
        extends ByteCollectionTestBase<T> {
    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.add((byte) 1));
        assertFalse(collection.add((byte) 1));
        assertTrue(collection.contains((byte) 1));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection(DISTINCT_ELEMENTS);
        assertTrue(collection.addAll(createByteCollection((byte) 1)));
        assertFalse(collection.addAll(createByteCollection((byte) 1)));
        assertTrue(collection.contains((byte) 1));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection((byte) 1);
        collection.clear();
        assertTrue(collection.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection((byte) 1, (byte) 2);
        assertTrue(collection.remove((byte) 1));
        assertFalse(collection.remove((byte) 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection((byte) 1, (byte) 2);
        assertTrue(collection.removeAll(createByteCollection((byte) 1)));
        assertFalse(collection.removeAll(createByteCollection((byte) 1)));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection((byte) 1, (byte) 2);
        assertTrue(collection.removeIf(l -> l == (byte) 1));
        assertFalse(collection.removeIf(l -> l == (byte) 1));
        assertEquals(1, collection.size());
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalCollection() {
        T collection = createByteCollection((byte) 1, (byte) 2);
        assertFalse(collection.retainAll(createByteCollection((byte) 1, (byte) 2)));
        assertTrue(collection.retainAll(createByteCollection((byte) 1)));
        assertEquals(1, collection.size());
    }
}
