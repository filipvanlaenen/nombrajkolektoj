package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.ModifiableBigDecimalMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ModifiableBigDecimalMapDecorator<K> extends UpdatableBigDecimalMapDecorator<K>
        implements ModifiableBigDecimalMap<K> {
    @Override
    public boolean add(final K key, final BigDecimal value) {
        return getDecoratedMap().add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends BigDecimal> aMap) {
        return getDecoratedMap().addAll(aMap);
    }

    @Override
    public void clear() {
        getDecoratedMap().clear();
    }

    @Override
    abstract ModifiableMap<K, BigDecimal> getDecoratedMap();

    @Override
    public BigDecimal remove(final K key) throws IllegalArgumentException {
        return getDecoratedMap().remove(key);
    }

    @Override
    public boolean remove(final K key, final BigDecimal value) {
        return getDecoratedMap().remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends BigDecimal> aMap) {
        return getDecoratedMap().removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends BigDecimal>> predicate) {
        return getDecoratedMap().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends BigDecimal> aMap) {
        return getDecoratedMap().retainAll(aMap);
    }
}
