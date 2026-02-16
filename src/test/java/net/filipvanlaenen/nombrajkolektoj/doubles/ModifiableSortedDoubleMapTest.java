package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableSortedDoubleMap} class.
 */

public final class ModifiableSortedDoubleMapTest extends UpdatableDoubleMapTestBase<ModifiableSortedDoubleMap<String>> {
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

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return ModifiableSortedDoubleMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3, final String key4,
            final Double value4) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3, final String key4,
            final Double value4, final String key5, final Double value5) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createEmptyDoubleMap() {
        return ModifiableSortedDoubleMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createDoubleMap(ModifiableSortedDoubleMap<String> map) {
        return ModifiableSortedDoubleMap.of(map);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue,
            final String... keys) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return ModifiableSortedDoubleMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedDoubleMap<String> createUpdatableDoubleMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Double defaultValue, final String... keys) {
        return ModifiableSortedDoubleMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a doubles map with three entries.
     *
     * @return A doubles map with three entries.
     */
    private ModifiableSortedDoubleMap<String> createDoubleMap123() {
        return createDoubleMap("one", 1D, "two", 2D, "three", DOUBLE_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableDoubleMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableDoubleMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", DOUBLE_FOUR));
        assertEquals(DOUBLE_FOUR, map123.get("four"));
        assertFalse(map123.add("four", DOUBLE_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createDoubleMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createDoubleMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Double>("three", DOUBLE_THREE),
                createDoubleMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createDoubleMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createDoubleMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createDoubleMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createDoubleMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createDoubleMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createDoubleMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createDoubleMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createDoubleMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createDoubleMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createDoubleMap123().getLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(1D, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", 2D));
        assertTrue(map123.remove("one", 1D));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createDoubleMap(ENTRY3)));
        assertFalse(map123.removeAll(createDoubleMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY2, map123.removeGreatest());
        assertFalse(map123.containsKey("two"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>removeLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeLeastShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY1, map123.removeLeast());
        assertFalse(map123.containsKey("one"));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedDoubleMap<String> map123 = createUpdatableDoubleMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableDoubleMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableDoubleMap(ENTRY3)));
    }
}
