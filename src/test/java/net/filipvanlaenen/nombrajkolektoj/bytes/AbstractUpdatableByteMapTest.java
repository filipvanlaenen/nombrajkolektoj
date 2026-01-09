package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.bytes.AbstractUpdatableByteMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableByteMap} implementation.
 */
public class AbstractUpdatableByteMapTest {
    /**
     * The magic number three.
     */
    private static final Byte THREE = (byte) 3;
    /**
     * The magic number minus one.
     */
    private static final Byte MINUS_ONE = -(byte) 1;
    /**
     * The magic number minus two.
     */
    private static final Byte MINUS_TWO = -(byte) 2;
    /**
     * Map with the bytes 1 and 2.
     */
    private static final UpdatableByteMap<String> MAP12 = UpdatableByteMap.of("one", (byte) 1, "two", (byte) 2);
    /**
     * Map with the bytes 1 and 2 and <code>null</code>.
     */
    private static final UpdatableByteMap<String> MAP12NULL =
            UpdatableByteMap.of("one", (byte) 1, "two", (byte) 2, "null", null);

    /**
     * Creates a new updatable byte map for unit testing.
     *
     * @return A new updatable byte map.
     */
    private UpdatableByteMap<String> createMap12() {
        return UpdatableByteMap.of("one", (byte) 1, "two", (byte) 2);
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with an absent key.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.augment("zero", (byte) 1));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.augment("null", (byte) 1));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> returns the old value.
     */
    @Test
    public void augmentShouldReturnTheOldValue() {
        assertEquals((byte) 1, createMap12().augment("one", (byte) 2));
    }

    /**
     * Verifies that <code>augment</code> updates the value for the given key.
     */
    @Test
    public void augmentShouldUpdateTheValueForTheKey() {
        UpdatableByteMap<String> map12 = createMap12();
        map12.augment("one", (byte) 2);
        assertEquals(THREE, map12.get("one"));
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with an absent key.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.multiply("zero", (byte) 1));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.multiply("null", (byte) 1));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> returns the old value.
     */
    @Test
    public void multiplyShouldReturnTheOldValue() {
        assertEquals((byte) 1, createMap12().multiply("one", (byte) 2));
    }

    /**
     * Verifies that <code>multiply</code> updates the value for the given key.
     */
    @Test
    public void multiplyShouldUpdateTheValueForTheKey() {
        UpdatableByteMap<String> map12 = createMap12();
        map12.multiply("one", (byte) 2);
        assertEquals((byte) 2, map12.get("one"));
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
        assertEquals((byte) 1, createMap12().negate("one"));
    }

    /**
     * Verifies that <code>negate</code> updates the value for the given key.
     */
    @Test
    public void negateShouldUpdateTheValueForTheKey() {
        UpdatableByteMap<String> map12 = createMap12();
        map12.negate("one");
        assertEquals(MINUS_ONE, map12.get("one"));
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with an absent key.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.subtract("zero", (byte) 1));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.subtract("null", (byte) 1));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> returns the old value.
     */
    @Test
    public void subtractShouldReturnTheOldValue() {
        assertEquals((byte) 1, createMap12().subtract("one", (byte) 2));
    }

    /**
     * Verifies that <code>subtract</code> updates the value for the given key.
     */
    @Test
    public void subtractShouldUpdateTheValueForTheKey() {
        UpdatableByteMap<String> map12 = createMap12();
        map12.subtract("one", (byte) 2);
        assertEquals(MINUS_ONE, map12.get("one"));
    }

    /**
     * Verifies that <code>divide</code> throws an exception when called with an absent key.
     */
    @Test
    public void divideShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.divide("zero", (byte) 1));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>divide</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void divideShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.divide("null", (byte) 1));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>divide</code> returns the old value.
     */
    @Test
    public void divideShouldReturnTheOldValue() {
        assertEquals((byte) 1, createMap12().divide("one", (byte) 2));
    }

    /**
     * Verifies that <code>divide</code> updates the value for the given key.
     */
    @Test
    public void divideShouldUpdateTheValueForTheKey() {
        UpdatableByteMap<String> map12 = createMap12();
        map12.divide("two", MINUS_TWO);
        assertEquals(MINUS_ONE, map12.get("two"));
    }
}
