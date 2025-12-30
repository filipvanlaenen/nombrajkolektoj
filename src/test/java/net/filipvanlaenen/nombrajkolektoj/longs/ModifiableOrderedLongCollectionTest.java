package net.filipvanlaenen.nombrajkolektoj.longs;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.longs.ModifiableOrderedLongCollection} class.
 */
public final class ModifiableOrderedLongCollectionTest
        extends ModifiableLongCollectionTestBase<ModifiableOrderedLongCollection> {
    /**
     * The long three.
     */
    private static final Long LONG_THREE = 3L;

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final Collection<Long> source) {
        return new ModifiableOrderedLongCollection.ArrayCollection(
                OrderedLongCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.LONGS)));
    }

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final Long... numbers) {
        return ModifiableOrderedLongCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedLongCollection createLongCollection(final ElementCardinality elementCardinality,
            final Long... numbers) {
        return ModifiableOrderedLongCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedLongCollection createEmptyLongCollection() {
        return ModifiableOrderedLongCollection.empty();
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).firstIndexOf(2L));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createLongCollection(1L, 2L, LONG_THREE).indexOf(2L));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createLongCollection(DUPLICATE_ELEMENTS, 1L, 2L, 2L, LONG_THREE).lastIndexOf(2L));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2L, createLongCollection(1L, 2L, LONG_THREE).removeAt(1));
    }
}
