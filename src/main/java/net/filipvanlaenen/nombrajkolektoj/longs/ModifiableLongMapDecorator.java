package net.filipvanlaenen.nombrajkolektoj.longs;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableLongMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ModifiableLongMapDecorator<K> extends UpdatableLongMapDecorator<K>
        implements ModifiableLongMap<K> {
    @Override
    public boolean add(final K key, final Long value) {
        return getDecoratedMap().add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Long> aMap) {
        return getDecoratedMap().addAll(aMap);
    }

    @Override
    public void clear() {
        getDecoratedMap().clear();
    }

    @Override
    abstract ModifiableMap<K, Long> getDecoratedMap();

    @Override
    public Long remove(final K key) throws IllegalArgumentException {
        return getDecoratedMap().remove(key);
    }

    @Override
    public boolean remove(final K key, final Long value) {
        return getDecoratedMap().remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Long> aMap) {
        return getDecoratedMap().removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Long>> predicate) {
        return getDecoratedMap().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Long> aMap) {
        return getDecoratedMap().retainAll(aMap);
    }
}
