package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableSortedLongMap} class.
 */

public final class ModifiableSortedLongMapTest extends UpdatableLongMapTestBase<ModifiableSortedLongMap<String>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;
    /**
     * The long four.
     */
    private static final Long LONG_FOUR = 4L;
    /**
     * An entry for one.
     */
    private static final Entry<String, Long> ENTRY1 = new Entry<String, Long>("one", 1L);
    /**
     * An entry for two.
     */
    private static final Entry<String, Long> ENTRY2 = new Entry<String, Long>("two", 2L);
    /**
     * An entry for three.
     */
    private static final Entry<String, Long> ENTRY3 = new Entry<String, Long>("three", LONG_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, Long> ENTRY4 = new Entry<String, Long>("four", LONG_FOUR);

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return ModifiableSortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final String key, final Long value) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3, final String key4,
            final Long value4) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3, final String key4,
            final Long value4, final String key5, final Long value5) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedLongMap<String> createEmptyLongMap() {
        return ModifiableSortedLongMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedLongMap<String> createUpdatableLongMap(final Long defaultValue,
            final String... keys) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedLongMap<String> createUpdatableLongMap(final Entry<String, Long>... entries) {
        return ModifiableSortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedLongMap<String> createUpdatableLongMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Long defaultValue, final String... keys) {
        return ModifiableSortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a longs map with three entries.
     *
     * @return A longs map with three entries.
     */
    private ModifiableSortedLongMap<String> createLongMap123() {
        return createLongMap("one", 1L, "two", 2L, "three", LONG_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableLongMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableLongMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", LONG_FOUR));
        assertEquals(LONG_FOUR, map123.get("four"));
        assertFalse(map123.add("four", LONG_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createLongMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createLongMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Long>("three", 3L), createLongMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createLongMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createLongMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createLongMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createLongMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createLongMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createLongMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createLongMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createLongMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createLongMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createLongMap123().getLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1L, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", 2L));
        assertTrue(map123.remove("one", 1L));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createLongMap(ENTRY3)));
        assertFalse(map123.removeAll(createLongMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY2, map123.removeGreatest());
        assertFalse(map123.containsKey("two"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>removeLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeLeastShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY1, map123.removeLeast());
        assertFalse(map123.containsKey("one"));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedLongMap<String> map123 = createUpdatableLongMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableLongMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableLongMap(ENTRY3)));
    }
}
