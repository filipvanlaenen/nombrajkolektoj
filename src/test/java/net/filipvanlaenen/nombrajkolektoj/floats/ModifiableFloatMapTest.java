package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatMap} class.
 */
public final class ModifiableFloatMapTest extends UpdatableFloatMapTestBase<ModifiableFloatMap<String>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * An entry for one.
     */
    private static final Entry<String, Float> ENTRY1 = new Entry<String, Float>("one", 1F);
    /**
     * An entry for two.
     */
    private static final Entry<String, Float> ENTRY2 = new Entry<String, Float>("two", 2F);
    /**
     * An entry for three.
     */
    private static final Entry<String, Float> ENTRY3 = new Entry<String, Float>("three", FLOAT_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, Float> ENTRY4 = new Entry<String, Float>("four", FLOAT_FOUR);

    @Override
    protected ModifiableFloatMap<String> createEmptyFloatMap() {
        return ModifiableFloatMap.<String>empty();
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(entries);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(ModifiableFloatMap<String> map) {
        return ModifiableFloatMap.of(map);
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
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final Float defaultValue, final String... keys) {
        return ModifiableFloatMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Float defaultValue, final String... keys) {
        return ModifiableFloatMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", FLOAT_FOUR));
        assertEquals(FLOAT_FOUR, map123.get("four"));
        assertFalse(map123.add("four", FLOAT_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableFloatMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableFloatMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1F, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", 2F));
        assertTrue(map123.remove("one", 1F));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createFloatMap(ENTRY3)));
        assertFalse(map123.removeAll(createFloatMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableFloatMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableFloatMap(ENTRY3)));
    }
}
