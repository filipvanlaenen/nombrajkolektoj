package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.BigDecimalMap} class.
 */
public final class BigDecimalMapTest extends BigDecimalMapTestBase<BigDecimalMap<String>> {
    /**
     * Map with the BigDecimals 1 and 2.
     */
    private final BigDecimalMap<String> map12 = BigDecimalMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the BigDecimals 1, 2 and 3.
     */
    private final BigDecimalMap<String> map123 = BigDecimalMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected BigDecimalMap<String> createEmptyBigDecimalMap() {
        return BigDecimalMap.empty();
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final BigDecimalMap<String> map) {
        return BigDecimalMap.of(map);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final Entry<String, BigDecimal>... entries) {
        return BigDecimalMap.of(entries);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigDecimalMap<String> map) {
        return BigDecimalMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigDecimal>... entries) {
        return BigDecimalMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key, final BigDecimal value) {
        return BigDecimalMap.of(key, value);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2) {
        return BigDecimalMap.of(key1, value1, key2, value2);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3) {
        return BigDecimalMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4) {
        return BigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected BigDecimalMap<String> createBigDecimalMap(final String key1, final BigDecimal value1, final String key2,
            final BigDecimal value2, final String key3, final BigDecimal value3, final String key4, final BigDecimal value4,
            final String key5, final BigDecimal value5) {
        return BigDecimalMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(BigDecimalMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(BigDecimalMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(BigDecimalMap.of(ENTRY3).containsSame(BigDecimalMap.differenceOf(map123, BigDecimalMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(BigDecimalMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(BigDecimalMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(BigDecimalMap.intersectionOf(BigDecimalMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        BigDecimalMap<String> map23 = createBigDecimalMap(ENTRY2, ENTRY3);
        BigDecimalMap<String> actual = BigDecimalMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createBigDecimalMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        BigDecimalMap<String> map23 = createBigDecimalMap(ENTRY2, ENTRY3);
        BigDecimalMap<String> actual = BigDecimalMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        BigDecimalMap<String> expected =
                createBigDecimalMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
