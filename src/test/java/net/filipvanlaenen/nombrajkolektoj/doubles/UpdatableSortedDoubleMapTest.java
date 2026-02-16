package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.UpdatableSortedDoubleMap} class.
 */
public final class UpdatableSortedDoubleMapTest extends UpdatableDoubleMapTestBase<UpdatableSortedDoubleMap<String>> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;

    @Override
    protected UpdatableSortedDoubleMap<String> createEmptyDoubleMap() {
        return UpdatableSortedDoubleMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(UpdatableSortedDoubleMap<String> map) {
        return UpdatableSortedDoubleMap.of(map);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Double>... entries) {
        return UpdatableSortedDoubleMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key, final Double value) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3, final String key4,
            final Double value4) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createDoubleMap(final String key1, final Double value1,
            final String key2, final Double value2, final String key3, final Double value3, final String key4,
            final Double value4, final String key5, final Double value5) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createUpdatableDoubleMap(final Entry<String, Double>... entries) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createUpdatableDoubleMap(final Double defaultValue,
            final String... keys) {
        return UpdatableSortedDoubleMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedDoubleMap<String> createUpdatableDoubleMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Double defaultValue, final String... keys) {
        return UpdatableSortedDoubleMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a doubles map with three entries.
     *
     * @return A doubles map with three entries.
     */
    private UpdatableSortedDoubleMap<String> createDoubleMap123() {
        return createDoubleMap("one", 1D, "two", 2D, "three", DOUBLE_THREE);
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
        assertEquals(new Entry<String, Double>("two", 2D), createDoubleMap123().getGreatest());
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
        assertEquals(new Entry<String, Double>("one", 1D), createDoubleMap123().getLeast());
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
}
