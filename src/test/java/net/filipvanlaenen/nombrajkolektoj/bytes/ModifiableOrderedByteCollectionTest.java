package net.filipvanlaenen.nombrajkolektoj.bytes;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DUPLICATE_ELEMENTS;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection;
import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.bytes.ModifiableOrderedByteCollection} class.
 */
public final class ModifiableOrderedByteCollectionTest
        extends ModifiableByteCollectionTestBase<ModifiableOrderedByteCollection> {
    /**
     * The byte three.
     */
    private static final Byte BYTE_THREE = (byte) 3;

    @Override
    protected ModifiableOrderedByteCollection createByteCollection(final Collection<Byte> source) {
        return new ModifiableOrderedByteCollection.ArrayCollection(
                OrderedByteCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BYTES)));
    }

    @Override
    protected ModifiableOrderedByteCollection createByteCollection(final Byte... numbers) {
        return ModifiableOrderedByteCollection.of(numbers);
    }

    @Override
    protected ModifiableOrderedByteCollection createByteCollection(final ElementCardinality elementCardinality,
            final Byte... numbers) {
        return ModifiableOrderedByteCollection.of(elementCardinality, numbers);
    }

    @Override
    protected ModifiableOrderedByteCollection createEmptyByteCollection() {
        return ModifiableOrderedByteCollection.empty();
    }

    /**
     * Verifies that the <code>firstIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void firstIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).firstIndexOf((byte) 2));
    }

    /**
     * Verifies that the <code>getAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void getAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).getAt(1));
    }

    /**
     * Verifies that the <code>indexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void indexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(1, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).indexOf((byte) 2));
    }

    /**
     * Verifies that the <code>lastIndexOf</code> method is wired correctly to the internal collection.
     */
    @Test
    public void lastIndexOfShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals(2, createByteCollection(DUPLICATE_ELEMENTS, (byte) 1, (byte) 2, (byte) 2, BYTE_THREE).lastIndexOf((byte) 2));
    }

    /**
     * Verifies that the <code>removeAt</code> method is wired correctly to the internal collection.
     */
    @Test
    public void removeAtShouldBeWiredCorrectlyToTheInternalCollection() {
        assertEquals((byte) 2, createByteCollection((byte) 1, (byte) 2, BYTE_THREE).removeAt(1));
    }
}
