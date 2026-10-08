package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleMap} class.
 */
public final class DoubleMapTest extends DoubleMapTestBase<DoubleMap<String>> {
    /**
     * Map with the doubles 1 and 2.
     */
    private final DoubleMap<String> map12 = DoubleMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the doubles 1, 2 and 3.
     */
    private final DoubleMap<String> map123 = DoubleMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected DoubleMap<String> createEmptyDoubleMap() {
        return DoubleMap.empty();
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final DoubleMap<String> map) {
        return DoubleMap.of(map);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return DoubleMap.of(entries);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final DoubleMap<String> map) {
        return DoubleMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return DoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key, final Double value) {
        return DoubleMap.of(key, value);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return DoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected DoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return DoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(DoubleMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(DoubleMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(DoubleMap.of(ENTRY3).containsSame(DoubleMap.differenceOf(map123, DoubleMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(DoubleMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(DoubleMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(DoubleMap.intersectionOf(DoubleMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        DoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        DoubleMap<String> actual = DoubleMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createDoubleMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        DoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        DoubleMap<String> actual = DoubleMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        DoubleMap<String> expected =
                createDoubleMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
