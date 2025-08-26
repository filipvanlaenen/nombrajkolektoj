package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongMap} class.
 */
public final class ModifiableLongMapTest extends UpdatableLongMapTestBase<ModifiableLongMap<String>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;

    @Override
    protected ModifiableLongMap<String> createEmptyLongMap() {
        return ModifiableLongMap.<String>empty();
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return ModifiableLongMap.of(entries);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return ModifiableLongMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key, final Long value) {
        return ModifiableLongMap.of(key, value);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2) {
        return ModifiableLongMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3) {
        return ModifiableLongMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4) {
        return ModifiableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableLongMap<String> createLongMap(final String key1, final Long value1, final String key2,
            final Long value2, final String key3, final Long value3, final String key4, final Long value4,
            final String key5, final Long value5) {
        return ModifiableLongMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableLongMap<String> createUpdatableLongMap(final Long defaultValue, final String... keys) {
        return ModifiableLongMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableLongMap<String> createUpdatableLongMap(final Entry<String, Long>... entries) {
        return ModifiableLongMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertTrue(map123.add("four", LONG_FOUR));
        assertEquals(LONG_FOUR, map123.get("four"));
        assertFalse(map123.add("four", LONG_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertTrue(map123.addAll(createUpdatableLongMap(new Entry<String, Long>("four", LONG_FOUR))));
        assertFalse(map123.addAll(createUpdatableLongMap(new Entry<String, Long>("four", LONG_FOUR))));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertEquals(1L, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertTrue(map123.removeAll(createUpdatableLongMap(new Entry<String, Long>("three", LONG_THREE))));
        assertFalse(map123.removeAll(createUpdatableLongMap(new Entry<String, Long>("three", LONG_THREE))));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableLongMap<String> map123 = createUpdatableLongMap(new Entry<String, Long>("one", 1L),
                new Entry<String, Long>("two", 2L), new Entry<String, Long>("three", LONG_THREE));
        assertTrue(map123.retainAll(createUpdatableLongMap(new Entry<String, Long>("three", LONG_THREE))));
        assertFalse(map123.retainAll(createUpdatableLongMap(new Entry<String, Long>("three", LONG_THREE))));
    }
}
