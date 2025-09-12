package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.ModifiableSortedIntegerMap} class.
 */

public final class ModifiableSortedIntegerMapTest extends UpdatableIntegerMapTestBase<ModifiableSortedIntegerMap<String>> {
    /**
     * The int three.
     */
    private static final Integer INTEGER_THREE = 3;
    /**
     * The int four.
     */
    private static final Integer INTEGER_FOUR = 4;

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Integer>... entries) {
        return ModifiableSortedIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final String key, final Integer value) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2, final String key3, final Integer value3) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2, final String key3, final Integer value3, final String key4,
            final Integer value4) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createIntegerMap(final String key1, final Integer value1,
            final String key2, final Integer value2, final String key3, final Integer value3, final String key4,
            final Integer value4, final String key5, final Integer value5) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createEmptyIntegerMap() {
        return ModifiableSortedIntegerMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createUpdatableIntegerMap(final Integer defaultValue,
            final String... keys) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createUpdatableIntegerMap(final Entry<String, Integer>... entries) {
        return ModifiableSortedIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedIntegerMap<String> createUpdatableIntegerMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Integer defaultValue, String... keys) {
        return ModifiableSortedIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a integers map with three entries.
     *
     * @return A integers map with three entries.
     */
    private ModifiableSortedIntegerMap<String> createIntegerMap123() {
        return createIntegerMap("one", 1, "two", 2, "three", INTEGER_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertTrue(map123.addAll(createUpdatableIntegerMap(new Entry<String, Integer>("four", INTEGER_FOUR))));
        assertFalse(map123.addAll(createUpdatableIntegerMap(new Entry<String, Integer>("four", INTEGER_FOUR))));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertTrue(map123.add("four", INTEGER_FOUR));
        assertEquals(INTEGER_FOUR, map123.get("four"));
        assertFalse(map123.add("four", INTEGER_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createIntegerMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Integer>("two", 2), createIntegerMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createIntegerMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Integer>("one", 1), createIntegerMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createIntegerMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertEquals(1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedIntegerMap<String> map123 = createUpdatableIntegerMap(new Entry<String, Integer>("one", 1),
                new Entry<String, Integer>("two", 2), new Entry<String, Integer>("three", INTEGER_THREE));
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }
}
