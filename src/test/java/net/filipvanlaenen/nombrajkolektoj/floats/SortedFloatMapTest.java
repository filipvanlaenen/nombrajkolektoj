package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.SortedFloatMap} class.
 */
public final class SortedFloatMapTest extends FloatMapTestBase<SortedFloatMap<String>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    @Override
    protected SortedFloatMap<String> createEmptyFloatMap() {
        return SortedFloatMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return SortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return SortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key, final Float value) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return SortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }

    /**
     * Creates a floats map with three entries.
     *
     * @return A floats map with three entries.
     */
    private SortedFloatMap<String> createFloatMap123() {
        return createFloatMap("one", 1F, "two", 2F, "three", FLOAT_THREE);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createFloatMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("two", 2F), createFloatMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createFloatMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("one", 1F), createFloatMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createFloatMap123().getLeastKey());
    }
}
