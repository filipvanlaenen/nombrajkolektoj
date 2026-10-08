package net.filipvanlaenen.nombrajkolektoj.integers;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
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
    /**
     * An entry for one.
     */
    private static final Entry<String, Integer> ENTRY1 = new Entry<String, Integer>("one", 1);
    /**
     * An entry for two.
     */
    private static final Entry<String, Integer> ENTRY2 = new Entry<String, Integer>("two", 2);
    /**
     * An entry for three.
     */
    private static final Entry<String, Integer> ENTRY3 = new Entry<String, Integer>("three", INTEGER_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, Integer> ENTRY4 = new Entry<String, Integer>("four", INTEGER_FOUR);
    /**
     * Map with the integers 1 and 2.
     */
    private final ModifiableIntegerMap<String> map12 = ModifiableIntegerMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the integers 1, 2 and 3.
     */
    private final ModifiableIntegerMap<String> map123 = ModifiableIntegerMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ModifiableIntegerMap<String> createEmptyIntegerMap() {
        return ModifiableIntegerMap.<String>empty();
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final ModifiableIntegerMap<String> map) {
        return ModifiableIntegerMap.of(map);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ModifiableIntegerMap<String> map) {
        return ModifiableIntegerMap.of(keyAndValueCardinality, map);
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
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final Integer defaultValue,
            final Collection<String> keys) {
        return ModifiableIntegerMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final Integer defaultValue, final String... keys) {
        return ModifiableIntegerMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableIntegerMap.of(entries);
    }

    @Override
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Integer defaultValue, final Collection<String> keys) {
        return ModifiableIntegerMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableIntegerMap<String> createUpdatableIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Integer defaultValue, final String... keys) {
        return ModifiableIntegerMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.add("four", INTEGER_FOUR));
        assertEquals(INTEGER_FOUR, map.get("four"));
        assertFalse(map.add("four", INTEGER_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.addAll(createUpdatableIntegerMap(ENTRY4)));
        assertFalse(map.addAll(createUpdatableIntegerMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableIntegerMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ModifiableIntegerMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(IntegerMap.of(ENTRY3)
                .containsSame(ModifiableIntegerMap.differenceOf(map123, IntegerMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableIntegerMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ModifiableIntegerMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(
                map12.containsSame(ModifiableIntegerMap.intersectionOf(IntegerMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1, map.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map.remove("one", 2));
        assertTrue(map.remove("one", 1));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeAll(createIntegerMap(ENTRY3)));
        assertFalse(map.removeAll(createIntegerMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeIf(x -> x.key().equals("one")));
        assertFalse(map.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableIntegerMap<String> map = createUpdatableIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.retainAll(createUpdatableIntegerMap(ENTRY3)));
        assertFalse(map.retainAll(createUpdatableIntegerMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ModifiableIntegerMap<String> map23 = createIntegerMap(ENTRY2, ENTRY3);
        ModifiableIntegerMap<String> actual = ModifiableIntegerMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createIntegerMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ModifiableIntegerMap<String> map23 = createIntegerMap(ENTRY2, ENTRY3);
        ModifiableIntegerMap<String> actual =
                ModifiableIntegerMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ModifiableIntegerMap<String> expected =
                createIntegerMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
