package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

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
 * Unit tests on the {@link net.filipvanlaenen.nombrajkolektoj.BigIntegers.OrderedBigIntegerCollection} class.
 */
public final class OrderedBigIntegerCollectionTest extends OrderedBigIntegerCollectionTestBase<OrderedBigIntegerCollection> {
    /**
     * The BigInteger three.
     */
    private static final BigInteger BIG_INTEGER_THREE = BigInteger.valueOf(3L);
    /**
     * The BigInteger four.
     */
    private static final BigInteger BIG_INTEGER_FOUR = BigInteger.valueOf(4L);
    /**
     * The BigInteger sixe.
     */
    private static final BigInteger BIG_INTEGER_SIX = BigInteger.valueOf(6L);
    private static final BigInteger[] BIG_INTEGERS = new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO};

    @Override
    protected OrderedBigIntegerCollection createEmptyBigIntegerCollection() {
        return OrderedBigIntegerCollection.empty();
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return OrderedBigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(OrderedNumericCollection<BigInteger> source) {
        return OrderedBigIntegerCollection.of(source);
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final OrderedNumericCollection<BigInteger> source,
            int fromIndex, int toIndex) {
        return OrderedBigIntegerCollection.of(source, fromIndex, toIndex);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered BigIntegers collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedBigIntegerCollection collectionA = createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        OrderedBigIntegerCollection collectionB = createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.ofMatrixDirectProduct(collectionA, collectionB);
        assertArrayEquals(new BigInteger[] {BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE, BigInteger.TWO, BIG_INTEGER_FOUR, BIG_INTEGER_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedBigIntegerCollection collectionA = createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        OrderedBigIntegerCollection collectionB = createOrderedBigIntegerCollection(BigInteger.ONE, null, BIG_INTEGER_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedBigIntegerCollection.ofMatrixDirectProduct(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedBigIntegerCollection.ofMatrixDirectProduct(collectionB, collectionA));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates an empty
     * collection when the number of elements is less than one.
     */
    @Test
    public void createSequenceShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(BigInteger.ZERO, n -> n, 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with one element.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithOneElement() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(BigInteger.ZERO, n -> n, 1);
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and number of elements creates a
     * collection with two elements.
     */
    @Test
    public void createSequenceShouldProduceACollectionWithTwoElements() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(BigInteger.ZERO, n -> n, 2);
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates an empty
     * collection when the predicate is always false.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(BigInteger.ZERO, n -> n, n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition creates a collection
     * with one element.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedBigIntegerCollection actual =
                OrderedBigIntegerCollection.createSequence(BigInteger.ZERO, n -> n.add(BigInteger.ONE), n -> !Objects.equals(n, BigInteger.ONE));
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with first element, generator and while condition ccreates a collection
     * with two elements.
     */
    @Test
    public void createSequenceWithWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedBigIntegerCollection actual =
                OrderedBigIntegerCollection.createSequence(BigInteger.ZERO, n -> n.add(BigInteger.ONE), n -> !Objects.equals(n, BigInteger.TWO));
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS[i], 1);
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS[i], 2);
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedBigIntegerCollection actual =
                OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS[i], n -> !Objects.equals(n, BigInteger.ONE));
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedBigIntegerCollection actual =
                OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS[i], n -> !Objects.equals(n, BigInteger.TWO));
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE}, actual.toArray());
    }
}
