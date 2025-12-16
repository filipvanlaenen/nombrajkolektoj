package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerMap} class.
 */
public final class ModifiableBigIntegerMapTest extends UpdatableBigIntegerMapTestBase<ModifiableBigIntegerMap<String>> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * An entry for one.
     */
    private static final Entry<String, BigInteger> ENTRY1 = new Entry<String, BigInteger>("one", BigInteger.ONE);
    /**
     * An entry for two.
     */
    private static final Entry<String, BigInteger> ENTRY2 = new Entry<String, BigInteger>("two", BigInteger.TWO);
    /**
     * An entry for three.
     */
    private static final Entry<String, BigInteger> ENTRY3 = new Entry<String, BigInteger>("three", BIG_INTEGER_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, BigInteger> ENTRY4 = new Entry<String, BigInteger>("four", BIG_INTEGER_FOUR);

    @Override
    protected ModifiableBigIntegerMap<String> createEmptyBigIntegerMap() {
        return ModifiableBigIntegerMap.<String>empty();
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return ModifiableBigIntegerMap.of(entries);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return ModifiableBigIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return ModifiableBigIntegerMap.of(key, value);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4,
            final String key5, final BigInteger value5) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final BigInteger defaultValue, final String... keys) {
        return ModifiableBigIntegerMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigInteger defaultValue, final String... keys) {
        return ModifiableBigIntegerMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return ModifiableBigIntegerMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", BIG_INTEGER_FOUR));
        assertEquals(BIG_INTEGER_FOUR, map123.get("four"));
        assertFalse(map123.add("four", BIG_INTEGER_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableBigIntegerMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableBigIntegerMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(BigInteger.ONE, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", BigInteger.TWO));
        assertTrue(map123.remove("one", BigInteger.ONE));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createBigIntegerMap(ENTRY3)));
        assertFalse(map123.removeAll(createBigIntegerMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableBigIntegerMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableBigIntegerMap(ENTRY3)));
    }
}
