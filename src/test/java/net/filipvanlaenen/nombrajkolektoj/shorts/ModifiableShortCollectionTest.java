package net.filipvanlaenen.nombrajkolektoj.shorts;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.shorts.ModifiableShortCollection} class.
 */
public final class ModifiableShortCollectionTest
        extends ModifiableShortCollectionTestBase<ModifiableShortCollection> {
    /**
     * Collection with the shorts 1, 2 and 3.
     */
    private final NumericCollection<Short> collection123 = createShortCollection((short) 1, (short) 2, (short) 3);

    @Override
    protected ModifiableShortCollection createEmptyShortCollection() {
        return ModifiableShortCollection.empty();
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final Short... numbers) {
        return ModifiableShortCollection.of(numbers);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final Short... numbers) {
        return ModifiableShortCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Short> source) {
        return ModifiableShortCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableShortCollection createShortCollection(final NumericCollection<Short> source) {
        return ModifiableShortCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableShortCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableShortCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createShortCollection((short) 1, (short) 2).containsSame(
                ModifiableShortCollection.intersectionOf(createShortCollection((short) 0, (short) 1, (short) 2), collection123)));
    }
}
