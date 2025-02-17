package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.longs.AbstractUpdatableLongMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableLongMap} implementation.
 */
public class AbstractUpdatableLongMapTest {
    /**
     * The magic number three.
     */
    private static final Long THREE = 3L;
    /**
     * The magic number minus one.
     */
    private static final Long MINUS_ONE = -1L;
    /**
     * Map with the longs 1 and 2.
     */
    private static final UpdatableLongMap<String> MAP12 = UpdatableLongMap.of("one", 1L, "two", 2L);
    /**
     * Map with the longs 1 and 2 and <code>null</code>.
     */
    private static final UpdatableLongMap<String> MAP12NULL =
            UpdatableLongMap.of("one", 1L, "two", 2L, "null", null);

    /**
     * Creates a new updatable long map for unit testing.
     *
     * @return A new updatable long map.
     */
    private UpdatableLongMap<String> createMap12() {
        return UpdatableLongMap.of("one", 1L, "two", 2L);
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with an absent key.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.augment("zero", 1L));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.augment("null", 1L));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> returns the old value.
     */
    @Test
    public void augmentShouldReturnTheOldValue() {
        assertEquals(1L, createMap12().augment("one", 2L));
    }

    /**
     * Verifies that <code>augment</code> updates the value for the given key.
     */
    @Test
    public void augmentShouldUpdateTheValueForTheKey() {
        UpdatableLongMap<String> map12 = createMap12();
        map12.augment("one", 2L);
        assertEquals(THREE, map12.get("one"));
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with an absent key.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.multiply("zero", 1L));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.multiply("null", 1L));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> returns the old value.
     */
    @Test
    public void multiplyShouldReturnTheOldValue() {
        assertEquals(1L, createMap12().multiply("one", 2L));
    }

    /**
     * Verifies that <code>multiply</code> updates the value for the given key.
     */
    @Test
    public void multiplyShouldUpdateTheValueForTheKey() {
        UpdatableLongMap<String> map12 = createMap12();
        map12.multiply("one", 2L);
        assertEquals(2L, map12.get("one"));
    }

    /**
     * Verifies that <code>negate</code> throws an exception when called with an absent key.
     */
    @Test
    public void negateShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> MAP12.negate("zero"));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>negate</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void negateShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.negate("null"));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>negate</code> returns the old value.
     */
    @Test
    public void negateShouldReturnTheOldValue() {
        assertEquals(1L, createMap12().negate("one"));
    }

    /**
     * Verifies that <code>negate</code> updates the value for the given key.
     */
    @Test
    public void negateShouldUpdateTheValueForTheKey() {
        UpdatableLongMap<String> map12 = createMap12();
        map12.negate("one");
        assertEquals(MINUS_ONE, map12.get("one"));
    }
}
