package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleMap} class.
 */
public final class ModifiableDoubleMapTest extends UpdatableDoubleMapTestBase<ModifiableDoubleMap<String>> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;
    /**
     * An entry for one.
     */
    private static final Entry<String, Double> ENTRY1 = new Entry<String, Double>("one", 1D);
    /**
     * An entry for two.
     */
    private static final Entry<String, Double> ENTRY2 = new Entry<String, Double>("two", 2D);
    /**
     * An entry for three.
     */
    private static final Entry<String, Double> ENTRY3 = new Entry<String, Double>("three", DOUBLE_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, Double> ENTRY4 = new Entry<String, Double>("four", DOUBLE_FOUR);
    /**
     * Map with the doubles 1 and 2.
     */
    private final ModifiableDoubleMap<String> map12 = ModifiableDoubleMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the doubles 1, 2 and 3.
     */
    private final ModifiableDoubleMap<String> map123 = ModifiableDoubleMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ModifiableDoubleMap<String> createEmptyDoubleMap() {
        return ModifiableDoubleMap.<String>empty();
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final ModifiableDoubleMap<String> map) {
        return ModifiableDoubleMap.of(map);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ModifiableDoubleMap<String> map) {
        return ModifiableDoubleMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return ModifiableDoubleMap.of(key, value);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableDoubleMap<String> createDoubleMap(final String key1, final Double value1, final String key2,
            final Double value2, final String key3, final Double value3, final String key4, final Double value4,
            final String key5, final Double value5) {
        return ModifiableDoubleMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue,
            final Collection<String> keys) {
        return ModifiableDoubleMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue, final String... keys) {
        return ModifiableDoubleMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableDoubleMap.of(entries);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Double defaultValue, final Collection<String> keys) {
        return ModifiableDoubleMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableDoubleMap<String> createUpdatableDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Double defaultValue, final String... keys) {
        return ModifiableDoubleMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.add("four", DOUBLE_FOUR));
        assertEquals(DOUBLE_FOUR, map.get("four"));
        assertFalse(map.add("four", DOUBLE_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.addAll(createUpdatableDoubleMap(ENTRY4)));
        assertFalse(map.addAll(createUpdatableDoubleMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableDoubleMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ModifiableDoubleMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(DoubleMap.of(ENTRY3)
                .containsSame(ModifiableDoubleMap.differenceOf(map123, DoubleMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableDoubleMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ModifiableDoubleMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(
                map12.containsSame(ModifiableDoubleMap.intersectionOf(DoubleMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1D, map.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map.remove("one", 2D));
        assertTrue(map.remove("one", 1D));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeAll(createDoubleMap(ENTRY3)));
        assertFalse(map.removeAll(createDoubleMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeIf(x -> x.key().equals("one")));
        assertFalse(map.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableDoubleMap<String> map = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.retainAll(createUpdatableDoubleMap(ENTRY3)));
        assertFalse(map.retainAll(createUpdatableDoubleMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ModifiableDoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        ModifiableDoubleMap<String> actual = ModifiableDoubleMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createDoubleMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ModifiableDoubleMap<String> map23 = createDoubleMap(ENTRY2, ENTRY3);
        ModifiableDoubleMap<String> actual =
                ModifiableDoubleMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ModifiableDoubleMap<String> expected =
                createDoubleMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
