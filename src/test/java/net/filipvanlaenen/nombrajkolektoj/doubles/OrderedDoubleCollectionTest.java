package net.filipvanlaenen.nombrajkolektoj.doubles;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.nombrajkolektoj.NumericCollection;
import net.filipvanlaenen.nombrajkolektoj.OrderedNumericCollection;

/**
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.doubles.OrderedDoubleCollection} class.
 */
public final class OrderedDoubleCollectionTest extends OrderedDoubleCollectionTestBase<OrderedDoubleCollection> {
    /**
     * The double three.
     */
    private static final Double DOUBLE_THREE = 3D;
    /**
     * The double four.
     */
    private static final Double DOUBLE_FOUR = 4D;
    /**
     * The double sixe.
     */
    private static final Double DOUBLE_SIX = 6D;

    @Override
    protected OrderedDoubleCollection createEmptyDoubleCollection() {
        return OrderedDoubleCollection.empty();
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final NumericCollection<Double> source) {
        return OrderedDoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return OrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final Double... numbers) {
        return OrderedDoubleCollection.of(numbers);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final Double... numbers) {
        return OrderedDoubleCollection.of(numbers);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return OrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(OrderedNumericCollection<Double> source) {
        return OrderedDoubleCollection.of(source);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered doubles collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedDoubleCollection collectionA = createOrderedDoubleCollection(1D, 2D);
        OrderedDoubleCollection collectionB = createOrderedDoubleCollection(1D, 2D, DOUBLE_THREE);
        OrderedDoubleCollection actual = OrderedDoubleCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new Double[] {1D, 2D, DOUBLE_THREE, 2D, DOUBLE_FOUR, DOUBLE_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedDoubleCollection collectionA = createOrderedDoubleCollection(1D, 2D);
        OrderedDoubleCollection collectionB = createOrderedDoubleCollection(1D, null, DOUBLE_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedDoubleCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedDoubleCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(0D, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(0D, n -> n, 1);
        assertArrayEquals(new Double[] {0D}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(0D, n -> n, 2);
        assertArrayEquals(new Double[] {0D, 0D}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(0D, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedDoubleCollection actual =
                OrderedDoubleCollection.createSequence(0D, n -> n + 1D, n -> !Objects.equals(n, 1D));
        assertArrayEquals(new Double[] {0D}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedDoubleCollection actual =
                OrderedDoubleCollection.createSequence(0D, n -> n + 1D, n -> !Objects.equals(n, 2D));
        assertArrayEquals(new Double[] {0D, 1D}, actual.toArray());
    }
}
