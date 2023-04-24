import java.util.Random;

public class Transaction implements Runnable {
    private final Account account;
    private final String type;
    private final int amount;

    public Transaction(Account account, String type, int amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run() {
        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(1000)); // simulate some delay
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (type.equals("deposit")) {
            account.deposit(amount);
        } else if (type.equals("withdraw")) {
            account.withdraw(amount);
        }
    }
}
