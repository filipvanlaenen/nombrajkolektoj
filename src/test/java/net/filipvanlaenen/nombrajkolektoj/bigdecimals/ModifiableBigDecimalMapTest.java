package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalMap} class.
 */
public final class ModifiableBigDecimalMapTest extends UpdatableBigDecimalMapTestBase<ModifiableBigDecimalMap<String>> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    /**
     * An entry for one.
     */
    private static final Entry<String, BigDecimal> ENTRY1 = new Entry<String, BigDecimal>("one", BigDecimal.ONE);
    /**
     * An entry for two.
     */
    private static final Entry<String, BigDecimal> ENTRY2 = new Entry<String, BigDecimal>("two", BigDecimal.valueOf(2L));
    /**
     * An entry for three.
     */
    private static final Entry<String, BigDecimal> ENTRY3 = new Entry<String, BigDecimal>("three", BIG_DECIMAL_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, BigDecimal> ENTRY4 = new Entry<String, BigDecimal>("four", BIG_DECIMAL_FOUR);

    @Override
    protected ModifiableBigDecimalMap<String> createEmptyBigDecimalMap() {
        return ModifiableBigDecimalMap.<String>empty();
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return ModifiableBigDecimalMap.of(entries);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(ModifiableBigDecimalMap<String> map) {
        return ModifiableBigDecimalMap.of(map);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return ModifiableBigDecimalMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return ModifiableBigDecimalMap.of(key, value);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2) {
        return ModifiableBigDecimalMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3) {
        return ModifiableBigDecimalMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4) {
        return ModifiableBigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4,
            final String key5, final BigDecimal value5) {
        return ModifiableBigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createUpdatableBigDecimalMap(final BigDecimal defaultValue, final String... keys) {
        return ModifiableBigDecimalMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createUpdatableBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigDecimal defaultValue, final String... keys) {
        return ModifiableBigDecimalMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableBigDecimalMap<String> createUpdatableBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return ModifiableBigDecimalMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", BIG_DECIMAL_FOUR));
        assertEquals(BIG_DECIMAL_FOUR, map123.get("four"));
        assertFalse(map123.add("four", BIG_DECIMAL_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableBigDecimalMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableBigDecimalMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(BigDecimal.ONE, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", BigDecimal.valueOf(2L)));
        assertTrue(map123.remove("one", BigDecimal.ONE));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createBigDecimalMap(ENTRY3)));
        assertFalse(map123.removeAll(createBigDecimalMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableBigDecimalMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableBigDecimalMap(ENTRY3)));
    }
}
