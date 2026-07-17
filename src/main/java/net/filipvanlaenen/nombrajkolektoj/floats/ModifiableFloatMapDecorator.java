package net.filipvanlaenen.nombrajkolektoj.floats;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ModifiableFloatMapDecorator<K> extends UpdatableFloatMapDecorator<K>
        implements ModifiableFloatMap<K> {
    @Override
    public boolean add(final K key, final Float value) {
        return getDecoratedMap().add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Float> aMap) {
        return getDecoratedMap().addAll(aMap);
    }

    @Override
    public void clear() {
        getDecoratedMap().clear();
    }

    @Override
    abstract ModifiableMap<K, Float> getDecoratedMap();

    @Override
    public Float remove(final K key) throws IllegalArgumentException {
        return getDecoratedMap().remove(key);
    }

    @Override
    public boolean remove(final K key, final Float value) {
        return getDecoratedMap().remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Float> aMap) {
        return getDecoratedMap().removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Float>> predicate) {
        return getDecoratedMap().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Float> aMap) {
        return getDecoratedMap().retainAll(aMap);
    }
}
