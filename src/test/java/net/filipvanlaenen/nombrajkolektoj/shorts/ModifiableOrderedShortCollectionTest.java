package net.filipvanlaenen.nombrajkolektoj.shorts;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableOrderedShortCollection} class.
 */
public final class ModifiableOrderedShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableOrderedShortCollection> {
    /**
     * The short three.
     */
    private static final Short SHORT_THREE = (short) 3;

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final Collection<Short> source) {
        return new ModifiableOrderedShortCollection.ArrayCollection(
                OrderedShortCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.SHORTS)));
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final Short... numbers) {
        return ModifiableOrderedShortCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableOrderedShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedShortCollection createEmptyShortCollection() {
        return ModifiableOrderedShortCollection.empty();
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).firstIndexOf((short) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createShortCollection((short) 1, (short) 2, SHORT_THREE).indexOf((short) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createShortCollection(DUPLICATE_ELEMENTS, (short) 1, (short) 2, (short) 2, SHORT_THREE).lastIndexOf((short) 2));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((short) 2, createShortCollection((short) 1, (short) 2, SHORT_THREE).removeAt(1));
    }
}
