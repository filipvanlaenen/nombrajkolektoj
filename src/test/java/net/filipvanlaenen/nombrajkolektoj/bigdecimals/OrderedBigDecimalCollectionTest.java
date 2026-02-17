package net.filipvanlaenen.nombrajkolektoj.bigdecimals;

import java.math.BigDecimal;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigDecimals.OrderedBigDecimalCollection} class.
 */
public final class OrderedBigDecimalCollectionTest extends OrderedBigDecimalCollectionTestBase<OrderedBigDecimalCollection> {
    /**
     * The BigDecimal three.
     */
    private static final BigDecimal BIG_DECIMAL_THREE = BigDecimal.valueOf(3L);
    /**
     * The BigDecimal four.
     */
    private static final BigDecimal BIG_DECIMAL_FOUR = BigDecimal.valueOf(4L);
    /**
     * The BigDecimal sixe.
     */
    private static final BigDecimal BIG_DECIMAL_SIX = BigDecimal.valueOf(6L);
    private static final BigDecimal[] BIG_DECIMALS = new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.valueOf(2L)};

    @Override
    protected OrderedBigDecimalCollection createEmptyBigDecimalCollection() {
        return OrderedBigDecimalCollection.empty();
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final NumericCollection<BigDecimal> source) {
        return OrderedBigDecimalCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_DECIMALS));
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createBigDecimalCollection(final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createOrderedBigDecimalCollection(final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createOrderedBigDecimalCollection(final ElementCardinality elementCardinality,
            final BigDecimal... numbers) {
        return OrderedBigDecimalCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigDecimalCollection createOrderedBigDecimalCollection(OrderedNumericCollection<BigDecimal> source) {
        return OrderedBigDecimalCollection.of(source);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered BigDecimals collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedBigDecimalCollection collectionA = createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L));
        OrderedBigDecimalCollection collectionB = createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE);
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new BigDecimal[] {BigDecimal.ONE, BigDecimal.valueOf(2L), BIG_DECIMAL_THREE, BigDecimal.valueOf(2L), BIG_DECIMAL_FOUR, BIG_DECIMAL_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedBigDecimalCollection collectionA = createOrderedBigDecimalCollection(BigDecimal.ONE, BigDecimal.valueOf(2L));
        OrderedBigDecimalCollection collectionB = createOrderedBigDecimalCollection(BigDecimal.ONE, null, BIG_DECIMAL_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedBigDecimalCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedBigDecimalCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(BigDecimal.ZERO, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(BigDecimal.ZERO, n -> n, 1);
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(BigDecimal.ZERO, n -> n, 2);
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(BigDecimal.ZERO, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedBigDecimalCollection actual =
                OrderedBigDecimalCollection.createSequence(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE), n -> !Objects.equals(n, BigDecimal.ONE));
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedBigDecimalCollection actual =
                OrderedBigDecimalCollection.createSequence(BigDecimal.ZERO, n -> n.add(BigDecimal.ONE), n -> !Objects.equals(n, BigDecimal.valueOf(2L)));
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(i -> BIG_DECIMALS[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(i -> BIG_DECIMALS[i], 1);
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(i -> BIG_DECIMALS[i], 2);
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedBigDecimalCollection actual = OrderedBigDecimalCollection.createSequence(i -> BIG_DECIMALS[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedBigDecimalCollection actual =
                OrderedBigDecimalCollection.createSequence(i -> BIG_DECIMALS[i], n -> !Objects.equals(n, BigDecimal.ONE));
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedBigDecimalCollection actual =
                OrderedBigDecimalCollection.createSequence(i -> BIG_DECIMALS[i], n -> !Objects.equals(n, BigDecimal.valueOf(2L)));
        assertArrayEquals(new BigDecimal[] {BigDecimal.ZERO, BigDecimal.ONE}, actual.toArray());
    }
}
