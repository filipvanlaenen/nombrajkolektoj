package net.filipvanlaenen.nombrajkolektoj.floats;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.floats.OrderedFloatCollection} class.
 */
public final class OrderedFloatCollectionTest extends OrderedFloatCollectionTestBase<OrderedFloatCollection> {
    /**
     * The float three.
     */
    private static final Float FLOAT_THREE = 3F;
    /**
     * The float four.
     */
    private static final Float FLOAT_FOUR = 4F;
    /**
     * The float sixe.
     */
    private static final Float FLOAT_SIX = 6F;

    @Override
    protected OrderedFloatCollection createEmptyFloatCollection() {
        return OrderedFloatCollection.empty();
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final NumericCollection<Float> source) {
        return OrderedFloatCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.FLOATS));
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedFloatCollection createFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final Float... numbers) {
        return OrderedFloatCollection.of(numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(final ElementCardinality elementCardinality,
            final Float... numbers) {
        return OrderedFloatCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedFloatCollection createOrderedFloatCollection(OrderedNumericCollection<Float> source) {
        return OrderedFloatCollection.of(source);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered floats collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedFloatCollection collectionA = createOrderedFloatCollection(1F, 2F);
        OrderedFloatCollection collectionB = createOrderedFloatCollection(1F, 2F, FLOAT_THREE);
        OrderedFloatCollection actual = OrderedFloatCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new Float[] {1F, 2F, FLOAT_THREE, 2F, FLOAT_FOUR, FLOAT_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedFloatCollection collectionA = createOrderedFloatCollection(1F, 2F);
        OrderedFloatCollection collectionB = createOrderedFloatCollection(1F, null, FLOAT_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedFloatCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedFloatCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element and generator creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element and generator creates a collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, 1);
        assertArrayEquals(new Float[] {0F}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element and generator creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedFloatCollection actual = OrderedFloatCollection.createSequence(0F, n -> n, 2);
        assertArrayEquals(new Float[] {0F, 0F}, actual.toArray());
    }
}
