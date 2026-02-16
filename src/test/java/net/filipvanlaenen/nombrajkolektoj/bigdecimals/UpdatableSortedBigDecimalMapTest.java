package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.UpdatableSortedBigDecimalMap} class.
 */
public final class UpdatableSortedBigDecimalMapTest extends UpdatableBigDecimalMapTestBase<UpdatableSortedBigDecimalMap<String>> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);

    @Override
    protected UpdatableSortedBigDecimalMap<String> createEmptyBigDecimalMap() {
        return UpdatableSortedBigDecimalMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(UpdatableSortedBigDecimalMap<String> map) {
        return UpdatableSortedBigDecimalMap.of(map);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return UpdatableSortedBigDecimalMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2, final String key3, final BigDecimal value3) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2, final String key3, final BigDecimal value3, final String key4,
            final BigDecimal value4) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1,
            final String key2, final BigDecimal value2, final String key3, final BigDecimal value3, final String key4,
            final BigDecimal value4, final String key5, final BigDecimal value5) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createUpdatableBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createUpdatableBigDecimalMap(final BigDecimal defaultValue,
            final String... keys) {
        return UpdatableSortedBigDecimalMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedBigDecimalMap<String> createUpdatableBigDecimalMap(
            final KeyAndValueCardinality keyAndValueCardinality, final BigDecimal defaultValue, final String... keys) {
        return UpdatableSortedBigDecimalMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a BigDecimals map with three entries.
     *
     * @return A BigDecimals map with three entries.
     */
    private UpdatableSortedBigDecimalMap<String> createBigDecimalMap123() {
        return createBigDecimalMap("one", BigDecimal.ONE, "two", BigDecimal.valueOf(2L), "three", BIG_DECIMAL_THREE);
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
        assertEquals(new Entry<String, BigDecimal>("two", BigDecimal.valueOf(2L)), createBigDecimalMap123().getGreatest());
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
        assertEquals(new Entry<String, BigDecimal>("one", BigDecimal.ONE), createBigDecimalMap123().getLeast());
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
}
