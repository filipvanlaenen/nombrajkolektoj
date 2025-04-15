package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

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

    @Override
    protected ModifiableByteMap<String> createEmptyByteMap() {
        return ModifiableByteMap.<String>empty();
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(entries);
    }

    @Override
    protected ModifiableByteMap<String> createByteMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(keyAndValueCardinality, entries);
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
    protected ModifiableByteMap<String> createUpdatableByteMap(final Entry<String, Byte>... entries) {
        return ModifiableByteMap.of(entries);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.add("four", BYTE_FOUR));
        assertEquals(BYTE_FOUR, map123.get("four"));
        assertFalse(map123.add("four", BYTE_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.addAll(createUpdatableByteMap(new Entry<String, Byte>("four", BYTE_FOUR))));
        assertFalse(map123.addAll(createUpdatableByteMap(new Entry<String, Byte>("four", BYTE_FOUR))));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertEquals((byte) 1, map123.remove("one"));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.removeAll(createUpdatableByteMap(new Entry<String, Byte>("three", BYTE_THREE))));
        assertFalse(map123.removeAll(createUpdatableByteMap(new Entry<String, Byte>("three", BYTE_THREE))));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableByteMap<String> map123 = createUpdatableByteMap(new Entry<String, Byte>("one", (byte) 1),
                new Entry<String, Byte>("two", (byte) 2), new Entry<String, Byte>("three", BYTE_THREE));
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }
}
