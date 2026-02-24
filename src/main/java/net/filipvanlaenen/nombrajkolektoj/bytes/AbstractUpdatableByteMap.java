package net.filipvanlaenen.nombrajkolektoj.bytes;

import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.UpdatableNumericMap} for Bytes.
 *
 * @param <K> The key type.
 */
abstract class AbstractUpdatableByteMap<K> extends AbstractByteMap<K> implements UpdatableNumericMap<K, Byte> {
    @Override
    public Byte augment(final K key, final Byte addend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue + addend));
            return oldValue;
        }
    }

    @Override
    public Byte divide(final K key, final Byte divisor) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue / divisor));
            return oldValue;
        }
    }

    @Override
    public boolean divide(final Byte divisor) throws IllegalArgumentException {
        boolean result = false;
        for (K key : getKeys()) {
            NumericCollection<Byte> originalValues = getAll(key);
            ModifiableByteCollection dividedValues = ModifiableByteCollection.of(originalValues);
            if (dividedValues.divide(divisor)) {
                ModifiableByteCollection newValues = ModifiableByteCollection.of(dividedValues);
                newValues.removeAll(originalValues);
                ModifiableByteCollection removedValues = ModifiableByteCollection.of(originalValues);
                removedValues.removeAll(dividedValues);
                for (Byte removedValue : removedValues) {
                    Byte newValue = newValues.get();
                    update(key, removedValue, newValue);
                    newValues.remove(newValue);
                }
                result = true;
            }
        }
        return result;
    }

    @Override
    public Byte multiply(final K key, final Byte multiplicand) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue * multiplicand));
            return oldValue;
        }
    }

    @Override
    public Byte negate(final K key) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (-oldValue));
            return oldValue;
        }
    }

    @Override
    public Byte subtract(final K key, final Byte subtrahend) {
        if (!containsKey(key)) {
            throw new IllegalArgumentException("Map doesn't contain an entry with the key " + key + ".");
        }
        Byte oldValue = get(key);
        if (oldValue == null) {
            throw new IllegalArgumentException("The entry in the map with the key " + key + " contains null.");
        } else {
            update(key, oldValue, (byte) (oldValue - subtrahend));
            return oldValue;
        }
    }
}
