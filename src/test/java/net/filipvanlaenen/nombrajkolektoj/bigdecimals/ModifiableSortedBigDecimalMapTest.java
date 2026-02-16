package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableSortedBigDecimalMap} class.
 */

public final class ModifiableSortedBigDecimalMapTest extends UpdatableBigDecimalMapTestBase<ModifiableSortedBigDecimalMap<String>> {
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
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return ModifiableSortedBigDecimalMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2, final String key3, final BigDecimal value3) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2, final String key3, final BigDecimal value3, final String key4,
            final BigDecimal value4) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2, final String key3, final BigDecimal value3, final String key4,
            final BigDecimal value4, final String key5, final BigDecimal value5) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createEmptyBigDecimalMap() {
        return ModifiableSortedBigDecimalMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createBigDecimalMap(ModifiableSortedBigDecimalMap<String> map) {
        return ModifiableSortedBigDecimalMap.of(map);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createUpdatableBigDecimalMap(final BigDecimal defaultValue,
            final String... keys) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createUpdatableBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return ModifiableSortedBigDecimalMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedBigDecimalMap<String> createUpdatableBigDecimalMap(
            final KeyAndValueCardinality keyAndValueCardinality, final BigDecimal defaultValue, final String... keys) {
        return ModifiableSortedBigDecimalMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a BigDecimals map with three entries.
     *
     * @return A BigDecimals map with three entries.
     */
    private ModifiableSortedBigDecimalMap<String> createBigDecimalMap123() {
        return createBigDecimalMap("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L), "three", BIG_DECIMAL_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableBigDecimalMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableBigDecimalMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", BIG_DECIMAL_FOUR));
        assertEquals(BIG_DECIMAL_FOUR, map123.get("four"));
        assertFalse(map123.add("four", BIG_DECIMAL_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createBigDecimalMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createBigDecimalMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, BigDecimal>("three", BIG_DECIMAL_THREE),
                createBigDecimalMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createBigDecimalMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createBigDecimalMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createBigDecimalMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createBigDecimalMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createBigDecimalMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createBigDecimalMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createBigDecimalMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createBigDecimalMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createBigDecimalMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createBigDecimalMap123().getLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(BigDecimal.ONE, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", BigDecimal.valueOf(2L)));
        assertTrue(map123.remove("one", BigDecimal.ONE));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createBigDecimalMap(ENTRY3)));
        assertFalse(map123.removeAll(createBigDecimalMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY2, map123.removeGreatest());
        assertFalse(map123.containsKey("two"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>removeLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeLeastShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY1, map123.removeLeast());
        assertFalse(map123.containsKey("one"));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigDecimalMap<String> map123 = createUpdatableBigDecimalMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableBigDecimalMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableBigDecimalMap(ENTRY3)));
    }
}
