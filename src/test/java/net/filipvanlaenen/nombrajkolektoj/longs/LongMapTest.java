package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.LongMap} class.
 */
public final class LongMapTest extends LongMapTestBase<LongMap<String>> {
    /**
     * Map with the longs 1 and 2.
     */
    private final LongMap<String> map12 = LongMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the longs 1, 2 and 3.
     */
    private final LongMap<String> map123 = LongMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected LongMap<String> createEmptyLongMap() {
        return LongMap.empty();
    }

    @Override
    protected LongMap<String> createLongMap(final LongMap<String> map) {
        return LongMap.of(map);
    }

    @Override
    protected LongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return LongMap.of(entries);
    }

    @Override
    protected LongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final LongMap<String> map) {
        return LongMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected LongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return LongMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected LongMap<String> createLongMap(final String key, final Long value) {
        return LongMap.of(key, value);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return LongMap.of(key1, value1, key2, value2);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return LongMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return LongMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected LongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return LongMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(LongMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(LongMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(LongMap.of(ENTRY3).containsSame(LongMap.differenceOf(map123, LongMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(LongMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(LongMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(LongMap.intersectionOf(LongMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        LongMap<String> map23 = createLongMap(ENTRY2, ENTRY3);
        LongMap<String> actual = LongMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createLongMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        LongMap<String> map23 = createLongMap(ENTRY2, ENTRY3);
        LongMap<String> actual = LongMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        LongMap<String> expected =
                createLongMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
