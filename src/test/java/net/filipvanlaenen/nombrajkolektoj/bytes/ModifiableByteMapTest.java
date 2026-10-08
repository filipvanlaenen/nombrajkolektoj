package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteMap} class.
 */
public final class ModifiableByteMapTest extends UpdatableByteMapTestBase<ModifiableByteMap<String>> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;
    /**
     * The byte four.
     */
    private static final Byte BYTE_FOUR = (byte) 4;
    /**
     * An entry for one.
     */
    private static final Entry<String, Byte> ENTRY1 = new Entry<String, Byte>("one", (byte) 1);
    /**
     * An entry for two.
     */
    private static final Entry<String, Byte> ENTRY2 = new Entry<String, Byte>("two", (byte) 2);
    /**
     * An entry for three.
     */
    private static final Entry<String, Byte> ENTRY3 = new Entry<String, Byte>("three", BYTE_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, Byte> ENTRY4 = new Entry<String, Byte>("four", BYTE_FOUR);
    /**
     * Map with the bytes 1 and 2.
     */
    private final ModifiableByteMap<String> map12 = ModifiableByteMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the bytes 1, 2 and 3.
     */
    private final ModifiableByteMap<String> map123 = ModifiableByteMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ModifiableByteMap<String> createEmptyByteMap() {
        return ModifiableByteMap.<String>empty();
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(entries);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final ModifiableByteMap<String> map) {
        return ModifiableByteMap.of(map);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ModifiableByteMap<String> map) {
        return ModifiableByteMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key, final Byte value) {
        return ModifiableByteMap.of(key, value);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2) {
        return ModifiableByteMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3) {
        return ModifiableByteMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4) {
        return ModifiableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final String key1, final Byte value1, final String key2,
            final Byte value2, final String key3, final Byte value3, final String key4, final Byte value4,
            final String key5, final Byte value5) {
        return ModifiableByteMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableByteMap<String> createUpdatableByteMap(final Byte defaultValue,
            final Collection<String> keys) {
        return ModifiableByteMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableByteMap<String> createUpdatableByteMap(final Byte defaultValue, final String... keys) {
        return ModifiableByteMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(entries);
    }

    @Override
    protected ModifiableByteMap<String> createUpdatableByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Byte defaultValue, final Collection<String> keys) {
        return ModifiableByteMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableByteMap<String> createUpdatableByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Byte defaultValue, final String... keys) {
        return ModifiableByteMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.add("four", BYTE_FOUR));
        assertEquals(BYTE_FOUR, map.get("four"));
        assertFalse(map.add("four", BYTE_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.addAll(createUpdatableByteMap(ENTRY4)));
        assertFalse(map.addAll(createUpdatableByteMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableByteMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ModifiableByteMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(ByteMap.of(ENTRY3)
                .containsSame(ModifiableByteMap.differenceOf(map123, ByteMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableByteMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ModifiableByteMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(
                map12.containsSame(ModifiableByteMap.intersectionOf(ByteMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals((byte) 1, map.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map.remove("one", (byte) 2));
        assertTrue(map.remove("one", (byte) 1));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeAll(createByteMap(ENTRY3)));
        assertFalse(map.removeAll(createByteMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeIf(x -> x.key().equals("one")));
        assertFalse(map.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map = createUpdatableByteMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.retainAll(createUpdatableByteMap(ENTRY3)));
        assertFalse(map.retainAll(createUpdatableByteMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ModifiableByteMap<String> map23 = createByteMap(ENTRY2, ENTRY3);
        ModifiableByteMap<String> actual = ModifiableByteMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createByteMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ModifiableByteMap<String> map23 = createByteMap(ENTRY2, ENTRY3);
        ModifiableByteMap<String> actual =
                ModifiableByteMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ModifiableByteMap<String> expected =
                createByteMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
