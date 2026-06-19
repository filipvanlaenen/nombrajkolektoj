package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableDoubleCollection} class.
 */
public final class ModifiableDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableDoubleCollection> {
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final NumericCollection<Double> collection123 = createDoubleCollection(1D, 2D, 3D);

    @Override
    protected ModifiableDoubleCollection createEmptyDoubleCollection() {
        return ModifiableDoubleCollection.empty();
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableDoubleCollection.of(numbers);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Double> source) {
        return ModifiableDoubleCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableDoubleCollection createDoubleCollection(final NumericCollection<Double> source) {
        return ModifiableDoubleCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableDoubleCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableDoubleCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createDoubleCollection(1D, 2D).containsSame(
                ModifiableDoubleCollection.intersectionOf(createDoubleCollection(0D, 1D, 2D), collection123)));
    }
}
