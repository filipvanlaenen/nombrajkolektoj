package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} class.
 */
public final class UpdatableFloatMapTest extends FloatMapTestBase<UpdatableFloatMap<String>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;

    @Override
    protected UpdatableFloatMap<String> createEmptyFloatMap() {
        return UpdatableFloatMap.<String>empty();
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return UpdatableFloatMap.of(entries);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return UpdatableFloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key, final Float value) {
        return UpdatableFloatMap.of(key, value);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return UpdatableFloatMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return UpdatableFloatMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return UpdatableFloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return UpdatableFloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the <code>update</code> method is wired correctly to the internal collection.
     */
    @Test
    public void updateShouldBeWiredCorrectlyToTheInternalMap() {
        UpdatableFloatMap<String> map123 = createFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        assertEquals(1F, map123.update("one", FLOAT_FOUR));
        assertEquals(FLOAT_FOUR, map123.get("one"));
    }
}
