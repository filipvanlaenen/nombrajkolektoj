package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.SortedBigDecimalMap} class.
 */
public final class SortedBigDecimalMapTest extends BigDecimalMapTestBase<SortedBigDecimalMap<String>> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);

    @Override
    protected SortedBigDecimalMap<String> createEmptyBigDecimalMap() {
        return SortedBigDecimalMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return SortedBigDecimalMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return SortedBigDecimalMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return SortedBigDecimalMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2) {
        return SortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3) {
        return SortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4) {
        return SortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedBigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4,
            final String key5, final BigDecimal value5) {
        return SortedBigDecimalMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }

    /**
     * Creates a BigDecimals map with three entries.
     *
     * @return A BigDecimals map with three entries.
     */
    private SortedBigDecimalMap<String> createBigDecimalMap123() {
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
}
