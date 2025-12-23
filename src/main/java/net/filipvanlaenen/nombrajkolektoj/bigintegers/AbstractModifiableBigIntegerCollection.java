package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection;

/**
 * An abstract class implementing the methods defined in the
 * {@link net.filipvanlaenen.nombrajkolektoj.ModifiableNumericCollection} for BigIntegers.
 */
abstract class AbstractModifiableBigIntegerCollection extends AbstractBigIntegerCollection
        implements ModifiableNumericCollection<BigInteger> {
    @Override
    public boolean augment(final BigInteger addend) {
        boolean result = false;
        for (BigInteger n : toArray()) {
            if (n != null && addend != BigInteger.ZERO) {
                remove(n);
                add(n.add(addend));
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean multiply(final BigInteger multiplicand) {
        boolean result = false;
        for (BigInteger n : toArray()) {
            if (n != null && n != BigInteger.ZERO && multiplicand != BigInteger.ONE) {
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
        for (BigInteger n : toArray()) {
            if (n != null && n != BigInteger.ZERO) {
                remove(n);
                add(n.negate());
                result = true;
            }
        }
        return result;
    }
}
