package net.filipvanlaenen.nombrajkolektoj.floats;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
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
    /**
     * Map with the floats 1 and 2.
     */
    private final ModifiableFloatMap<String> map12 = ModifiableFloatMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the floats 1, 2 and 3.
     */
    private final ModifiableFloatMap<String> map123 = ModifiableFloatMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ModifiableFloatMap<String> createEmptyFloatMap() {
        return ModifiableFloatMap.<String>empty();
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(entries);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final ModifiableFloatMap<String> map) {
        return ModifiableFloatMap.of(map);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ModifiableFloatMap<String> map) {
        return ModifiableFloatMap.of(keyAndValueCardinality, map);
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
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final Float defaultValue,
            final Collection<String> keys) {
        return ModifiableFloatMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final Float defaultValue, final String... keys) {
        return ModifiableFloatMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return ModifiableFloatMap.of(entries);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Float defaultValue, final Collection<String> keys) {
        return ModifiableFloatMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableFloatMap<String> createUpdatableFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Float defaultValue, final String... keys) {
        return ModifiableFloatMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.add("four", FLOAT_FOUR));
        assertEquals(FLOAT_FOUR, map.get("four"));
        assertFalse(map.add("four", FLOAT_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.addAll(createUpdatableFloatMap(ENTRY4)));
        assertFalse(map.addAll(createUpdatableFloatMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableFloatMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ModifiableFloatMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(FloatMap.of(ENTRY3)
                .containsSame(ModifiableFloatMap.differenceOf(map123, FloatMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableFloatMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ModifiableFloatMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(
                map12.containsSame(ModifiableFloatMap.intersectionOf(FloatMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1F, map.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map.remove("one", 2F));
        assertTrue(map.remove("one", 1F));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeAll(createFloatMap(ENTRY3)));
        assertFalse(map.removeAll(createFloatMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeIf(x -> x.key().equals("one")));
        assertFalse(map.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableFloatMap<String> map = createUpdatableFloatMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.retainAll(createUpdatableFloatMap(ENTRY3)));
        assertFalse(map.retainAll(createUpdatableFloatMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ModifiableFloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        ModifiableFloatMap<String> actual = ModifiableFloatMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createFloatMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ModifiableFloatMap<String> map23 = createFloatMap(ENTRY2, ENTRY3);
        ModifiableFloatMap<String> actual =
                ModifiableFloatMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ModifiableFloatMap<String> expected =
                createFloatMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
