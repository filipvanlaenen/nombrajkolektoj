package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ByteMap} class.
 */
public final class ByteMapTest extends ByteMapTestBase<ByteMap<String>> {
    /**
     * Map with the bytes 1 and 2.
     */
    private final ByteMap<String> map12 = ByteMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the bytes 1, 2 and 3.
     */
    private final ByteMap<String> map123 = ByteMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ByteMap<String> createEmptyByteMap() {
        return ByteMap.empty();
    }

    @Override
    protected ByteMap<String> createByteMap(final ByteMap<String> map) {
        return ByteMap.of(map);
    }

    @Override
    protected ByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return ByteMap.of(entries);
    }

    @Override
    protected ByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ByteMap<String> map) {
        return ByteMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected ByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return ByteMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key, final Byte value) {
        return ByteMap.of(key, value);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return ByteMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return ByteMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return ByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return ByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ByteMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ByteMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(ByteMap.of(ENTRY3).containsSame(ByteMap.differenceOf(map123, ByteMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ByteMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ByteMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(map12.containsSame(ByteMap.intersectionOf(ByteMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ByteMap<String> map23 = createByteMap(ENTRY2, ENTRY3);
        ByteMap<String> actual = ByteMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createByteMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ByteMap<String> map23 = createByteMap(ENTRY2, ENTRY3);
        ByteMap<String> actual = ByteMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ByteMap<String> expected =
                createByteMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
