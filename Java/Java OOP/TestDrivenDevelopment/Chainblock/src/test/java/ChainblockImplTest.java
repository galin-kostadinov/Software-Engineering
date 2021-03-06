import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChainblockImplTest {
    private Chainblock chainblock;

    private static final int ID = 1;
    private static final TransactionStatus SUCCESSFUL_STATUS = TransactionStatus.SUCCESSFUL;
    private static String SENDER = "Anatoly";
    private static String RECEIVER = "Paraskeva";
    private static double INITIAL_AMOUNT = 100.00;

    private static final int[] IDS = {1, 2, 3, 4, 5, 6};
    private static final String[] NAMES = {"A", "B", "C", "D", "E", "F"};
    private static final double[] AMOUNTS = {10, 20, 30, 40, 50, 60};

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
        this.addTransactions(ELEMENTS_COUNT);
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

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowAnExceptionWithIvalidID() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        this.chainblock.removeTransactionById(ID + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeTransactionByIdShouldThrowAnExceptionOnEmptyDatabase() {
        new ChainblockImpl().removeTransactionById(ID);
    }

    @Test
    public void removeTransactionByIdShouldRemoveCorrectly() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        this.chainblock.removeTransactionById(ID);

        Assert.assertEquals(0, this.chainblock.getCount());
    }

    @Test
    public void removeTransactionByIdShouldRemoveTheCorrectTransaction() {
        final int ELEMENTS_COUNT = 10;
        this.addTransactions(ELEMENTS_COUNT);

        this.chainblock.removeTransactionById(ELEMENTS_COUNT - 1);

        Assert.assertFalse(this.chainblock.contains(ELEMENTS_COUNT - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByIdShouldThrowAnExceptionOnEmptyDatabase() {
        new ChainblockImpl().getById(ID);
    }

    @Test
    public void getByIdShouldReturnCorrectTransactionWithSingleElement() {
        this.chainblock.add(TRANSACTION_ID_ONE);
        Transaction returnedTransaction = this.chainblock.getById(ID);

        Assert.assertEquals(TRANSACTION_ID_ONE.getId(), returnedTransaction.getId());
    }

    @Test
    public void getByIdShouldReturnTheCorrectTransaction() {
        final int ELEMENTS_COUNT = 10;
        this.addTransactions(ELEMENTS_COUNT);

        Transaction returnedTransaction = this.chainblock.getById(ELEMENTS_COUNT - 1);

        Assert.assertEquals(ELEMENTS_COUNT - 1, returnedTransaction.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByTransactionStatusShouldThrowAnExceptionIfThereAreNoTransactionsWithGivenStatus() {
        final int ELEMENTS_COUNT = 10;
        this.addTransactions(ELEMENTS_COUNT);
        this.chainblock.getByTransactionStatus(TransactionStatus.values()[(SUCCESSFUL_STATUS.ordinal() + 1) % TransactionStatus.values().length]);
    }

    @Test
    public void getTransactionStatusShouldReturnAllTransactionsWithGivenStatus() {
        final int ELEMENTS_COUNT = 8;
        this.addTransactions(ELEMENTS_COUNT);
        this.chainblock.add(new TransactionImpl(
                ID * 123, TransactionStatus.UNAUTHORIZED, "Milen", "Stefan", 10.0));

        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(SUCCESSFUL_STATUS);

        int count = 0;
        for (Transaction transaction : transactions) {
            count++;
        }

        Assert.assertEquals(ELEMENTS_COUNT, count);
    }

    @Test
    public void getTransactionStatusShouldReturnAllTransactionsWithGivenStatusOrderedDescendingByAmount() {
        final int ELEMENTS_COUNT = 12;
        this.addTransactionsWithDiffAmount(ELEMENTS_COUNT);

        Iterable<Transaction> transactions = this.chainblock.getByTransactionStatus(SUCCESSFUL_STATUS);

        boolean areOrdered = true;
        double amount = Double.POSITIVE_INFINITY;

        for (Transaction transaction : transactions) {
            if (amount < transaction.getAmount()) {
                areOrdered = false;
            } else {
                amount = transaction.getAmount();
            }
        }

        Assert.assertTrue(areOrdered);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getAllSendersWithTransactionStatusShouldThrowAnExceptionWhenNoTransactionsWithGivenStatusArePresent() {
        final int ELEMENTS_COUNT = 15;
        this.addTransactionsWithDiffAmount(ELEMENTS_COUNT);
        this.chainblock.getAllSendersWithTransactionStatus(
                TransactionStatus.values()[(SUCCESSFUL_STATUS.ordinal() + 1) % TransactionStatus.values().length]);
    }


    @Test
    public void getAllSendersWithTransactionStatusShouldReturnCorrectNames() {
        for (int i = 0; i < IDS.length; i++) {
            chainblock.add(new TransactionImpl(IDS[i], SUCCESSFUL_STATUS, NAMES[i], NAMES[i], AMOUNTS[i]));
        }

        Iterable<String> receivers = this.chainblock.getAllSendersWithTransactionStatus(SUCCESSFUL_STATUS);

        int index = NAMES.length - 1;
        boolean areEqual = true;
        for (String receiver : receivers) {
            if (!receiver.equals(NAMES[index--])) {
                areEqual = false;
                break;
            }
        }

        Assert.assertTrue(areEqual);
    }


    @Test(expected = IllegalArgumentException.class)
    public void getAllReceiversWithTransactionStatusShouldThrowAnExceptionWhenNoTransactionsWithGivenStatusArePresent() {
        final int ELEMENTS_COUNT = 15;
        this.addTransactionsWithDiffAmount(ELEMENTS_COUNT);
        this.chainblock.getAllReceiversWithTransactionStatus(
                TransactionStatus.values()[(SUCCESSFUL_STATUS.ordinal() + 1) % TransactionStatus.values().length]);
    }


    @Test
    public void getAllReceiversWithTransactionStatusShouldReturnCorrectNames() {
        for (int i = 0; i < IDS.length; i++) {
            chainblock.add(new TransactionImpl(IDS[i], SUCCESSFUL_STATUS, NAMES[i], NAMES[i], AMOUNTS[i]));
        }

        Iterable<String> receivers = this.chainblock.getAllReceiversWithTransactionStatus(SUCCESSFUL_STATUS);

        int index = NAMES.length - 1;
        boolean areEqual = true;
        for (String receiver : receivers) {
            if (!receiver.equals(NAMES[index--])) {
                areEqual = false;
                break;
            }
        }

        Assert.assertTrue(areEqual);
    }


    @Test
    public void getAllOrderedByAmountDescendingThenByIdShouldReturnSortedElements() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, SENDER, RECEIVER, 200);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);

        int[] expectedIds = {4, 2, 1, 3};

        Iterable<Transaction> ordered = this.chainblock.getAllOrderedByAmountDescendingThenById();

        int index = 0;
        for (Transaction transaction : ordered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderOrderedByAmountDescendingShouldThrowExceptionIfGivenSenderNotPresent() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, "A", RECEIVER, 100);
        this.chainblock.add(t1);

        this.chainblock.getBySenderOrderedByAmountDescending(SENDER);
    }

    @Test
    public void getBySenderOrderedByAmountDescendingShouldReturnTransactionsFromGivenSenderOrdered() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 120);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, "A", RECEIVER, 200);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);

        Iterable<Transaction> getOrdered = this.chainblock.getBySenderOrderedByAmountDescending(SENDER);

        int[] expectedIds = {2, 3, 1};

        int index = 0;
        for (Transaction transaction : getOrdered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverOrderedByAmountThenByldThrowExceptionIfGivenReceiverNotPresent() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, "B", 100);
        this.chainblock.add(t1);

        this.chainblock.getByReceiverOrderedByAmountThenById(RECEIVER);
    }

    @Test
    public void getByReceiverOrderedByAmountThenByIdShouldReturnTransactionsFromGivenReceiverOrdered() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 120);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t5 = new TransactionImpl(5, SUCCESSFUL_STATUS, SENDER, "A", 200);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);
        this.chainblock.add(t5);

        Iterable<Transaction> getOrdered = this.chainblock.getByReceiverOrderedByAmountThenById(RECEIVER);

        int[] expectedIds = {2, 3, 1, 4};

        int index = 0;
        for (Transaction transaction : getOrdered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnEmptyDatabase() {
        new ChainblockImpl().getByTransactionStatusAndMaximumAmount(SUCCESSFUL_STATUS, INITIAL_AMOUNT);
    }

    @Test
    public void getByTransactionStatusAndMaximumAmountShouldReturnTransactionsFromGivenReceiverOrdered() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 120);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t5 = new TransactionImpl(5, TransactionStatus.UNAUTHORIZED, SENDER, "A", 10);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);
        this.chainblock.add(t5);

        Iterable<Transaction> getOrdered =
                this.chainblock.getByTransactionStatusAndMaximumAmount(SUCCESSFUL_STATUS, 150);

        int[] expectedIds = {2, 3, 1, 4};

        int index = 0;
        for (Transaction transaction : getOrdered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getBySenderAndMinimumAmountDescendingShouldThrowExceptionIfThereIsNotSuchTransaction() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, "B", RECEIVER, 100);
        this.chainblock.add(t1);
        this.chainblock.getBySenderAndMinimumAmountDescending(SENDER, 110);
    }

    @Test
    public void getBySenderAndMinimumAmountDescendingShouldReturnTransactionsFromGivenSenderOrdered() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 120);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t5 = new TransactionImpl(5, SUCCESSFUL_STATUS, "A", RECEIVER, 10);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);
        this.chainblock.add(t5);

        Iterable<Transaction> getOrdered =
                this.chainblock.getBySenderAndMinimumAmountDescending(SENDER, 90);

        int[] expectedIds = {2, 3, 1, 4};

        int index = 0;
        for (Transaction transaction : getOrdered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getByReceiverAndAmountRangeShouldThrowExceptionIfThereIsNotSuchTransaction() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, "B", "B", 100);
        this.chainblock.add(t1);
        this.chainblock.getByReceiverAndAmountRange(RECEIVER, 50, 110);
    }

    @Test
    public void getByReceiverAndAmountRangeShouldReturnTransactionsFromGivenReceiverOrdered() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 120);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t5 = new TransactionImpl(5, SUCCESSFUL_STATUS, SENDER, "A", 10);
        Transaction t6 = new TransactionImpl(6, SUCCESSFUL_STATUS, SENDER, RECEIVER, 160);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);
        this.chainblock.add(t5);
        this.chainblock.add(t6);

        Iterable<Transaction> getOrdered =
                this.chainblock.getByReceiverAndAmountRange(RECEIVER, 100, 160);

        int[] expectedIds = {2, 3, 1, 4};

        int index = 0;
        for (Transaction transaction : getOrdered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    @Test
    public void getAllInAmountRangeShouldReturnEmptyDatabase() {
        new ChainblockImpl().getAllInAmountRange(100, 200);
    }

    @Test
    public void getAllInAmountRangeShouldReturnAllTransactionsInGivenRange() {
        Transaction t1 = new TransactionImpl(1, SUCCESSFUL_STATUS, SENDER, RECEIVER, 100);
        Transaction t2 = new TransactionImpl(2, SUCCESSFUL_STATUS, SENDER, RECEIVER, 150);
        Transaction t3 = new TransactionImpl(3, SUCCESSFUL_STATUS, SENDER, RECEIVER, 120);
        Transaction t4 = new TransactionImpl(4, SUCCESSFUL_STATUS, SENDER, RECEIVER, 90);
        Transaction t5 = new TransactionImpl(5, SUCCESSFUL_STATUS, SENDER, RECEIVER, 200);

        this.chainblock.add(t1);
        this.chainblock.add(t2);
        this.chainblock.add(t3);
        this.chainblock.add(t4);
        this.chainblock.add(t5);

        Iterable<Transaction> getOrdered =
                this.chainblock.getAllInAmountRange(100, 150);

        int[] expectedIds = {1, 2, 3};

        int index = 0;
        for (Transaction transaction : getOrdered) {
            Assert.assertEquals(expectedIds[index++], transaction.getId());
        }

        Assert.assertEquals(expectedIds.length, index);
    }

    private void addTransactions(int count) {
        for (int i = 1; i <= count; i++) {
            this.chainblock.add(new TransactionImpl(i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT));
        }
    }

    private void addTransactionsWithDiffAmount(int count) {
        for (int i = 1; i <= count; i++) {
            this.chainblock.add(new TransactionImpl(i, SUCCESSFUL_STATUS, SENDER, RECEIVER, INITIAL_AMOUNT * i));
        }
    }
}