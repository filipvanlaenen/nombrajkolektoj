package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.SortedByteMap} class.
 */
public final class SortedByteMapTest extends ByteMapTestBase<SortedByteMap<String>> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;

    @Override
    protected SortedByteMap<String> createEmptyByteMap() {
        return SortedByteMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return SortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return SortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key, final Byte value) {
        return SortedByteMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return SortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }

    /**
     * Creates a bytes map with three entries.
     *
     * @return A bytes map with three entries.
     */
    private SortedByteMap<String> createByteMap123() {
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
}
