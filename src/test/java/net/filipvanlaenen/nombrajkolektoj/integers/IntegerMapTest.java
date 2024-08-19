package net.filipvanlaenen.nombrajkolektoj.integers;

import net.filipvanlaenen.kolektoj.Map.Entry;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerMap} class.
 */
public class IntegerMapTest extends IntegerMapTestBase<IntegerMap<String>> {
    @Override
    protected IntegerMap<String> createEmptyIntegerMap() {
        return IntegerMap.empty();
    }

    @Override
    protected IntegerMap<String> createIntegerMap(final Entry<String, Integer>... entries) {
        return IntegerMap.of(entries);
    }
}
