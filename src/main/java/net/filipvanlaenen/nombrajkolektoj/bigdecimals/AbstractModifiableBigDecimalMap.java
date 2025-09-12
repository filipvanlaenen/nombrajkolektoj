package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericMap} for BigDecimals.
 *
 * @param <K> The key type.
 */
abstract class AbstractModifiableBigDecimalMap<K> extends AbstractUpdatableBigDecimalMap<K>
        implements ModifiableNumericMap<K, BigDecimal> {
}
