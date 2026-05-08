package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableByteMap} class.
 */
public final class UpdatableByteMapTest extends UpdatableByteMapTestBase<UpdatableByteMap<String>> {
    @Override
    protected UpdatableByteMap<String> createEmptyByteMap() {
        return UpdatableByteMap.<String>empty();
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final UpdatableByteMap<String> map) {
        return UpdatableByteMap.of(map);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return UpdatableByteMap.of(entries);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return UpdatableByteMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final UpdatableByteMap<String> map) {
        return UpdatableByteMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key, final Byte value) {
        return UpdatableByteMap.of(key, value);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return UpdatableByteMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return UpdatableByteMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return UpdatableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return UpdatableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return UpdatableByteMap.of(entries);
    }

    @Override
    protected UpdatableByteMap<String> createUpdatableByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Byte defaultValue, final Collection<String> keys) {
        return UpdatableByteMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableByteMap<String> createUpdatableByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Byte defaultValue, final String... keys) {
        return UpdatableByteMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableByteMap<String> createUpdatableByteMap(final Byte defaultValue,
            final Collection<String> keys) {
        return UpdatableByteMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableByteMap<String> createUpdatableByteMap(final Byte defaultValue, final String... keys) {
        return UpdatableByteMap.of(defaultValue, keys);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        UpdatableByteMap<String> map12 = createByteMap(ENTRY1, ENTRY2);
        UpdatableByteMap<String> map23 = createByteMap(ENTRY2, ENTRY3);
        UpdatableByteMap<String> actual = UpdatableByteMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createByteMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        UpdatableByteMap<String> map12 = createByteMap(ENTRY1, ENTRY2);
        UpdatableByteMap<String> map23 = createByteMap(ENTRY2, ENTRY3);
        UpdatableByteMap<String> actual =
                UpdatableByteMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        UpdatableByteMap<String> expected =
                createByteMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
