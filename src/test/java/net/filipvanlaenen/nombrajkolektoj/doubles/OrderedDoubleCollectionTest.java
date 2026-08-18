package net.filipvanlaenen.nombrajkolektoj.doubles;

import static net.filipvanlaenen.kolektoj.Collection.ElementCardinality.DISTINCT_ELEMENTS;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Objects;

import org.junit.jupiter.api.Test;

import net.filipvanlaenen.kolektoj.Collection.ElementCardinality;
import net.filipvanlaenen.kolektoj.EmptyArrays;
import net.filipvanlaenen.kolektoj.OrderedCollection;

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
     * The double six.
     */
    private static final Double DOUBLE_SIX = 6D;
    /**
     * Array with the doubles zero, one and two.
     */
    private static final Double[] DOUBLES012 = new Double[] {0D, 1D, 2D};
    /**
     * Array with the doubles one, two and three.
     */
    private static final Double[] DOUBLES123 = new Double[] {1D, 2D, 3D};
    /**
     * Collection with the doubles 0, 1 and 2.
     */
    private final OrderedDoubleCollection collection012 = createDoubleCollection(0D, 1D, 2D);
    /**
     * Collection with the double 1.
     */
    private final OrderedDoubleCollection collection1 = createDoubleCollection(1D);
    /**
     * Collection with the doubles 1 and 2.
     */
    private final OrderedDoubleCollection collection12 = createDoubleCollection(1D, 2D);
    /**
     * Collection with the doubles 1, 2 and 3.
     */
    private final OrderedDoubleCollection collection123 = createDoubleCollection(1D, 2D, 3D);

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final Double... numbers) {
        return OrderedDoubleCollection.of(numbers);
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return OrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final ElementCardinality elementCardinality,
            final OrderedDoubleCollection source) {
        return OrderedDoubleCollection.of(elementCardinality,
                OrderedDoubleCollection.of(source.toArray(EmptyArrays.DOUBLES)));
    }

    @Override
    protected OrderedDoubleCollection createDoubleCollection(final OrderedDoubleCollection source) {
        return OrderedDoubleCollection.of(source.getElementCardinality(), source.toArray(EmptyArrays.DOUBLES));
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final ElementCardinality elementCardinality,
            final Double... numbers) {
        return OrderedDoubleCollection.of(elementCardinality, numbers);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final OrderedDoubleCollection source) {
        return OrderedDoubleCollection.of(source);
    }

    @Override
    protected OrderedDoubleCollection createOrderedDoubleCollection(final OrderedDoubleCollection source,
            final int fromIndex, final int toIndex) {
        return OrderedDoubleCollection.of(source, fromIndex, toIndex);
    }

    /**
     * Verifies that the intersection of one collection is that collection.
     */
    @Test
    public void intersectionOfOneCollectionShouldBeTheSameCollection() {
        assertTrue(collection123.containsSame(OrderedDoubleCollection.intersectionOf(collection123)));
    }

    /**
     * Verifies that the intersection of three collections only contains the common elements.
     */
    @Test
    public void intersectionOfThreeCollectionsShouldOnlyContainTheCommonElements() {
        assertTrue(
                collection1.containsSame(OrderedCollection.intersectionOf(collection123, collection1, collection12)));
    }

    /**
     * Verifies that the matrix direct product factory method produces a correct ordered doubles collection.
     */
    @Test
    public void ofMatrixDirectProductShouldProduceACorrectOrderedCollection() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.matrixDirectProductOf(collection12, collection123);
        assertArrayEquals(new Double[] {1D, 2D, DOUBLE_THREE, 2D, DOUBLE_FOUR, DOUBLE_SIX}, actual.toArray());
    }

    /**
     * Verifies that <code>ofMatrixDirectProduct</code> throws an exception when called with a collection containing
     * <code>null</code>.
     */
    @Test
    public void ofMatrixDirectProductShouldThrowExceptionWhenCollectionContainsNull() {
        OrderedDoubleCollection collectionB = OrderedDoubleCollection.of(1D, null, DOUBLE_THREE);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedDoubleCollection.matrixDirectProductOf(collection12, collectionB));
        assertEquals("Cannot produce a matrix direct product when one of the collections contains null.",
                exception.getMessage());
        exception = assertThrows(IllegalArgumentException.class,
                () -> OrderedDoubleCollection.matrixDirectProductOf(collectionB, collection12));
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

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates an empty collection when
     * the number of elements is less than one.
     */
    @Test
    public void createSequenceWithIndexShouldProduceAnEmptyCollectionWhenTheNumberOfElementsIsLessThanOne() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(i -> DOUBLES012[i], 0);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithOneElement() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(i -> DOUBLES012[i], 1);
        assertArrayEquals(new Double[] {0D}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and number of elements creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithIndexShouldProduceACollectionWithTwoElements() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(i -> DOUBLES012[i], 2);
        assertArrayEquals(new Double[] {0D, 1D}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates an empty collection when the
     * number of elements is less than one.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionIndexShouldProduceAnEmptyCollection() {
        OrderedDoubleCollection actual = OrderedDoubleCollection.createSequence(i -> DOUBLES012[i], n -> false);
        assertTrue(actual.isEmpty());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with one
     * element.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithOneElement() {
        OrderedDoubleCollection actual =
                OrderedDoubleCollection.createSequence(i -> DOUBLES012[i], n -> !Objects.equals(n, 1D));
        assertArrayEquals(new Double[] {0D}, actual.toArray());
    }

    /**
     * Verifies that <code>createSequence</code> with generator and while condition creates a collection with two
     * elements.
     */
    @Test
    public void createSequenceWithGeneratorAndWhileConditionShouldProduceACollectionWithTwoElements() {
        OrderedDoubleCollection actual =
                OrderedDoubleCollection.createSequence(i -> DOUBLES012[i], n -> !Objects.equals(n, 2D));
        assertArrayEquals(new Double[] {0D, 1D}, actual.toArray());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsShouldBeEmpty() {
        assertTrue(OrderedDoubleCollection.unionOf().isEmpty());
    }

    /**
     * Verifies that the union of no collections is an empty collection.
     */
    @Test
    public void unionOfNoCollectionsWithElementCardinalityShouldBeEmpty() {
        assertTrue(OrderedDoubleCollection.unionOf(DISTINCT_ELEMENTS).isEmpty());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsShouldBeItself() {
        assertArrayEquals(DOUBLES123, OrderedDoubleCollection.unionOf(collection123).toArray());
    }

    /**
     * Verifies that the union of one collections is the collection itself.
     */
    @Test
    public void unionOfOneCollectionsWithElementCardinalityShouldBeItself() {
        assertArrayEquals(DOUBLES123, OrderedDoubleCollection.unionOf(DISTINCT_ELEMENTS, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all elements.
     */
    @Test
    public void unionOfTwoCollectionsShouldContainAllElements() {
        assertArrayEquals(new Double[] {0D, 1D, 2D, 1D, 2D, DOUBLE_THREE},
                OrderedDoubleCollection.unionOf(collection012, collection123).toArray());
    }

    /**
     * Verifies that the union of two collections is a collection with all distinct elements.
     */
    @Test
    public void unionOfTwoCollectionsWithElementCardinalityShouldContainAllDistinctElements() {
        assertArrayEquals(new Double[] {0D, 1D, 2D, DOUBLE_THREE},
                OrderedDoubleCollection.unionOf(DISTINCT_ELEMENTS, collection012, collection123).toArray());
    }
}
