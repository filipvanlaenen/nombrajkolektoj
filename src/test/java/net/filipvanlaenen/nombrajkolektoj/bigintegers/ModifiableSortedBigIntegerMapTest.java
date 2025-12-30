package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.ModifiableSortedBigIntegerMap} class.
 */

public final class ModifiableSortedBigIntegerMapTest extends UpdatableBigIntegerMapTestBase<ModifiableSortedBigIntegerMap<String>> {
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

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return ModifiableSortedBigIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2, final String key3, final BigInteger value3) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2, final String key3, final BigInteger value3, final String key4,
            final BigInteger value4) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2, final String key3, final BigInteger value3, final String key4,
            final BigInteger value4, final String key5, final BigInteger value5) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createEmptyBigIntegerMap() {
        return ModifiableSortedBigIntegerMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createUpdatableBigIntegerMap(final BigInteger defaultValue,
            final String... keys) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createUpdatableBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return ModifiableSortedBigIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected ModifiableSortedBigIntegerMap<String> createUpdatableBigIntegerMap(
            final KeyAndValueCardinality keyAndValueCardinality, final BigInteger defaultValue, final String... keys) {
        return ModifiableSortedBigIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a BigIntegers map with three entries.
     *
     * @return A BigIntegers map with three entries.
     */
    private ModifiableSortedBigIntegerMap<String> createBigIntegerMap123() {
        return createBigIntegerMap("one", BigInteger.ONE, "two", BigInteger.TWO, "three", BIG_INTEGER_THREE);
    }

    /**
     * Verifies that the <code>addAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.addAll(createUpdatableBigIntegerMap(ENTRY4)));
        assertFalse(map123.addAll(createUpdatableBigIntegerMap(ENTRY4)));
    }

    /**
     * Verifies that the <code>add</code> method is wired correctly to the internal collection.
     */
    @Test
    public void addShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.add("four", BIG_INTEGER_FOUR));
        assertEquals(BIG_INTEGER_FOUR, map123.get("four"));
        assertFalse(map123.add("four", BIG_INTEGER_FOUR));
    }

    /**
     * Verifies that the <code>clear</code> method is wired correctly to the internal collection.
     */
    @Test
    public void clearShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        map123.clear();
        assertTrue(map123.isEmpty());
    }

    /**
     * Verifies that the <code>getComparator</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getComparatorShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(Comparator.naturalOrder(), createBigIntegerMap123().getComparator());
    }

    /**
     * Verifies that the <code>getGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createBigIntegerMap123().getGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, BigInteger>("three", BIG_INTEGER_THREE),
                createBigIntegerMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY2, createBigIntegerMap123().getGreatest());
    }

    /**
     * Verifies that the <code>getGreatestKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createBigIntegerMap123().getGreatestKey());
    }

    /**
     * Verifies that the <code>getKeyGreaterThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("two", createBigIntegerMap123().getKeyGreaterThan("three"));
    }

    /**
     * Verifies that the <code>getKeyGreaterThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyGreaterThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createBigIntegerMap123().getKeyGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createBigIntegerMap123().getKeyLessThan("three"));
    }

    /**
     * Verifies that the <code>getKeyLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getKeyLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("three", createBigIntegerMap123().getKeyLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createBigIntegerMap123().getLeast());
    }

    /**
     * Verifies that the <code>getLeastKey</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLeastKeyShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals("one", createBigIntegerMap123().getLeastKey());
    }

    /**
     * Verifies that the <code>getLessThan</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY1, createBigIntegerMap123().getLessThan("three"));
    }

    /**
     * Verifies that the <code>getLessThanOrEqualTo</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getLessThanOrEqualToShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(ENTRY3, createBigIntegerMap123().getLessThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(BigInteger.ONE, map123.remove("one"));
    }

    /**
     * Verifies that the <code>remove</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeWithValueShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertFalse(map123.remove("one", BigInteger.TWO));
        assertTrue(map123.remove("one", BigInteger.ONE));
    }

    /**
     * Verifies that the <code>removeAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeAll(createBigIntegerMap(ENTRY3)));
        assertFalse(map123.removeAll(createBigIntegerMap(ENTRY3)));
    }

    /**
     * Verifies that the <code>removeGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY2, map123.removeGreatest());
        assertFalse(map123.containsKey("two"));
    }

    /**
     * Verifies that the <code>removeIf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeIfShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.removeIf(x -> x.key().equals("one")));
        assertFalse(map123.removeIf(x -> x.key().equals("one")));
    }

    /**
     * Verifies that the <code>removeLeast</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeLeastShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertEquals(ENTRY1, map123.removeLeast());
        assertFalse(map123.containsKey("one"));
    }

    /**
     * Verifies that the <code>retainAll</code> method is wired correctly to the internal collection.
     */
    @Test
    public void retainAllShouldBeWiredCorrectlyToTheInternalMap() {
        ModifiableSortedBigIntegerMap<String> map123 = createUpdatableBigIntegerMap(ENTRY1, ENTRY2, ENTRY3);
        assertTrue(map123.retainAll(createUpdatableBigIntegerMap(ENTRY3)));
        assertFalse(map123.retainAll(createUpdatableBigIntegerMap(ENTRY3)));
    }
}
