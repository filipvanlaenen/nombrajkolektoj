package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.doubles.AbstractUpdatableDoubleMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableDoubleMap} implementation.
 */
public class AbstractUpdatableDoubleMapTest {
    /**
     * The magic number three.
     */
    private static final Double THREE = 3D;
    /**
     * The magic number minus one.
     */
    private static final Double MINUS_ONE = -1D;
    /**
     * Map with the doubles 1 and 2.
     */
    private static final UpdatableDoubleMap<String> MAP12 = UpdatableDoubleMap.of("one", 1D, "two", 2D);
    /**
     * Map with the doubles 1 and 2 and <code>null</code>.
     */
    private static final UpdatableDoubleMap<String> MAP12NULL =
            UpdatableDoubleMap.of("one", 1D, "two", 2D, "null", null);

    /**
     * Creates a new updatable double map for unit testing.
     *
     * @return A new updatable double map.
     */
    private UpdatableDoubleMap<String> createMap12() {
        return UpdatableDoubleMap.of("one", 1D, "two", 2D);
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with an absent key.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.augment("zero", 1D));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.augment("null", 1D));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> returns the old value.
     */
    @Test
    public void augmentShouldReturnTheOldValue() {
        assertEquals(1D, createMap12().augment("one", 2D));
    }

    /**
     * Verifies that <code>augment</code> updates the value for the given key.
     */
    @Test
    public void augmentShouldUpdateTheValueForTheKey() {
        UpdatableDoubleMap<String> map12 = createMap12();
        map12.augment("one", 2D);
        assertEquals(THREE, map12.get("one"));
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with an absent key.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.multiply("zero", 1D));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.multiply("null", 1D));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> returns the old value.
     */
    @Test
    public void multiplyShouldReturnTheOldValue() {
        assertEquals(1D, createMap12().multiply("one", 2D));
    }

    /**
     * Verifies that <code>multiply</code> updates the value for the given key.
     */
    @Test
    public void multiplyShouldUpdateTheValueForTheKey() {
        UpdatableDoubleMap<String> map12 = createMap12();
        map12.multiply("one", 2D);
        assertEquals(2D, map12.get("one"));
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
        assertEquals(1D, createMap12().negate("one"));
    }

    /**
     * Verifies that <code>negate</code> updates the value for the given key.
     */
    @Test
    public void negateShouldUpdateTheValueForTheKey() {
        UpdatableDoubleMap<String> map12 = createMap12();
        map12.negate("one");
        assertEquals(MINUS_ONE, map12.get("one"));
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with an absent key.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.subtract("zero", 1D));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.subtract("null", 1D));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> returns the old value.
     */
    @Test
    public void subtractShouldReturnTheOldValue() {
        assertEquals(1D, createMap12().subtract("one", 2D));
    }

    /**
     * Verifies that <code>subtract</code> updates the value for the given key.
     */
    @Test
    public void subtractShouldUpdateTheValueForTheKey() {
        UpdatableDoubleMap<String> map12 = createMap12();
        map12.subtract("one", 2D);
        assertEquals(MINUS_ONE, map12.get("one"));
    }
}
