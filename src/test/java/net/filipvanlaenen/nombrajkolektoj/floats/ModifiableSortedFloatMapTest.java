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
    protected ModifiableSortedFloatMap<String> createFloatMap(ModifiableSortedFloatMap<String> map) {
        return ModifiableSortedFloatMap.of(map);
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
            final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue, final String... keys) {
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
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableFloatMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableFloatMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", FLOAT_FOUR));
        assertEquals(FLOAT_FOUR, map123.get("four"));
        assertFalse(map123.add("four", FLOAT_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
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
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createFloatMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("three", FLOAT_THREE),
                createFloatMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createFloatMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createFloatMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createFloatMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createFloatMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createFloatMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createFloatMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createFloatMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createFloatMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createFloatMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createFloatMap123().getLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1F, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", 2F));
        assertTrue(map123.remove("one", 1F));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createFloatMap(ENTRY3)));
        assertFalse(map123.removeAll(createFloatMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY2, map123.removeGreatest());
        assertFalse(map123.containsKey("two"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>removeLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeLeastShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY1, map123.removeLeast());
        assertFalse(map123.containsKey("one"));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedFloatMap<String> map123 = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableFloatMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableFloatMap(ENTRY3)));
    }
}
