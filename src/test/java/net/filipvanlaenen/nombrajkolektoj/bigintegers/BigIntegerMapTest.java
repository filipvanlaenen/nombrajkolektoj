package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.BigIntegerMap} class.
 */
public final class BigIntegerMapTest extends BigIntegerMapTestBase<BigIntegerMap<String>> {
    /**
     * Map with the BigIntegers 1 and 2.
     */
    private final BigIntegerMap<String> map12 = BigIntegerMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the BigIntegers 1, 2 and 3.
     */
    private final BigIntegerMap<String> map123 = BigIntegerMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected BigIntegerMap<String> createEmptyBigIntegerMap() {
        return BigIntegerMap.empty();
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final BigIntegerMap<String> map) {
        return BigIntegerMap.of(map);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return BigIntegerMap.of(entries);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigIntegerMap<String> map) {
        return BigIntegerMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return BigIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return BigIntegerMap.of(key, value);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2) {
        return BigIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3) {
        return BigIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4) {
        return BigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected BigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4,
            final String key5, final BigInteger value5) {
        return BigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(BigIntegerMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(BigIntegerMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(BigIntegerMap.of(ENTRY3).containsSame(BigIntegerMap.differenceOf(map123, BigIntegerMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(BigIntegerMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(BigIntegerMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(BigIntegerMap.intersectionOf(BigIntegerMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        BigIntegerMap<String> map23 = createBigIntegerMap(ENTRY2, ENTRY3);
        BigIntegerMap<String> actual = BigIntegerMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createBigIntegerMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        BigIntegerMap<String> map23 = createBigIntegerMap(ENTRY2, ENTRY3);
        BigIntegerMap<String> actual = BigIntegerMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        BigIntegerMap<String> expected =
                createBigIntegerMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
