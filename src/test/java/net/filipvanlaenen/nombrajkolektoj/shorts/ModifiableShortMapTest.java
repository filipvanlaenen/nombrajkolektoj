package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
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
    /**
     * Map with the shorts 1 and 2.
     */
    private final ModifiableShortMap<String> map12 = ModifiableShortMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the shorts 1, 2 and 3.
     */
    private final ModifiableShortMap<String> map123 = ModifiableShortMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ModifiableShortMap<String> createEmptyShortMap() {
        return ModifiableShortMap.<String>empty();
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(entries);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final ModifiableShortMap<String> map) {
        return ModifiableShortMap.of(map);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ModifiableShortMap<String> map) {
        return ModifiableShortMap.of(keyAndValueCardinality, map);
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
    protected ModifiableShortMap<String> createUpdatableShortMap(final Short defaultValue,
            final Collection<String> keys) {
        return ModifiableShortMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final Short defaultValue, final String... keys) {
        return ModifiableShortMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return ModifiableShortMap.of(entries);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Short defaultValue, final Collection<String> keys) {
        return ModifiableShortMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableShortMap<String> createUpdatableShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Short defaultValue, final String... keys) {
        return ModifiableShortMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.add("four", SHORT_FOUR));
        assertEquals(SHORT_FOUR, map.get("four"));
        assertFalse(map.add("four", SHORT_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.addAll(createUpdatableShortMap(ENTRY4)));
        assertFalse(map.addAll(createUpdatableShortMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableShortMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ModifiableShortMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(ShortMap.of(ENTRY3)
                .containsSame(ModifiableShortMap.differenceOf(map123, ShortMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableShortMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ModifiableShortMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(
                map12.containsSame(ModifiableShortMap.intersectionOf(ShortMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals((short) 1, map.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map.remove("one", (short) 2));
        assertTrue(map.remove("one", (short) 1));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeAll(createShortMap(ENTRY3)));
        assertFalse(map.removeAll(createShortMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeIf(x -> x.key().equals("one")));
        assertFalse(map.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableShortMap<String> map = createUpdatableShortMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.retainAll(createUpdatableShortMap(ENTRY3)));
        assertFalse(map.retainAll(createUpdatableShortMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ModifiableShortMap<String> map23 = createShortMap(ENTRY2, ENTRY3);
        ModifiableShortMap<String> actual = ModifiableShortMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createShortMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ModifiableShortMap<String> map23 = createShortMap(ENTRY2, ENTRY3);
        ModifiableShortMap<String> actual =
                ModifiableShortMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ModifiableShortMap<String> expected =
                createShortMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
