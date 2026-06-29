package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.AbstractUpdatableBigIntegerMap} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.UpdatableBigIntegerMap} implementation.
 */
public class AbstractUpdatableBigIntegerMapTest {
    /**
     * The magic number three.
     */
    private static final BigInteger THREE = BigInteger.valueOf(3L);
    /**
     * The magic number four.
     */
    private static final BigInteger FOUR = BigInteger.valueOf(4L);
    /**
     * The magic number minus one.
     */
    private static final BigInteger MINUS_ONE = BigInteger.valueOf(-1L);
    /**
     * The magic number minus two.
     */
    private static final BigInteger MINUS_TWO = BigInteger.valueOf(-2L);
    /**
     * Map with the BigIntegers 1 and 2.
     */
    private static final UpdatableBigIntegerMap<String> MAP12 = UpdatableBigIntegerMap.of("one", BigInteger.ONE, "two", BigInteger.TWO);
    /**
     * Map with the BigIntegers 1 and 2 and <code>null</code>.
     */
    private static final UpdatableBigIntegerMap<String> MAP12NULL =
            UpdatableBigIntegerMap.of("one", BigInteger.ONE, "two", BigInteger.TWO, "null", null);

    /**
     * Creates a new updatable BigInteger map for unit testing.
     *
     * @return A new updatable BigInteger map.
     */
    private UpdatableBigIntegerMap<String> createMap12() {
        return UpdatableBigIntegerMap.of("one", BigInteger.ONE, "two", BigInteger.TWO);
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with an absent key.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.augment("zero", BigInteger.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void augmentShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.augment("null", BigInteger.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>augment</code> returns the old value.
     */
    @Test
    public void augmentShouldReturnTheOldValue() {
        assertEquals(BigInteger.ONE, createMap12().augment("one", BigInteger.TWO));
    }

    /**
     * Verifies that <code>augment</code> updates the value for the given key.
     */
    @Test
    public void augmentShouldUpdateTheValueForTheKey() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.augment("one", BigInteger.TWO);
        assertEquals(THREE, map12.get("one"));
    }

    /**
     * Verifies that <code>augment</code> updates all the values.
     */
    @Test
    public void augmentShouldUpdateAllValues() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.augment(BigInteger.ONE);
        assertEquals(BigInteger.TWO, map12.get("one"));
        assertEquals(THREE, map12.get("two"));
    }

    /**
     * Verifies that <code>augment</code> returns <code>true</code> when at least one value has been changed.
     */
    @Test
    public void augmentShouldReturnTrueWhenAValuesHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertTrue(map12.augment(BigInteger.ONE));
    }

