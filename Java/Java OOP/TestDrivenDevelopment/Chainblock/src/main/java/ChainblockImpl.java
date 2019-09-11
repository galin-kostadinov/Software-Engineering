import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock {
    private Map<Integer, Transaction> transactions;

    public ChainblockImpl() {
        this.transactions = new LinkedHashMap<>();
    }

    public int getCount() {
        return transactions.size();
    }

    public void add(Transaction transaction) {
        if (!this.contains(transaction)) {
            this.transactions.put(transaction.getId(), transaction);
        }
    }

    public boolean contains(Transaction transaction) {
        return this.contains(transaction.getId());
    }

    public boolean contains(int id) {
        return this.transactions.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        if (!this.contains(id)) {
            throw new IllegalArgumentException();
        }
        this.transactions.get(id).setStatus(newStatus);
    }

    public void removeTransactionById(int id) {
        if (!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        this.transactions.remove(id);
    }

    public Transaction getById(int id) {
        if (!this.transactions.containsKey(id)) {
            throw new IllegalArgumentException();
        }

        return this.transactions.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> transactions = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> transactions = this.getByTransactionStatus(status);

        List<String> senders = new ArrayList<>();
        transactions.forEach(s -> senders.add(s.getFrom()));

        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> transactions = this.getByTransactionStatus(status);

        List<String> receivers = new ArrayList<>();
        transactions.forEach(s -> receivers.add(s.getTo()));

        return receivers;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return this.transactions
                .values()
                .stream()
                .sorted((f, s) -> {
                    int sort = Double.compare(s.getAmount(), f.getAmount());

                    if (sort == 0) {
                        sort = f.getId() - s.getId();
                    }

                    return sort;
                })
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        List<Transaction> transactions = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender))
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        List<Transaction> transactions = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getTo().equals(receiver))
                .sorted((f, s) -> {
                    int sort = Double.compare(s.getAmount(), f.getAmount());

                    if (sort == 0) {
                        sort = f.getId() - s.getId();
                    }

                    return sort;
                })
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getStatus().equals(status) && transaction.getAmount() <= amount)
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        List<Transaction> transactions = this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getFrom().equals(sender) && transaction.getAmount() > amount)
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        List<Transaction> transactions = this.transactions
                .values()
                .stream()
                .filter(transaction ->
                        transaction.getTo().equals(receiver)
                                && transaction.getAmount() >= lo
                                && transaction.getAmount() < hi)
                .sorted((f, s) -> Double.compare(s.getAmount(), f.getAmount()))
                .collect(Collectors.toList());

        if (transactions.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return transactions;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return this.transactions
                .values()
                .stream()
                .filter(transaction -> transaction.getAmount() >= lo && transaction.getAmount() <= hi)
                .collect(Collectors.toList());
    }

    public Iterator<Transaction> iterator() {
        return null;
    }
}
