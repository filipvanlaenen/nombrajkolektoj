package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableSortedByteMap} class.
 */

public final class ModifiableSortedByteMapTest extends UpdatableByteMapTestBase<ModifiableSortedByteMap<String>> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return ModifiableSortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final String key, final Byte value) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3, final String key4,
            final Byte value4) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedByteMap<String> createByteMap(final String key1, final Byte value1,
            final String key2, final Byte value2, final String key3, final Byte value3, final String key4,
            final Byte value4, final String key5, final Byte value5) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedByteMap<String> createEmptyByteMap() {
        return ModifiableSortedByteMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedByteMap<String> createUpdatableByteMap(final Byte defaultValue,
            final String... keys) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return ModifiableSortedByteMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedByteMap<String> createUpdatableByteMap(
            final KeyAndValueCardinality keyAndValueCardinality, final Byte defaultValue, String... keys) {
        return ModifiableSortedByteMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a bytes map with three entries.
     *
     * @return A bytes map with three entries.
     */
    private ModifiableSortedByteMap<String> createByteMap123() {
        return createByteMap("one", (byte) 1, "two", (byte) 2, "three", BYTE_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.addAll(createUpdatableByteMap(new Entry<String, Byte>("four", BYTE_FOUR))));
        assertFalse(map123.addAll(createUpdatableByteMap(new Entry<String, Byte>("four", BYTE_FOUR))));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.add("four", BYTE_FOUR));
        assertEquals(BYTE_FOUR, map123.get("four"));
        assertFalse(map123.add("four", BYTE_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
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

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertEquals((byte) 1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }
}
