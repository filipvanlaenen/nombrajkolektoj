package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.UpdatableSortedShortMap} class.
 */
public final class UpdatableSortedShortMapTest extends UpdatableShortMapTestBase<UpdatableSortedShortMap<String>> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    @Override
    protected UpdatableSortedShortMap<String> createEmptyShortMap() {
        return UpdatableSortedShortMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final Entry<String, Short>... entries) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Short>... entries) {
        return UpdatableSortedShortMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key, final Short value) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3, final String key4,
            final Short value4) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedShortMap<String> createShortMap(final String key1, final Short value1,
            final String key2, final Short value2, final String key3, final Short value3, final String key4,
            final Short value4, final String key5, final Short value5) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedShortMap<String> createUpdatableShortMap(final Entry<String, Short>... entries) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedShortMap<String> createUpdatableShortMap(final Short defaultValue,
            final String... keys) {
        return UpdatableSortedShortMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedShortMap<String> createUpdatableShortMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Short defaultValue, final String... keys) {
        return UpdatableSortedShortMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a shorts map with three entries.
     *
     * @return A shorts map with three entries.
     */
    private UpdatableSortedShortMap<String> createShortMap123() {
        return createShortMap("one", (short) 1, "two", (short) 2, "three", SHORT_THREE);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createShortMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createShortMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Short>("three", (short) 3), createShortMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Short>("two", (short) 2), createShortMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createShortMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createShortMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createShortMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createShortMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createShortMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Short>("one", (short) 1), createShortMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createShortMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createShortMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createShortMap123().getLessThanOrEqualTo("three"));
    }
}
