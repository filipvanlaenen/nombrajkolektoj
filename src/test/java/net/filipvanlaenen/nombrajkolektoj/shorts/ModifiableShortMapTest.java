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
    /**
     * An entry for one.
     */
    private static final Entry<String, Short> ENTRY1 = new Entry<String, Short>("one", (short) 1);
    /**
     * An entry for two.
     */
    private static final Entry<String, Short> ENTRY2 = new Entry<String, Short>("two", (short) 2);
    /**
     * An entry for three.
     */
    private static final Entry<String, Short> ENTRY3 = new Entry<String, Short>("three", SHORT_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, Short> ENTRY4 = new Entry<String, Short>("four", SHORT_FOUR);

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
    protected ModifiableShortMap<String> createUpdatableShortMap(final Short defaultValue, final String... keys) {
        return ModifiableShortMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Short defaultValue, final String... keys) {
        return ModifiableShortMap.of(keyAndValueCardinality, defaultValue, keys);
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
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", SHORT_FOUR));
        assertEquals(SHORT_FOUR, map123.get("four"));
        assertFalse(map123.add("four", SHORT_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableShortMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableShortMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals((short) 1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createShortMap(ENTRY3)));
        assertFalse(map123.removeAll(createShortMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableShortMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableShortMap(ENTRY3)));
    }
}
