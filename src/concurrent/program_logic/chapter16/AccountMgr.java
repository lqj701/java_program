package concurrent.program_logic.chapter16;

import java.util.Random;

public class AccountMgr {
    public static class NoenoughMoneyException extends Exception {
    }

    public static void transfer(Account from, Account to, double money) throws NoenoughMoneyException {

        // from.lock();
        // try {
        // to.lock();
        // try {
        // if (from.getMoney() >= money) {
        // from.reduce(money);
        // to.add(money);
        // } else {
        // throw new NoenoughMoneyException();
        // }
        // } finally {
        // to.unLock();
        // }
        // } finally {
        // from.unLock();
        // }

        boolean success = false;
        do {
            success = tryTransfer(from, to, money);
            if (!success) {
                Thread.yield();
            }
        } while (!success);
    }

    public static void simulateDeadLock() {
        final int accountNum = 10;
        final Account[] accounts = new Account[accountNum];

        final Random rnd = new Random();
        for (int i = 0; i < accountNum; i++) {
            accounts[i] = new Account(rnd.nextInt(10000));
        }

        int threadNum = 100;
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread() {
                @Override
                public void run() {
                    int loopNum = 100;
                    for (int k = 0; k < loopNum; k++) {
                        int i = rnd.nextInt(accountNum);
                        int j = rnd.nextInt(accountNum);
                        int money = rnd.nextInt(10);

                        if (i != j) {
                            try {
                                transfer(accounts[i], accounts[j], money);
                                System.out.println(accounts[i].getMoney());
                                System.out.println(accounts[j].getMoney());
                            } catch (NoenoughMoneyException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            };
            threads[i].start();
        }
    }

    public static boolean tryTransfer(Account from, Account to, double money) throws NoenoughMoneyException {
        if (from.tryLock()) {
            try {
                if (to.tryLock()) {
                    try {
                        if (from.getMoney() >= money) {
                            from.reduce(money);
                            to.add(money);
                        } else {
                            throw new NoenoughMoneyException();
                        }
                        return true;
                    } finally {
                        to.unLock();
                    }
                }
            } finally {
                from.unLock();
            }
        }
        return false;
    }

    public static void main(String[] args) throws NoenoughMoneyException {
        simulateDeadLock();
        // Account from = new Account(1000);
        // Account to = new Account(0);
        //
        // transfer(from, to, 100.0);
        // System.out.println(from.getMoney());
        // System.out.println(to.getMoney());
    }
}
