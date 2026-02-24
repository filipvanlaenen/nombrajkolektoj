package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.AbstractUpdatableBigDecimalMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.UpdatableBigDecimalMap} implementation.
 */
public class AbstractUpdatableBigDecimalMapTest {
    /**
     * The magic number three.
     */
    private static final BigDecimal THREE = BigDecimal.valueOf(3L);
    /**
     * The magic number minus one.
     */
    private static final BigDecimal MINUS_ONE = BigDecimal.valueOf(-1L);
    /**
     * The magic number minus two.
     */
    private static final BigDecimal MINUS_TWO = BigDecimal.valueOf(-2L);
    /**
     * Map with the BigDecimals 1 and 2.
     */
    private static final UpdatableBigDecimalMap<String> MAP12 = UpdatableBigDecimalMap.of("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L));
    /**
     * Map with the BigDecimals 1 and 2 and <code>null</code>.
     */
    private static final UpdatableBigDecimalMap<String> MAP12NULL =
            UpdatableBigDecimalMap.of("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L), "null", null);

    /**
     * Creates a new updatable BigDecimal map for unit testing.
     *
     * @return A new updatable BigDecimal map.
     */
    private UpdatableBigDecimalMap<String> createMap12() {
        return UpdatableBigDecimalMap.of("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L));
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with an absent key.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.augment("zero", BigDecimal.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.augment("null", BigDecimal.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> returns the old value.
     */
    @Test
    public void augmentShouldReturnTheOldValue() {
        assertEquals(BigDecimal.ONE, createMap12().augment("one", BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that <code>augment</code> updates the value for the given key.
     */
    @Test
    public void augmentShouldUpdateTheValueForTheKey() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        map12.augment("one", BigDecimal.valueOf(2L));
        assertEquals(THREE, map12.get("one"));
    }

    /**
     * Verifies that <code>divide</code> throws an exception when called with an absent key.
     */
    @Test
    public void divideShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.divide("zero", BigDecimal.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>divide</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void divideShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.divide("null", BigDecimal.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>divide</code> returns the old value.
     */
    @Test
    public void divideShouldReturnTheOldValue() {
        assertEquals(BigDecimal.ONE, createMap12().divide("one", BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that <code>divide</code> updates the value for the given key.
     */
    @Test
    public void divideShouldUpdateTheValueForTheKey() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        map12.divide("two", MINUS_TWO);
        assertEquals(MINUS_ONE, map12.get("two"));
    }

    /**
     * Verifies that <code>divide</code> updates all the values.
     */
    @Test
    public void divideShouldUpdateAllValues() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        map12.divide(MINUS_ONE);
        assertEquals(MINUS_ONE, map12.get("one"));
        assertEquals(MINUS_TWO, map12.get("two"));
    }

    /**
     * Verifies that <code>divide</code> returns <code>true</code> when at least one value has been changed.
     */
    @Test
    public void divideShouldReturnTrueWhenAValuesHasChanged() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        assertTrue(map12.divide(MINUS_ONE));
    }

    /**
     * Verifies that <code>divide</code> returns <code>false</code> when no value has been changed.
     */
    @Test
    public void divideShouldReturnFalseWhenNoValueHasChanged() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        assertFalse(map12.divide(BigDecimal.ONE));
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with an absent key.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.multiply("zero", BigDecimal.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.multiply("null", BigDecimal.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> returns the old value.
     */
    @Test
    public void multiplyShouldReturnTheOldValue() {
        assertEquals(BigDecimal.ONE, createMap12().multiply("one", BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that <code>multiply</code> updates the value for the given key.
     */
    @Test
    public void multiplyShouldUpdateTheValueForTheKey() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        map12.multiply("one", BigDecimal.valueOf(2L));
        assertEquals(BigDecimal.valueOf(2L), map12.get("one"));
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
        assertEquals(BigDecimal.ONE, createMap12().negate("one"));
    }

    /**
     * Verifies that <code>negate</code> updates the value for the given key.
     */
    @Test
    public void negateShouldUpdateTheValueForTheKey() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        map12.negate("one");
        assertEquals(MINUS_ONE, map12.get("one"));
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with an absent key.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.subtract("zero", BigDecimal.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.subtract("null", BigDecimal.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> returns the old value.
     */
    @Test
    public void subtractShouldReturnTheOldValue() {
        assertEquals(BigDecimal.ONE, createMap12().subtract("one", BigDecimal.valueOf(2L)));
    }

    /**
     * Verifies that <code>subtract</code> updates the value for the given key.
     */
    @Test
    public void subtractShouldUpdateTheValueForTheKey() {
        UpdatableBigDecimalMap<String> map12 = createMap12();
        map12.subtract("one", BigDecimal.valueOf(2L));
        assertEquals(MINUS_ONE, map12.get("one"));
    }
}
