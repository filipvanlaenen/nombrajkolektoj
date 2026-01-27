package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for BigDecimals.
 */
abstract class AbstractModifiableBigDecimalCollection extends AbstractBigDecimalCollection
        implements ModifiableNumericCollection<BigDecimal> {
    @Override
    public boolean augment(final BigDecimal addend) {
        boolean result = false;
        for (BigDecimal n : toArray()) {
            if (n != null && addend != BigDecimal.ZERO) {
                remove(n);
                add(n.add(addend));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean divide(final BigDecimal divisor) {
        boolean result = false;
        for (BigDecimal n : toArray()) {
            if (n != null && n != BigDecimal.ZERO && divisor != BigDecimal.ONE) {
                remove(n);
                add(n.divide(divisor));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final BigDecimal multiplicand) {
        boolean result = false;
        for (BigDecimal n : toArray()) {
            if (n != null && n != BigDecimal.ZERO && multiplicand != BigDecimal.ONE) {
                remove(n);
                add(n.multiply(multiplicand));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean negate() {
        boolean result = false;
        for (BigDecimal n : toArray()) {
            if (n != null && n != BigDecimal.ZERO) {
                remove(n);
                add(n.negate());
                result = true;
            }
        }
        return result;
    }
}
