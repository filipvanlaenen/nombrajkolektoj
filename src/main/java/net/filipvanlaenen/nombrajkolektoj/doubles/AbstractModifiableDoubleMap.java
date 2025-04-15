package net.filipvanlaenen.nombrajkolektoj.doubles;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for Doubles.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableDoubleMap<K> extends AbstractUpdatableDoubleMap<K>
        implements ModifiableNumericMap<K, Double> {
}
