package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableSortedNumericMap} for BigDecimals.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableSortedBigDecimalMap<K> extends AbstractModifiableBigDecimalMap<K>
        implements ModifiableSortedNumericMap<K, BigDecimal> {
}
