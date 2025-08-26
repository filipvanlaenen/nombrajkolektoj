package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Spliterator;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.UpdatableSortedMap;
import net.filipvanlaenen.kolektoj.array.UpdatableSortedArrayMap;
import net.filipvanlaenen.kolektoj.sortedtree.UpdatableSortedTreeMap;
import net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap;

/**
 * An abstract class implementing the {@link net.filipvanlaenen.nombrajkolektoj.UpdatableSortedNumericMap} interface for
 * BigDecimals and containing inner classes with concrete implementations.
 *
 * @param <K> The key type.
 */
public abstract class UpdatableSortedBigDecimalMap<K> extends AbstractUpdatableSortedBigDecimalMap<K>
        implements UpdatableSortedNumericMap<K, BigDecimal> {
    public static final class ArrayMap<K> extends UpdatableSortedBigDecimalMap<K> {
        public ArrayMap(final Comparator<K> comparator, final Entry<K, BigDecimal>... bigdecimals)
                throws IllegalArgumentException {
            super(new UpdatableSortedArrayMap<K, BigDecimal>(comparator, bigdecimals));
        }

        public ArrayMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, BigDecimal>... bigdecimals) throws IllegalArgumentException {
            super(new UpdatableSortedArrayMap<K, BigDecimal>(keyAndValueCardinality, comparator, bigdecimals));
        }
    }

    public static final class SortedTreeMap<K> extends UpdatableSortedBigDecimalMap<K> {
        public SortedTreeMap(final Comparator<K> comparator, final Entry<K, BigDecimal>... bigdecimals)
                throws IllegalArgumentException {
            super(new UpdatableSortedTreeMap<K, BigDecimal>(comparator, bigdecimals));
        }

        public SortedTreeMap(final KeyAndValueCardinality keyAndValueCardinality, final Comparator<K> comparator,
                final Entry<K, BigDecimal>... bigdecimals) throws IllegalArgumentException {
            super(new UpdatableSortedTreeMap<K, BigDecimal>(keyAndValueCardinality, comparator, bigdecimals));
        }
    }

    /**
     * The map holding the BigDecimals.
     */
    private final UpdatableSortedMap<K, BigDecimal> bigdecimals;

    /**
     * Private constructor taking a map with the BigDecimals as its parameter.
     *
     * @param bigdecimals The map holding the BigDecimals.
     */
    private UpdatableSortedBigDecimalMap(final UpdatableSortedMap<K, BigDecimal> bigdecimals) {
        this.bigdecimals = bigdecimals;
    }

    @Override
    public boolean contains(final Entry<K, BigDecimal> entry) {
        return bigdecimals.contains(entry);
    }

    @Override
    public boolean containsAll(final Collection<?> map) {
        return bigdecimals.containsAll(map);
    }

    @Override
    public boolean containsKey(final K key) {
        return bigdecimals.containsKey(key);
    }

    @Override
    public boolean containsValue(final BigDecimal value) {
        return bigdecimals.containsValue(value);
    }

    @Override
    public Entry<K, BigDecimal> get() throws IndexOutOfBoundsException {
        return bigdecimals.get();
    }

    @Override
    public BigDecimal get(final K key) throws IllegalArgumentException {
        return bigdecimals.get(key);
    }

    @Override
    public BigDecimalCollection getAll(final K key) throws IllegalArgumentException {
        return new BigDecimalCollection.ArrayCollection(bigdecimals.getAll(key));
    }

    @Override
    public Comparator<? super K> getComparator() {
        return bigdecimals.getComparator();
    }

    @Override
    public Entry<K, BigDecimal> getGreatest() {
        return bigdecimals.getGreatest();
    }

    @Override
    public K getGreatestKey() {
        return bigdecimals.getGreatestKey();
    }

    @Override
    public KeyAndValueCardinality getKeyAndValueCardinality() {
        return bigdecimals.getKeyAndValueCardinality();
    }

    @Override
    public Collection<K> getKeys() {
        return bigdecimals.getKeys();
    }

    @Override
    public Entry<K, BigDecimal> getLeast() {
        return bigdecimals.getLeast();
    }

    @Override
    public K getLeastKey() {
        return bigdecimals.getLeastKey();
    }

    @Override
    public BigDecimalCollection getValues() {
        return new BigDecimalCollection.ArrayCollection(bigdecimals.getValues());
    }

    @Override
    public Iterator<Entry<K, BigDecimal>> iterator() {
        return bigdecimals.iterator();
    }

    @Override
    public int size() {
        return bigdecimals.size();
    }

    @Override
    public Spliterator<Entry<K, BigDecimal>> spliterator() {
        return bigdecimals.spliterator();
    }

    @Override
    public Object[] toArray() {
        return bigdecimals.toArray();
    }

    @Override
    public BigDecimal update(final K key, final BigDecimal value) throws IllegalArgumentException {
        return bigdecimals.update(key, value);
    }
}
