package net.filipvanlaenen.nombrajkolektoj.integers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.integers.IntegerCollection} class.
 */
public final class IntegerCollectionTest extends IntegerCollectionTestBase<IntegerCollection> {
    /**
     * Collection with the integers 1, 2 and 3.
     */
    private final NumericCollection<Integer> collection123 = createIntegerCollection(1, 2, 3);

    @Override
    protected IntegerCollection createEmptyIntegerCollection() {
        return IntegerCollection.empty();
    }

    @Override
    protected IntegerCollection createIntegerCollection(final Integer... numbers) {
        return IntegerCollection.of(numbers);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final Integer... numbers) {
        return IntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Integer> source) {
        return IntegerCollection.of(elementCardinality, source);
    }

    @Override
    protected IntegerCollection createIntegerCollection(final NumericCollection<Integer> source) {
        return IntegerCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(IntegerCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(IntegerCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createIntegerCollection(1, 2)
                .containsSame(IntegerCollection.intersectionOf(createIntegerCollection(0, 1, 2), collection123)));
    }
}
