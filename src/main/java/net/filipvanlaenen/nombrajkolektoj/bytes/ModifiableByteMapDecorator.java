package net.filipvanlaenen.nombrajkolektoj.bytes;

import java.util.function.Predicate;

import net.filipvanlaenen.kolektoj.Map;
import net.filipvanlaenen.kolektoj.ModifiableMap;

/**
 * An abstract decorator class providing implementations for the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteMap} interface.
 *
 * @param <K> The key type.
 */
abstract class ModifiableByteMapDecorator<K> extends UpdatableByteMapDecorator<K>
        implements ModifiableByteMap<K> {
    @Override
    public boolean add(final K key, final Byte value) {
        return getDecoratedMap().add(key, value);
    }

    @Override
    public boolean addAll(final Map<? extends K, ? extends Byte> aMap) {
        return getDecoratedMap().addAll(aMap);
    }

    @Override
    public void clear() {
        getDecoratedMap().clear();
    }

    @Override
    abstract ModifiableMap<K, Byte> getDecoratedMap();

    @Override
    public Byte remove(final K key) throws IllegalArgumentException {
        return getDecoratedMap().remove(key);
    }

    @Override
    public boolean remove(final K key, final Byte value) {
        return getDecoratedMap().remove(key, value);
    }

    @Override
    public boolean removeAll(final Map<? extends K, ? extends Byte> aMap) {
        return getDecoratedMap().removeAll(aMap);
    }

    @Override
    public boolean removeIf(final Predicate<Entry<? extends K, ? extends Byte>> predicate) {
        return getDecoratedMap().removeIf(predicate);
    }

    @Override
    public boolean retainAll(final Map<? extends K, ? extends Byte> aMap) {
        return getDecoratedMap().retainAll(aMap);
    }
}
