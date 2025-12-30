package net.filipvanlaenen.nombrajkolektoj.longs;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.UpdatableSortedLongMap} class.
 */
public final class UpdatableSortedLongMapTest extends UpdatableLongMapTestBase<UpdatableSortedLongMap<String>> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    @Override
    protected UpdatableSortedLongMap<String> createEmptyLongMap() {
        return UpdatableSortedLongMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final Entry<String, Long>... entries) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Long>... entries) {
        return UpdatableSortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key, final Long value) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3, final String key4,
            final Long value4) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedLongMap<String> createLongMap(final String key1, final Long value1,
            final String key2, final Long value2, final String key3, final Long value3, final String key4,
            final Long value4, final String key5, final Long value5) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedLongMap<String> createUpdatableLongMap(final Entry<String, Long>... entries) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedLongMap<String> createUpdatableLongMap(final Long defaultValue,
            final String... keys) {
        return UpdatableSortedLongMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedLongMap<String> createUpdatableLongMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Long defaultValue, final String... keys) {
        return UpdatableSortedLongMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a longs map with three entries.
     *
     * @return A longs map with three entries.
     */
    private UpdatableSortedLongMap<String> createLongMap123() {
        return createLongMap("one", 1L, "two", 2L, "three", LONG_THREE);
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
        assertEquals(new Entry<String, Long>("three", LONG_THREE),
                createLongMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Long>("two", 2L), createLongMap123().getGreatest());
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
        assertEquals(new Entry<String, Long>("one", 1L), createLongMap123().getLeast());
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
}
