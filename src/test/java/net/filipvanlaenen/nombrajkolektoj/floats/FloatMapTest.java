package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.FloatMap} class.
 */
public final class FloatMapTest extends FloatMapTestBase<FloatMap<String>> {
    /**
     * Map with the floats 1 and 2.
     */
    private final FloatMap<String> map12 = FloatMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the floats 1, 2 and 3.
     */
    private final FloatMap<String> map123 = FloatMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected FloatMap<String> createEmptyFloatMap() {
        return FloatMap.empty();
    }

    @Override
    protected FloatMap<String> createFloatMap(final FloatMap<String> map) {
        return FloatMap.of(map);
    }

    @Override
    protected FloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return FloatMap.of(entries);
    }

    @Override
    protected FloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final FloatMap<String> map) {
        return FloatMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected FloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return FloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key, final Float value) {
        return FloatMap.of(key, value);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return FloatMap.of(key1, value1, key2, value2);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected FloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return FloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(FloatMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(FloatMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(FloatMap.of(ENTRY3).containsSame(FloatMap.differenceOf(map123, FloatMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(FloatMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(FloatMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(FloatMap.intersectionOf(FloatMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        FloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        FloatMap<String> actual = FloatMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createFloatMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        FloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        FloatMap<String> actual = FloatMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        FloatMap<String> expected =
                createFloatMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
