package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.DoubleCollection} class.
 */
public final class DoubleCollectionTest extends DoubleCollectionTestBase<DoubleCollection> {
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final NumericCollection<Double> collection123 = createDoubleCollection(1D, 2D, 3D);

    @Override
    protected DoubleCollection createEmptyDoubleCollection() {
        return DoubleCollection.empty();
    }

    @Override
    protected DoubleCollection createDoubleCollection(final Double... numbers) {
        return DoubleCollection.of(numbers);
    }

    @Override
    protected DoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return DoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected DoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Double> source) {
        return DoubleCollection.of(elementCardinality, source);
    }

    @Override
    protected DoubleCollection createDoubleCollection(final NumericCollection<Double> source) {
        return DoubleCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(DoubleCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(DoubleCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createDoubleCollection(1D, 2D)
                .containsSame(DoubleCollection.intersectionOf(createDoubleCollection(0D, 1D, 2D), collection123)));
    }
}
