package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality.DUPLICATE_KEYS_WITH_DUPLICATE_VALUES;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableBigIntegerMap} class.
 */
public final class ModifiableBigIntegerMapTest extends UpdatableBigIntegerMapTestBase<ModifiableBigIntegerMap<String>> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * An entry for one.
     */
    private static final Entry<String, BigInteger> ENTRY1 = new Entry<String, BigInteger>("one", BigInteger.ONE);
    /**
     * An entry for two.
     */
    private static final Entry<String, BigInteger> ENTRY2 = new Entry<String, BigInteger>("two", BigInteger.TWO);
    /**
     * An entry for three.
     */
    private static final Entry<String, BigInteger> ENTRY3 = new Entry<String, BigInteger>("three", BIG_INTEGER_THREE);
    /**
     * An entry for four.
     */
    private static final Entry<String, BigInteger> ENTRY4 = new Entry<String, BigInteger>("four", BIG_INTEGER_FOUR);
    /**
     * Map with the BigIntegers 1 and 2.
     */
    private final ModifiableBigIntegerMap<String> map12 = ModifiableBigIntegerMap.of(ENTRY1, ENTRY2);
    /**
     * Map with the BigIntegers 1, 2 and 3.
     */
    private final ModifiableBigIntegerMap<String> map123 = ModifiableBigIntegerMap.of(ENTRY1, ENTRY2, ENTRY3);

    @Override
    protected ModifiableBigIntegerMap<String> createEmptyBigIntegerMap() {
        return ModifiableBigIntegerMap.<String>empty();
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return ModifiableBigIntegerMap.of(entries);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final ModifiableBigIntegerMap<String> map) {
        return ModifiableBigIntegerMap.of(map);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return ModifiableBigIntegerMap.of(keyAndValueCardinality, entries);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final ModifiableBigIntegerMap<String> map) {
        return ModifiableBigIntegerMap.of(keyAndValueCardinality, map);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return ModifiableBigIntegerMap.of(key, value);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4,
            final String key5, final BigInteger value5) {
        return ModifiableBigIntegerMap.of(key1, value1, key2, value2, key3, value3, key4, value4, key5, value5);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final BigInteger defaultValue,
            final Collection<String> keys) {
        return ModifiableBigIntegerMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final BigInteger defaultValue, final String... keys) {
        return ModifiableBigIntegerMap.of(defaultValue, keys);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return ModifiableBigIntegerMap.of(entries);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigInteger defaultValue, final Collection<String> keys) {
        return ModifiableBigIntegerMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    @Override
    protected ModifiableBigIntegerMap<String> createUpdatableBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final BigInteger defaultValue, final String... keys) {
        return ModifiableBigIntegerMap.of(keyAndValueCardinality, defaultValue, keys);
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.add("four", BIG_INTEGER_FOUR));
        assertEquals(BIG_INTEGER_FOUR, map.get("four"));
        assertFalse(map.add("four", BIG_INTEGER_FOUR));
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.addAll(createUpdatableBigIntegerMap(ENTRY4)));
        assertFalse(map.addAll(createUpdatableBigIntegerMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        map.clear();
        assertTrue(map.isEmpty());
    }

    /**
     * Verifies that the difference of no maps is empty.
     */
    @Test
    public void differenceOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableBigIntegerMap.differenceOf().isEmpty());
    }

    /**
     * Verifies that the difference of one map is that map.
     */
    @Test
    public void differenceOfOneMapShouldBeTheSameMap() {
        assertTrue(map123.containsSame(ModifiableBigIntegerMap.differenceOf(map123)));
    }

    /**
     * Verifies that the difference of three maps only contains the entries of the first map that aren't present in any
     * of the other.
     */
    @Test
    public void differenceOfThreeMapsShouldOnlyContainTheEntriesFromTheFirstMapNotInTheOthers() {
        assertTrue(BigIntegerMap.of(ENTRY3)
                .containsSame(ModifiableBigIntegerMap.differenceOf(map123, BigIntegerMap.of(ENTRY1), map12)));
    }

    /**
     * Verifies that the intersection of no maps is an empty map.
     */
    @Test
    public void intersectionOfNoMapsShouldBeEmpty() {
        assertTrue(ModifiableBigIntegerMap.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one map is the map itself.
     */
    @Test
    public void intersectionOfOneMapShouldBeItself() {
        assertTrue(map123.containsSame(ModifiableBigIntegerMap.intersectionOf(map123)));
    }

    /**
     * Verifies that the intersection of two maps is a maps with the common entries.
     */
    @Test
    public void intersectionOfTwoMapsShouldContainCommonEntries() {
        assertTrue(
                map12.containsSame(ModifiableBigIntegerMap.intersectionOf(BigIntegerMap.of(ENTRY0, ENTRY1, ENTRY2), map123)));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(BigInteger.ONE, map.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map.remove("one", BigInteger.TWO));
        assertTrue(map.remove("one", BigInteger.ONE));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeAll(createBigIntegerMap(ENTRY3)));
        assertFalse(map.removeAll(createBigIntegerMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.removeIf(x -> x.key().equals("one")));
        assertFalse(map.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableBigIntegerMap<String> map = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map.retainAll(createUpdatableBigIntegerMap(ENTRY3)));
        assertFalse(map.retainAll(createUpdatableBigIntegerMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method returns the union of two maps.
     */
    @Test
    public void unionOfShouldReturnUnionOfTwoMaps() {
        ModifiableBigIntegerMap<String> map23 = createBigIntegerMap(ENTRY2, ENTRY3);
        ModifiableBigIntegerMap<String> actual = ModifiableBigIntegerMap.unionOf(map12, map23);
        assertTrue(actual.containsSame(createBigIntegerMap(ENTRY1, ENTRY2, ENTRY3)));
    }

    /**
     * Verifies that the <code>unionOf</code> method with key value cardinality returns the union of two maps.
     */
    @Test
    public void unionOfWithKeyValueCardinalityShouldReturnUnionOfTwoMaps() {
        ModifiableBigIntegerMap<String> map23 = createBigIntegerMap(ENTRY2, ENTRY3);
        ModifiableBigIntegerMap<String> actual =
                ModifiableBigIntegerMap.unionOf(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, map12, map23);
        ModifiableBigIntegerMap<String> expected =
                createBigIntegerMap(DUPLICATE_KEYS_WITH_DUPLICATE_VALUES, ENTRY1, ENTRY2, ENTRY2, ENTRY3);
        assertTrue(actual.containsSame(expected));
    }
}
