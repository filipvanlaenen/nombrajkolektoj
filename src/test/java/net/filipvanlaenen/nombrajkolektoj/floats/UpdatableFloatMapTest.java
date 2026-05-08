package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableFloatMap} class.
 */
public final class UpdatableFloatMapTest extends UpdatableFloatMapTestBase<UpdatableFloatMap<String>> {
    @Override
    protected UpdatableFloatMap<String> createEmptyFloatMap() {
        return UpdatableFloatMap.<String>empty();
    }

    @Override
    protected UpdatableFloatMap<String> createFloatMap(final UpdatableFloatMap<String> map) {
        return UpdatableFloatMap.of(map);
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
    protected UpdatableFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final UpdatableFloatMap<String> map) {
        return UpdatableFloatMap.of(keyAndValueCardinality, map);
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

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return UpdatableFloatMap.of(entries);
    }

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Float defaultValue, final Collection<String> keys) {
        return UpdatableFloatMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Float defaultValue, final String... keys) {
        return UpdatableFloatMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final Float defaultValue,
            final Collection<String> keys) {
        return UpdatableFloatMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableFloatMap<String> createUpdatableFloatMap(final Float defaultValue, final String... keys) {
        return UpdatableFloatMap.of(defaultValue, keys);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        UpdatableFloatMap<String> map12 = createFloatMap(ENTRY1, ENTRY2);
        UpdatableFloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        UpdatableFloatMap<String> actual = UpdatableFloatMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createFloatMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        UpdatableFloatMap<String> map12 = createFloatMap(ENTRY1, ENTRY2);
        UpdatableFloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        UpdatableFloatMap<String> actual =
                UpdatableFloatMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        UpdatableFloatMap<String> expected =
                createFloatMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
