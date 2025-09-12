package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for BigIntegers.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedBigIntegerMap<K> extends AbstractModifiableBigIntegerMap<K>
        implements ModifiableSortedNumericMap<K, BigInteger> {
}
