package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleMap} class.
 */
public final class ModifiableDoubleMapTest extends UpdatableDoubleMapTestBase<ModifiableDoubleMap<String>> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;

    @Override
    protected ModifiableDoubleMap<String> createEmptyDoubleMap() {
        return ModifiableDoubleMap.<String>empty();
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return ModifiableDoubleMap.of(key, value);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map123 = createUpdatableDoubleMap(new Entry<String, Double>("one", 1D),
                new Entry<String, Double>("two", 2D), new Entry<String, Double>("three", DOUBLE_THREE));
        assertTrue(map123.add("four", DOUBLE_FOUR));
        assertEquals(DOUBLE_FOUR, map123.get("four"));
        assertFalse(map123.add("four", DOUBLE_FOUR));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map123 = createUpdatableDoubleMap(new Entry<String, Double>("one", 1D),
                new Entry<String, Double>("two", 2D), new Entry<String, Double>("three", DOUBLE_THREE));
        assertEquals(1D, map123.remove("one"));
    }
}
