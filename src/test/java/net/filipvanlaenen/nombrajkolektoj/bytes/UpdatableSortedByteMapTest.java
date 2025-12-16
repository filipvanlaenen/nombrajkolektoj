package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.UpdatableSortedByteMap} class.
 */
public final class UpdatableSortedByteMapTest extends UpdatableByteMapTestBase<UpdatableSortedByteMap<String>> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;

    @Override
    protected UpdatableSortedByteMap<String> createEmptyByteMap() {
        return UpdatableSortedByteMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return UpdatableSortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key, final Byte value) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3, final String key4,
            final Byte value4) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3, final String key4,
            final Byte value4, final String key5, final Byte value5) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedByteMap<String> createUpdatableByteMap(final Byte defaultValue,
            final String... keys) {
        return UpdatableSortedByteMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedByteMap<String> createUpdatableByteMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Byte defaultValue, final String... keys) {
        return UpdatableSortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a bytes map with three entries.
     *
     * @return A bytes map with three entries.
     */
    private UpdatableSortedByteMap<String> createByteMap123() {
        return createByteMap("one", (byte) 1, "two", (byte) 2, "three", BYTE_THREE);
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createByteMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createByteMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Byte>("three", (byte) 3), createByteMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Byte>("two", (byte) 2), createByteMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createByteMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createByteMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createByteMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createByteMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createByteMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, Byte>("one", (byte) 1), createByteMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createByteMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createByteMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createByteMap123().getLessThanOrEqualTo("three"));
    }
}
