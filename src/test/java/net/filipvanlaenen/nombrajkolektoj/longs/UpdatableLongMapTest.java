package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableLongMap} class.
 */
public final class UpdatableLongMapTest extends LongMapTestBase<UpdatableLongMap<String>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;

    @Override
    protected UpdatableLongMap<String> createEmptyLongMap() {
        return UpdatableLongMap.<String>empty();
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return UpdatableLongMap.of(entries);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return UpdatableLongMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key, final Long value) {
        return UpdatableLongMap.of(key, value);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return UpdatableLongMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return UpdatableLongMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return UpdatableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return UpdatableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableLongMap<String> map123 = createLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertEquals(1L, map123.update("one", LONG_FOUR));
        assertEquals(LONG_FOUR, map123.get("one"));
    }
}
