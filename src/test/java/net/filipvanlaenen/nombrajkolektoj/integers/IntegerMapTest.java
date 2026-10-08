package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 */
public final class IntegerMapTest extends IntegerMapTestBase<IntegerMap<String>> {
    /**
     * Map with the integers 1 and 2.
     */
    private final IntegerMap<String> map12 = IntegerMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the integers 1, 2 and 3.
     */
    private final IntegerMap<String> map123 = IntegerMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected IntegerMap<String> createEmptyIntegerMap() {
        return IntegerMap.empty();
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final IntegerMap<String> map) {
        return IntegerMap.of(map);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return IntegerMap.of(entries);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final IntegerMap<String> map) {
        return IntegerMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return IntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return IntegerMap.of(key, value);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2) {
        return IntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3) {
        return IntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4) {
        return IntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4,
            final String key5, final Integer value5) {
        return IntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(IntegerMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(IntegerMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(IntegerMap.of(ENTRY3).containsSame(IntegerMap.differenceOf(map123, IntegerMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(IntegerMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(IntegerMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(IntegerMap.intersectionOf(IntegerMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        IntegerMap<String> map23 = createIntegerMap(ENTRY2, ENTRY3);
        IntegerMap<String> actual = IntegerMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createIntegerMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        IntegerMap<String> map23 = createIntegerMap(ENTRY2, ENTRY3);
        IntegerMap<String> actual = IntegerMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        IntegerMap<String> expected =
                createIntegerMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
