import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000);
        ArrayList<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(account, "deposit", 200));
        transactions.add(new Transaction(account, "withdraw", 500));
        transactions.add(new Transaction(account, "withdraw", 700));
        transactions.add(new Transaction(account, "deposit", 100));

        ExecutorService executorService = Executors.newFixedThreadPool(transactions.size());

        for (Transaction transaction : transactions) {
            executorService.execute(transaction);
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // wait for all threads to finish
        }

        System.out.println("Final balance is " + account.getBalance());
    }
}
