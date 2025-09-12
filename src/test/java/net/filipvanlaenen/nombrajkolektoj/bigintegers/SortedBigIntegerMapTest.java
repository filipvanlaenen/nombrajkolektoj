package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Comparator;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Map.Entry;
import net.filipvanlaenen.kolektoj.Map.KeyAndValueCardinality;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.SortedBigIntegerMap} class.
 */
public final class SortedBigIntegerMapTest extends BigIntegerMapTestBase<SortedBigIntegerMap<String>> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);

    @Override
    protected SortedBigIntegerMap<String> createEmptyBigIntegerMap() {
        return SortedBigIntegerMap.<String>empty(Comparator.naturalOrder());
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final Entry<String, BigInteger>... entries) {
        return SortedBigIntegerMap.of(Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final KeyAndValueCardinality keyAndValueCardinality,
            final Entry<String, BigInteger>... entries) {
        return SortedBigIntegerMap.of(keyAndValueCardinality, Comparator.naturalOrder(), entries);
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final String key, final BigInteger value) {
        return SortedBigIntegerMap.of(Comparator.naturalOrder(), key, value);
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2) {
        return SortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2);
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3) {
        return SortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3);
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4) {
        return SortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4);
    }

    @Override
    protected SortedBigIntegerMap<String> createBigIntegerMap(final String key1, final BigInteger value1, final String key2,
            final BigInteger value2, final String key3, final BigInteger value3, final String key4, final BigInteger value4,
            final String key5, final BigInteger value5) {
        return SortedBigIntegerMap.of(Comparator.naturalOrder(), key1, value1, key2, value2, key3, value3, key4, value4,
                key5, value5);
    }

    /**
     * Creates a BigIntegers map with three entries.
     *
     * @return A BigIntegers map with three entries.
     */
    private SortedBigIntegerMap<String> createBigIntegerMap123() {
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
}
