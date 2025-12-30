package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.ModifiableOrderedDoubleCollection} class.
 */
public final class ModifiableOrderedDoubleCollectionTest
        extends ModifiableDoubleCollectionTestBase<ModifiableOrderedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final Collection<Double> source) {
        return new ModifiableOrderedDoubleCollection.ArrayCollection(
                OrderedDoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final Double... numbers) {
        return ModifiableOrderedDoubleCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return ModifiableOrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedDoubleCollection createEmptyDoubleCollection() {
        return ModifiableOrderedDoubleCollection.empty();
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createDoubleCollection(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE).firstIndexOf(2D));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createDoubleCollection(1D, 2D, DOUBLE_THREE).indexOf(2D));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createDoubleCollection(DUPLICATE_ELEMENTS, 1D, 2D, 2D, DOUBLE_THREE).lastIndexOf(2D));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2D, createDoubleCollection(1D, 2D, DOUBLE_THREE).removeAt(1));
    }
}
