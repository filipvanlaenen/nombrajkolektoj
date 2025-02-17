package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.shorts.AbstractUpdatableShortMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableShortMap} implementation.
 */
public class AbstractUpdatableShortMapTest {
    /**
     * The magic number three.
     */
    private static final Short THREE = (short) 3;
    /**
     * The magic number minus one.
     */
    private static final Short MINUS_ONE = -(short) 1;
    /**
     * Map with the shorts 1 and 2.
     */
    private static final UpdatableShortMap<String> MAP12 = UpdatableShortMap.of("one", (short) 1, "two", (short) 2);
    /**
     * Map with the shorts 1 and 2 and <code>null</code>.
     */
    private static final UpdatableShortMap<String> MAP12NULL =
            UpdatableShortMap.of("one", (short) 1, "two", (short) 2, "null", null);

    /**
     * Creates a new updatable short map for unit testing.
     *
     * @return A new updatable short map.
     */
    private UpdatableShortMap<String> createMap12() {
        return UpdatableShortMap.of("one", (short) 1, "two", (short) 2);
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with an absent key.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.augment("zero", (short) 1));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.augment("null", (short) 1));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> returns the old value.
     */
    @Test
    public void augmentShouldReturnTheOldValue() {
        assertEquals((short) 1, createMap12().augment("one", (short) 2));
    }

    /**
     * Verifies that <code>augment</code> updates the value for the given key.
     */
    @Test
    public void augmentShouldUpdateTheValueForTheKey() {
        UpdatableShortMap<String> map12 = createMap12();
        map12.augment("one", (short) 2);
        assertEquals(THREE, map12.get("one"));
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with an absent key.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.multiply("zero", (short) 1));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.multiply("null", (short) 1));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> returns the old value.
     */
    @Test
    public void multiplyShouldReturnTheOldValue() {
        assertEquals((short) 1, createMap12().multiply("one", (short) 2));
    }

    /**
     * Verifies that <code>multiply</code> updates the value for the given key.
     */
    @Test
    public void multiplyShouldUpdateTheValueForTheKey() {
        UpdatableShortMap<String> map12 = createMap12();
        map12.multiply("one", (short) 2);
        assertEquals((short) 2, map12.get("one"));
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
        assertEquals((short) 1, createMap12().negate("one"));
    }

    /**
     * Verifies that <code>negate</code> updates the value for the given key.
     */
    @Test
    public void negateShouldUpdateTheValueForTheKey() {
        UpdatableShortMap<String> map12 = createMap12();
        map12.negate("one");
        assertEquals(MINUS_ONE, map12.get("one"));
    }
}
