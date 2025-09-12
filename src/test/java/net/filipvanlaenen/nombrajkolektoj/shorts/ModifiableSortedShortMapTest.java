package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableSortedShortMap} class.
 */

public final class ModifiableSortedShortMapTest extends UpdatableShortMapTestBase<ModifiableSortedShortMap<String>> {
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
    protected ModifiableSortedShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return ModifiableSortedShortMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedShortMap<String> createShortMap(final String key, final Short value) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3, final String key4,
            final Short value4) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3, final String key4,
            final Short value4, final String key5, final Short value5) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedShortMap<String> createEmptyShortMap() {
        return ModifiableSortedShortMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedShortMap<String> createUpdatableShortMap(final Short defaultValue,
            final String... keys) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return ModifiableSortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedShortMap<String> createUpdatableShortMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Short defaultValue, final String... keys) {
        return ModifiableSortedShortMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a shorts map with three entries.
     *
     * @return A shorts map with three entries.
     */
    private ModifiableSortedShortMap<String> createShortMap123() {
        return createShortMap("one", (short) 1, "two", (short) 2, "three", SHORT_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableShortMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableShortMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", SHORT_FOUR));
        assertEquals(SHORT_FOUR, map123.get("four"));
        assertFalse(map123.add("four", SHORT_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createShortMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createShortMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createShortMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createShortMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createShortMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals((short) 1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createShortMap(ENTRY3)));
        assertFalse(map123.removeAll(createShortMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY2, map123.removeGreatest());
        assertFalse(map123.containsKey("two"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>removeLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeLeastShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY1, map123.removeLeast());
        assertFalse(map123.containsKey("one"));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedShortMap<String> map123 = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableShortMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableShortMap(ENTRY3)));
    }
}
