package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ShortMap} class.
 */
public final class ShortMapTest extends ShortMapTestBase<ShortMap<String>> {
    /**
     * Map with the shorts 1 and 2.
     */
    private final ShortMap<String> map12 = ShortMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the shorts 1, 2 and 3.
     */
    private final ShortMap<String> map123 = ShortMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ShortMap<String> createEmptyShortMap() {
        return ShortMap.empty();
    }

    @Override
    protected ShortMap<String> createShortMap(final ShortMap<String> map) {
        return ShortMap.of(map);
    }

    @Override
    protected ShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return ShortMap.of(entries);
    }

    @Override
    protected ShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ShortMap<String> map) {
        return ShortMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected ShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return ShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key, final Short value) {
        return ShortMap.of(key, value);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return ShortMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return ShortMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return ShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return ShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ShortMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ShortMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(ShortMap.of(ENTRY3).containsSame(ShortMap.differenceOf(map123, ShortMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ShortMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ShortMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(ShortMap.intersectionOf(ShortMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ShortMap<String> map23 = createShortMap(ENTRY2, ENTRY3);
        ShortMap<String> actual = ShortMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createShortMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ShortMap<String> map23 = createShortMap(ENTRY2, ENTRY3);
        ShortMap<String> actual = ShortMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ShortMap<String> expected =
                createShortMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
