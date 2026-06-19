package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.ModifiableFloatCollection} class.
 */
public final class ModifiableFloatCollectionTest
        extends ModifiableFloatCollectionTestBase<ModifiableFloatCollection> {
    /**
     * Collection with the floats 1, 2 and 3.
     */
    private final NumericCollection<Float> collection123 = createFloatCollection(1F, 2F, 3F);

    @Override
    protected ModifiableFloatCollection createEmptyFloatCollection() {
        return ModifiableFloatCollection.empty();
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final Float... numbers) {
        return ModifiableFloatCollection.of(numbers);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return ModifiableFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Float> source) {
        return ModifiableFloatCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return ModifiableFloatCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableFloatCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableFloatCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createFloatCollection(1F, 2F).containsSame(
                ModifiableFloatCollection.intersectionOf(createFloatCollection(0F, 1F, 2F), collection123)));
    }
}
