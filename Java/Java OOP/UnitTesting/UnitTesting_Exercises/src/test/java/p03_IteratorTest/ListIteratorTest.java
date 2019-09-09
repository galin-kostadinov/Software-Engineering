package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] VALUES = {"A", "B", "C", "D", "E"};

    @Before
    public void createList() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(VALUES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void creatingListIteratorShouldThrowExceptionIfNullIsPassedToTheConstructor() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void moveShouldReturnTrueIfAbelToMove() {
        for (int i = 0; i < VALUES.length - 1; i++) {
            Assert.assertTrue(listIterator.move());
        }
    }

    @Test
    public void moveShouldReturnFalseIfNoNextElement() {
        for (int i = 0; i < VALUES.length - 1; i++) {
            listIterator.move();
        }

        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void hasNextShouldReturnTrueIfHasNext() throws OperationNotSupportedException {
        ListIterator list = new ListIterator("A", "B");

        Assert.assertTrue(list.hasNext());
    }

    @Test
    public void hasNextShouldReturnFalseIfNotHasNext() throws OperationNotSupportedException {
        ListIterator list = new ListIterator("A");

        Assert.assertFalse(list.hasNext());
    }

    @Test(expected = IllegalStateException.class)
    public void printShouldThrowExceptionOnEmptyCollection() throws OperationNotSupportedException {
        new ListIterator().print();
    }

    @Test
    public void printShouldReturnCorrectElement() throws OperationNotSupportedException {
        ListIterator list = new ListIterator("A");

        Assert.assertEquals(list.print(), "A");
    }
}