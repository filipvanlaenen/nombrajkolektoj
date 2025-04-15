package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableIntegerMap} class.
 */
public final class ModifiableIntegerMapTest extends UpdatableIntegerMapTestBase<ModifiableIntegerMap<String>> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;

    @Override
    protected ModifiableIntegerMap<String> createEmptyIntegerMap() {
        return ModifiableIntegerMap.<String>empty();
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return ModifiableIntegerMap.of(key, value);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final String key1, final Integer value1, final String key2,
            final Integer value2, final String key3, final Integer value3, final String key4, final Integer value4,
            final String key5, final Integer value5) {
        return ModifiableIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertTrue(map123.add("four", INTEGER_FOUR));
        assertEquals(INTEGER_FOUR, map123.get("four"));
        assertFalse(map123.add("four", INTEGER_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertTrue(map123.addAll(createUpdatableIntegerMap(new Entry<String, Integer>("four", INTEGER_FOUR))));
        assertFalse(map123.addAll(createUpdatableIntegerMap(new Entry<String, Integer>("four", INTEGER_FOUR))));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertEquals(1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertTrue(map123.removeAll(createUpdatableIntegerMap(new Entry<String, Integer>("three", INTEGER_THREE))));
        assertFalse(map123.removeAll(createUpdatableIntegerMap(new Entry<String, Integer>("three", INTEGER_THREE))));
    }
}
