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
    public boolean contains(Entry<K, BigDecimal> arg0) {
        return bigdecimals.contains(arg0);
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        return bigdecimals.containsAll(arg0);
    }

    @Override
    public boolean containsKey(K arg0) {
        return bigdecimals.containsKey(arg0);
    }

    @Override
    public boolean containsValue(BigDecimal arg0) {
        return bigdecimals.containsValue(arg0);
    }

    @Override
    public Entry<K, BigDecimal> get() throws IndexOutOfBoundsException {
        return bigdecimals.get();
    }

    @Override
    public BigDecimal get(K arg0) throws IllegalArgumentException {
        return bigdecimals.get(arg0);
    }

    @Override
    public BigDecimalCollection getAll(K arg0) throws IllegalArgumentException {
        return new BigDecimalCollection.ArrayCollection(bigdecimals.getAll(arg0));
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
    public Entry<K, BigDecimal>[] toArray() {
        return bigdecimals.toArray();
    }

    @Override
    public BigDecimal update(K arg0, BigDecimal arg1) throws IllegalArgumentException {
        return bigdecimals.update(arg0, arg1);
    }
}
