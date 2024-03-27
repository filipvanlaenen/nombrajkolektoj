package net.filipvanlaenen.nombrajkolektoj.integers;

/**
 * Unit tests on the abstract {@link net.filipvanlaenen.nombrajkolektoj.integers.AbstractIntegerCollection} class. The
 * class is tested through the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} implementation.
 */
public final class AbstractIntegerCollectionTest extends AbstractIntegerCollectionTestBase<IntegerCollection> {
    @Override
    protected IntegerCollection createIntegerCollection(final Integer... integers) {
        return IntegerCollection.of(integers);
    }
}