    /**
     * Verifies that <code>augment</code> returns <code>false</code> when no value has been changed.
     */
    @Test
    public void augmentShouldReturnFalseWhenNoValueHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertFalse(map12.augment(BigInteger.ZERO));
    }

    /**
     * Verifies that <code>divide</code> throws an exception when called with an absent key.
     */
    @Test
    public void divideShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.divide("zero", BigInteger.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>divide</code> throws an exception when called with a key having the value <code>null</code>.
     */
    @Test
    public void divideShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.divide("null", BigInteger.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>divide</code> returns the old value.
     */
    @Test
    public void divideShouldReturnTheOldValue() {
        assertEquals(BigInteger.ONE, createMap12().divide("one", BigInteger.TWO));
    }

    /**
     * Verifies that <code>divide</code> updates the value for the given key.
     */
    @Test
    public void divideShouldUpdateTheValueForTheKey() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.divide("two", MINUS_TWO);
        assertEquals(MINUS_ONE, map12.get("two"));
    }

    /**
     * Verifies that <code>divide</code> updates all the values.
     */
    @Test
    public void divideShouldUpdateAllValues() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.divide(MINUS_ONE);
        assertEquals(MINUS_ONE, map12.get("one"));
        assertEquals(MINUS_TWO, map12.get("two"));
    }

    /**
     * Verifies that <code>divide</code> returns <code>true</code> when at least one value has been changed.
     */
    @Test
    public void divideShouldReturnTrueWhenAValuesHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertTrue(map12.divide(MINUS_ONE));
    }

    /**
     * Verifies that <code>divide</code> returns <code>false</code> when no value has been changed.
     */
    @Test
    public void divideShouldReturnFalseWhenNoValueHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertFalse(map12.divide(BigInteger.ONE));
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with an absent key.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.multiply("zero", BigInteger.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void multiplyShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.multiply("null", BigInteger.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>multiply</code> returns the old value.
     */
    @Test
    public void multiplyShouldReturnTheOldValue() {
        assertEquals(BigInteger.ONE, createMap12().multiply("one", BigInteger.TWO));
    }

    /**
     * Verifies that <code>multiply</code> updates the value for the given key.
     */
    @Test
    public void multiplyShouldUpdateTheValueForTheKey() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.multiply("one", BigInteger.TWO);
        assertEquals(BigInteger.TWO, map12.get("one"));
    }

    /**
     * Verifies that <code>multiply</code> updates all the values.
     */
    @Test
    public void multiplyShouldUpdateAllValues() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.multiply(BigInteger.TWO);
        assertEquals(BigInteger.TWO, map12.get("one"));
        assertEquals(FOUR, map12.get("two"));
    }

    /**
     * Verifies that <code>multiply</code> returns <code>true</code> when at least one value has been changed.
     */
    @Test
    public void multiplyShouldReturnTrueWhenAValuesHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertTrue(map12.multiply(BigInteger.TWO));
    }

    /**
     * Verifies that <code>multiply</code> returns <code>false</code> when no value has been changed.
     */
    @Test
    public void multiplyShouldReturnFalseWhenNoValueHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertFalse(map12.multiply(BigInteger.ONE));
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
        assertEquals(BigInteger.ONE, createMap12().negate("one"));
    }

    /**
     * Verifies that <code>negate</code> updates the value for the given key.
     */
    @Test
    public void negateShouldUpdateTheValueForTheKey() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.negate("one");
        assertEquals(MINUS_ONE, map12.get("one"));
    }

    /**
     * Verifies that <code>negate</code> updates all the values.
     */
    @Test
    public void negateShouldUpdateAllValues() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.negate();
        assertEquals(MINUS_ONE, map12.get("one"));
        assertEquals(MINUS_TWO, map12.get("two"));
    }

    /**
     * Verifies that <code>negate</code> returns <code>true</code> when at least one value has been changed.
     */
    @Test
    public void negateShouldReturnTrueWhenAValuesHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertTrue(map12.negate());
    }

    /**
     * Verifies that <code>negate</code> returns <code>false</code> when no value has been changed.
     */
    @Test
    public void negateShouldReturnFalseWhenNoValueHasChanged() {
        UpdatableBigIntegerMap<String> map = UpdatableBigIntegerMap.of("one", BigInteger.ZERO, "two", BigInteger.ZERO);
        assertFalse(map.negate());
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with an absent key.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithAbsentKey() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12.subtract("zero", BigInteger.ONE));
        assertEquals("Map doesn't contain an entry with the key zero.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> throws an exception when called with a key having the value
     * <code>null</code>.
     */
    @Test
    public void subtractShouldThrowExceptionWhenCalledWithKeyHoldingNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> MAP12NULL.subtract("null", BigInteger.ONE));
        assertEquals("The entry in the map with the key null contains null.", exception.getMessage());
    }

    /**
     * Verifies that <code>subtract</code> returns the old value.
     */
    @Test
    public void subtractShouldReturnTheOldValue() {
        assertEquals(BigInteger.ONE, createMap12().subtract("one", BigInteger.TWO));
    }

    /**
     * Verifies that <code>subtract</code> updates the value for the given key.
     */
    @Test
    public void subtractShouldUpdateTheValueForTheKey() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.subtract("one", BigInteger.TWO);
        assertEquals(MINUS_ONE, map12.get("one"));
    }

    /**
     * Verifies that <code>subtract</code> updates all the values.
     */
    @Test
    public void subtractShouldUpdateAllValues() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        map12.subtract(BigInteger.ONE);
        assertEquals(BigInteger.ZERO, map12.get("one"));
        assertEquals(BigInteger.ONE, map12.get("two"));
    }

    /**
     * Verifies that <code>subtract</code> returns <code>true</code> when at least one value has been changed.
     */
    @Test
    public void subtractShouldReturnTrueWhenAValuesHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertTrue(map12.subtract(BigInteger.ONE));
    }

    /**
     * Verifies that <code>subtract</code> returns <code>false</code> when no value has been changed.
     */
    @Test
    public void subtractShouldReturnFalseWhenNoValueHasChanged() {
        UpdatableBigIntegerMap<String> map12 = createMap12();
        assertFalse(map12.subtract(BigInteger.ZERO));
    }

}
