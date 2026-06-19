package net.filipvanlaenen.nombrajkolektoj.bigintegers;

import java.math.BigInteger;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

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
     * The BigInteger six.
     */
    private static final BigInteger BIG_INTEGER_SIX = BigInteger.valueOf(6L);
    /**
     * Array with the BigIntegers zero, one and two.
     */
    private static final BigInteger[] BIG_INTEGERS012 = new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO};
    /**
     * Array with the BigIntegers one, two and three.
     */
    private static final BigInteger[] BIG_INTEGERS123 = new BigInteger[] {BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L)};
    /**
     * Collection with the BigIntegers 0, 1 and 2.
     */
    private final OrderedNumericCollection<BigInteger> collection012 = createBigIntegerCollection(BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO);
    /**
     * Collection with the BigIntegers 1, 2 and 3.
     */
    private final OrderedNumericCollection<BigInteger> collection123 = createBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BigInteger.valueOf(3L));

    @Override
    protected OrderedBigIntegerCollection createEmptyBigIntegerCollection() {
        return OrderedBigIntegerCollection.empty();
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final BigInteger... numbers) {
        return OrderedBigIntegerCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final ElementCardinality elementCardinality,
            final NumericCollection<BigInteger> source) {
        return OrderedBigIntegerCollection.of(elementCardinality,
                OrderedBigIntegerCollection.of(source.toArray(EmptyArrays.BIG_INTEGERS)));
    }

    @Override
    protected OrderedBigIntegerCollection createBigIntegerCollection(final NumericCollection<BigInteger> source) {
        return OrderedBigIntegerCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.BIG_INTEGERS));
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
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final OrderedNumericCollection<BigInteger> source) {
        return OrderedBigIntegerCollection.of(source);
    }

    @Override
    protected OrderedBigIntegerCollection createOrderedBigIntegerCollection(final OrderedNumericCollection<BigInteger> source,
            final int fromIndex, final int toIndex) {
        return OrderedBigIntegerCollection.of(source, fromIndex, toIndex);
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered BigIntegers collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedBigIntegerCollection collectionA = createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO);
        OrderedBigIntegerCollection collectionB = createOrderedBigIntegerCollection(BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE);
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.matrixDirectProductOf(collectionA, collectionB);
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
                () -> OrderedBigIntegerCollection.matrixDirectProductOf(collectionA, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedBigIntegerCollection.matrixDirectProductOf(collectionB, collectionA));
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
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS012[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS012[i], 1);
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS012[i], 2);
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedBigIntegerCollection actual = OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS012[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedBigIntegerCollection actual =
                OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS012[i], n -> !Objects.equals(n, BigInteger.ONE));
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedBigIntegerCollection actual =
                OrderedBigIntegerCollection.createSequence(i -> BIG_INTEGERS012[i], n -> !Objects.equals(n, BigInteger.TWO));
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(OrderedBigIntegerCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(OrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(BIG_INTEGERS123, OrderedBigIntegerCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(BIG_INTEGERS123, OrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE},
                OrderedBigIntegerCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new BigInteger[] {BigInteger.ZERO, BigInteger.ONE, BigInteger.TWO, BIG_INTEGER_THREE},
                OrderedBigIntegerCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
