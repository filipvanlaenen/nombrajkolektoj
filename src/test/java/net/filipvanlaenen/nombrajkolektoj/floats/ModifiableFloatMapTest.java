package net.filipvanlaenen.nombrajkolektoj.floats;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatMap} class.
 */
public final class ModifiableFloatMapTest extends UpdatableFloatMapTestBase<ModifiableFloatMap<String>> {
    @Override
    protected ModifiableFloatMap<String> createEmptyFloatMap() {
        return ModifiableFloatMap.<String>empty();
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(entries);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final String key, final Float value) {
        return ModifiableFloatMap.of(key, value);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2) {
        return ModifiableFloatMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3) {
        return ModifiableFloatMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4) {
        return ModifiableFloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final String key1, final Float value1, final String key2,
            final Float value2, final String key3, final Float value3, final String key4, final Float value4,
            final String key5, final Float value5) {
        return ModifiableFloatMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(entries);
    }
}
