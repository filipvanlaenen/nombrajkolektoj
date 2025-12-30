package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.UpdatableSortedFloatMap} class.
 */
public final class UpdatableSortedFloatMapTest extends UpdatableFloatMapTestBase<UpdatableSortedFloatMap<String>> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;

    @Override
    protected UpdatableSortedFloatMap<String> createEmptyFloatMap() {
        return UpdatableSortedFloatMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final Entry<String, Float>... entries) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Float>... entries) {
        return UpdatableSortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key, final Float value) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3, final String key4,
            final Float value4) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createFloatMap(final String key1, final Float value1,
            final String key2, final Float value2, final String key3, final Float value3, final String key4,
            final Float value4, final String key5, final Float value5) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createUpdatableFloatMap(final Entry<String, Float>... entries) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createUpdatableFloatMap(final Float defaultValue,
            final String... keys) {
        return UpdatableSortedFloatMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedFloatMap<String> createUpdatableFloatMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Float defaultValue, final String... keys) {
        return UpdatableSortedFloatMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a floats map with three entries.
     *
     * @return A floats map with three entries.
     */
    private UpdatableSortedFloatMap<String> createFloatMap123() {
        return createFloatMap("one", 1F, "two", 2F, "three", FLOAT_THREE);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createFloatMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createFloatMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("three", FLOAT_THREE),
                createFloatMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("two", 2F), createFloatMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createFloatMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createFloatMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createFloatMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createFloatMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createFloatMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Float>("one", 1F), createFloatMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createFloatMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createFloatMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createFloatMap123().getLessThanOrEqualTo("three"));
    }
}
