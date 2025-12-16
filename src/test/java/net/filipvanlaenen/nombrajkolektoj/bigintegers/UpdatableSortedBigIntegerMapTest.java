package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.UpdatableSortedBigIntegerMap} class.
 */
public final class UpdatableSortedBigIntegerMapTest extends UpdatableBigIntegerMapTestBase<UpdatableSortedBigIntegerMap<String>> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);

    @Override
    protected UpdatableSortedBigIntegerMap<String> createEmptyBigIntegerMap() {
        return UpdatableSortedBigIntegerMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return UpdatableSortedBigIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2, final String key3, final BigInteger value3) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2, final String key3, final BigInteger value3, final String key4,
            final BigInteger value4) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1,
            final String key2, final BigInteger value2, final String key3, final BigInteger value3, final String key4,
            final BigInteger value4, final String key5, final BigInteger value5) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4,
                value4, key5, value5);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createUpdatableBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createUpdatableBigIntegerMap(final BigInteger defaultValue,
            final String... keys) {
        return UpdatableSortedBigIntegerMap.of(Comparator.naturalOrder(), defaultValue, keys);
    }

    @Override
    protected UpdatableSortedBigIntegerMap<String> createUpdatableBigIntegerMap(
            final KeyAndValueCardinality keyAndValueCardinality, final BigInteger defaultValue, final String... keys) {
        return UpdatableSortedBigIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), defaultValue, keys);
    }

    /**
     * Creates a BigIntegers map with three entries.
     *
     * @return A BigIntegers map with three entries.
     */
    private UpdatableSortedBigIntegerMap<String> createBigIntegerMap123() {
        return createBigIntegerMap("one", BigInteger.ONE, "two", BigInteger.TWO, "three", BIG_INTEGER_THREE);
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
        assertEquals(new Entry<String, BigInteger>("three", BigInteger.valueOf(3L)), createBigIntegerMap123().getGreaterThanOrEqualTo("three"));
    }

    /**
     * Verifies that the <code>getGreatest</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getGreatestShouldBeWiredCorrectlyToTheInternalMap() {
        assertEquals(new Entry<String, BigInteger>("two", BigInteger.TWO), createBigIntegerMap123().getGreatest());
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
        assertEquals(new Entry<String, BigInteger>("one", BigInteger.ONE), createBigIntegerMap123().getLeast());
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
}
