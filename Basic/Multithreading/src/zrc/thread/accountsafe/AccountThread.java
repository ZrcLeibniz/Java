package zrc.thread.accountsafe;

public class AccountThread extends Thread {
    private Account account;

    public AccountThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        double money = 5000;
        account.withDraw(5000);
        System.out.println(Thread.currentThread().getName() + "账户act-001取款成功，余额" + account.getBalance());
    }
}
