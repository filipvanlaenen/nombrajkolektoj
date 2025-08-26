package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.SortedLongMap} class.
 */
public final class SortedLongMapTest extends LongMapTestBase<SortedLongMap<String>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    @Override
    protected SortedLongMap<String> createEmptyLongMap() {
        return SortedLongMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return SortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return SortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key, final Long value) {
        return SortedLongMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return SortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }

    /**
     * Creates a longs map with three entries.
     *
     * @return A longs map with three entries.
     */
    private SortedLongMap<String> createLongMap123() {
        return createLongMap("one", 1L, "two", 2L, "three", LONG_THREE);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createLongMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Long>("two", 2L), createLongMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createLongMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Long>("one", 1L), createLongMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createLongMap123().getLeastKey());
    }
}
