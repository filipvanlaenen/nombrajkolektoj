package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortMap} class.
 */
public final class ModifiableShortMapTest extends UpdatableShortMapTestBase<ModifiableShortMap<String>> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;
    /**
     * The short four.
     */
    private static final Short SHORT_FOUR = (short) 4;

    @Override
    protected ModifiableShortMap<String> createEmptyShortMap() {
        return ModifiableShortMap.<String>empty();
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(entries);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key, final Short value) {
        return ModifiableShortMap.of(key, value);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2) {
        return ModifiableShortMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3) {
        return ModifiableShortMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4) {
        return ModifiableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final String key1, final Short value1, final String key2,
            final Short value2, final String key3, final Short value3, final String key4, final Short value4,
            final String key5, final Short value5) {
        return ModifiableShortMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        assertTrue(map123.add("four", SHORT_FOUR));
        assertEquals(SHORT_FOUR, map123.get("four"));
        assertFalse(map123.add("four", SHORT_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        assertTrue(map123.addAll(createUpdatableShortMap(new Entry<String, Short>("four", SHORT_FOUR))));
        assertFalse(map123.addAll(createUpdatableShortMap(new Entry<String, Short>("four", SHORT_FOUR))));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        assertEquals((short) 1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(new Entry<String, Short>("one", (short) 1),
                new Entry<String, Short>("two", (short) 2), new Entry<String, Short>("three", SHORT_THREE));
        assertTrue(map123.removeAll(createUpdatableShortMap(new Entry<String, Short>("three", SHORT_THREE))));
        assertFalse(map123.removeAll(createUpdatableShortMap(new Entry<String, Short>("three", SHORT_THREE))));
    }
}
