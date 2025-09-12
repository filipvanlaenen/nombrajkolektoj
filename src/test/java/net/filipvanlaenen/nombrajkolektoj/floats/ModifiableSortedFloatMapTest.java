package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableSortedFloatMap} class.
 */

public final class ModifiableSortedFloatMapTest extends UpdatableFloatMapTestBase<ModifiableSortedFloatMap<String>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return ModifiableSortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final String key, final Float value) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3, final String key4,
            final Float value4) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3, final String key4,
            final Float value4, final String key5, final Float value5) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createEmptyFloatMap() {
        return ModifiableSortedFloatMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedFloatMap<String> createUpdatableFloatMap(final Float defaultValue,
            final String... keys) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return ModifiableSortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedFloatMap<String> createUpdatableFloatMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue, String... keys) {
        return ModifiableSortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a floats map with three entries.
     *
     * @return A floats map with three entries.
     */
    private ModifiableSortedFloatMap<String> createFloatMap123() {
        return createFloatMap("one", 1F, "two", 2F, "three", FLOAT_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        assertTrue(map123.addAll(createUpdatableFloatMap(new Entry<String, Float>("four", FLOAT_FOUR))));
        assertFalse(map123.addAll(createUpdatableFloatMap(new Entry<String, Float>("four", FLOAT_FOUR))));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        assertTrue(map123.add("four", FLOAT_FOUR));
        assertEquals(FLOAT_FOUR, map123.get("four"));
        assertFalse(map123.add("four", FLOAT_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createFloatMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("two", 2F), createFloatMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createFloatMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("one", 1F), createFloatMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createFloatMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        assertEquals(1F, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(new Entry<String, Float>("one", 1F),
                new Entry<String, Float>("two", 2F), new Entry<String, Float>("three", FLOAT_THREE));
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }
}
