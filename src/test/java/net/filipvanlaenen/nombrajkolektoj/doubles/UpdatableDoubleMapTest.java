package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableDoubleMap} class.
 */
public final class UpdatableDoubleMapTest extends UpdatableDoubleMapTestBase<UpdatableDoubleMap<String>> {
    @Override
    protected UpdatableDoubleMap<String> createEmptyDoubleMap() {
        return UpdatableDoubleMap.<String>empty();
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final UpdatableDoubleMap<String> map) {
        return UpdatableDoubleMap.of(map);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableDoubleMap.of(entries);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return UpdatableDoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final UpdatableDoubleMap<String> map) {
        return UpdatableDoubleMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return UpdatableDoubleMap.of(key, value);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected UpdatableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return UpdatableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableDoubleMap.of(entries);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Double defaultValue, final Collection<String> keys) {
        return UpdatableDoubleMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Double defaultValue, final String... keys) {
        return UpdatableDoubleMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue,
            final Collection<String> keys) {
        return UpdatableDoubleMap.of(defaultValue, keys);
    }

    @Override
    protected UpdatableDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue, final String... keys) {
        return UpdatableDoubleMap.of(defaultValue, keys);
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        UpdatableDoubleMap<String> map12 = createDoubleMap(ENTRY1, ENTRY2);
        UpdatableDoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        UpdatableDoubleMap<String> actual = UpdatableDoubleMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createDoubleMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        UpdatableDoubleMap<String> map12 = createDoubleMap(ENTRY1, ENTRY2);
        UpdatableDoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        UpdatableDoubleMap<String> actual =
                UpdatableDoubleMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        UpdatableDoubleMap<String> expected =
                createDoubleMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
