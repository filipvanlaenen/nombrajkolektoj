package net.filipvanlaenen.nombrajkolektoj.bytes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableByteCollection} class.
 */
public final class ModifiableByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableByteCollection> {
    /**
     * Collection with the bytes 1, 2 and 3.
     */
    private final NumericCollection<Byte> collection123 = createByteCollection((byte) 1, (byte) 2, (byte) 3);

    @Override
    protected ModifiableByteCollection createEmptyByteCollection() {
        return ModifiableByteCollection.empty();
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final Byte... numbers) {
        return ModifiableByteCollection.of(numbers);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final NumericCollection<Byte> source) {
        return ModifiableByteCollection.of(elementCardinality, source);
    }

    @Override
    protected ModifiableByteCollection createByteCollection(final NumericCollection<Byte> source) {
        return ModifiableByteCollection.of(source);
    }

    /**
     * Verifies that the intersection of no collections is an empty collection.
     */
    @Test
    public void intersectionOfNoCollectionsShouldBeEmpty() {
        assertTrue(ModifiableByteCollection.intersectionOf().isEmpty());
    }

    /**
     * Verifies that the intersection of one collections is the collection itself.
     */
    @Test
    public void intersectionOfOneCollectionsShouldBeItself() {
        assertTrue(collection123.containsSame(ModifiableByteCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of two collections is a collection with the common elements.
     */
    @Test
    public void intersectionOfTwoCollectionsShouldContainCommonElements() {
        assertTrue(createByteCollection((byte) 1, (byte) 2).containsSame(
                ModifiableByteCollection.intersectionOf(createByteCollection((byte) 0, (byte) 1, (byte) 2), collection123)));
    }
}
