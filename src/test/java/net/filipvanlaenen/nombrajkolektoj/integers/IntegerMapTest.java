package net.filipvanlaenen.nombrajkolektoj.integers;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 */
public class IntegerMapTest extends IntegerMapTestBase<IntegerMap<String>> {
    @Override
    protected IntegerMap<String> createEmptyIntegerMap() {
        return IntegerMap.empty();
    }
}
