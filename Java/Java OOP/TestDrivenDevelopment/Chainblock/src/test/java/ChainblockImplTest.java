import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.zip.DeflaterOutputStream;

public class ChainblockImplTest {
    private Chainblock chainblock;

    private static final int ID = 1;
    private static final TransactionStatus SUCCESSFUL_STATUS = TransactionStatus.SUCCESSFUL;
    private static String SENDER = "Anatoly";
    private static String RECEIVER = "Paraskeva";
    private static double INITIAL_AMOUNT = 100.00;

    private static final Transaction TRANSACTION_ID_ONE =
            new TransactionImpl(ID,
                    SUCCESSFUL_STATUS,
                    SENDER,
                    RECEIVER,
                    INITIAL_AMOUNT);

    @Before
    public void createChainblock() {
        chainblock = new ChainblockImpl();
    }

    public void addSingleTransaction() {
        this.chainblock.add(TRANSACTION_ID_ONE);
    }

    @Test
    public void addShouldIncreaseCount() {
        final int EXPECTED_COUNT = 1;
        this.addSingleTransaction();
        Assert.assertEquals(EXPECTED_COUNT, this.chainblock.getCount());
    }

    @Test
    public void containsByIdShouldReturnTrueIfTransactionIsPresent() {
        this.addSingleTransaction();
        Assert.assertTrue(this.chainblock.contains(TRANSACTION_ID_ONE.getId()));
    }

    @Test
    public void containsByIdShouldReturnFalseIfTransactionNotPresent() {
        Assert.assertFalse(this.chainblock.contains(TRANSACTION_ID_ONE.getId()));
    }

    @Test
    public void containsByTransactionShouldReturnTrueIfTransactionIsPresent() {
        this.addSingleTransaction();
        Assert.assertTrue(this.chainblock.contains(TRANSACTION_ID_ONE.getId()));
    }

    @Test
    public void getCountShouldReturnZeroOnEmpltyDatabase() {
        Assert.assertEquals(0, this.chainblock.getCount());
    }

    @Test
    public void getCountShouldReturnOneWhenAddingTheSameTransactionMultipleTimes() {
        for (int i = 0; i < 10; i++) {
            this.chainblock.add(TRANSACTION_ID_ONE);
        }
        Assert.assertEquals(1, this.chainblock.getCount());
    }

    @Test
    public void getCountShouldWorkProperlyWithTenElements() {
        final int ELEMENTS_COUNT = 10;
        for (int i = 1; i <= 10; i++) {
            this.chainblock.add(new TransactionImpl(i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT));
        }
        Assert.assertEquals(ELEMENTS_COUNT, this.chainblock.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void changeTransactionStatusShouldThrowExceptionWithInvalidTransactionId() {
        this.chainblock.add(TRANSACTION_ID_ONE);

        TransactionStatus newStatus =
                TransactionStatus.values()[(SUCCESSFUL_STATUS.ordinal() + 1) % TransactionStatus.values().length];
        this.chainblock.changeTransactionStatus(ID + 1, newStatus);
    }

    @Test
    public void changeTransactionStatusShouldChangeStatusCorrectly() {
        this.chainblock.add(TRANSACTION_ID_ONE);

        TransactionStatus newStatus =
                TransactionStatus.values()[(SUCCESSFUL_STATUS.ordinal() + 1) % TransactionStatus.values().length];
        this.chainblock.changeTransactionStatus(ID, newStatus);

        Assert.assertEquals(newStatus, TRANSACTION_ID_ONE.getStatus());
    }
}