package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableBigIntegerMap<K> extends AbstractUpdatableBigIntegerMap<K>
        implements ModifiableNumericMap<K, BigInteger> {
}
