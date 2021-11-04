package root.account;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {
    Account account;

    @BeforeEach
    void preparation() {
        account = new Account();
    }

    @Test
    void ifUnblockedAndMoreThanNegativeMaximum(){
        System.out.println("Test 1");
        //preparation
        account.balance = -1250;

        assertFalse(account.isBlocked());
        assertFalse(account.withdraw(10000));
        assertEquals(-1250,account.getBalance());
    }

    @Test
    void ifUnblockedAndTryToChangeMaxCredit(){
        System.out.println("Test 2");
        account.blocked = false;
        account.balance = 0;

        assertFalse(account.setMaxCredit(5000));
        assertEquals(1000,account.getMaxCredit());
    }

    @Test
    void setMaxCreditAboveMillion(){
        System.out.println("Test 3");
        account.maxCredit = -1000;

        assertFalse(account.setMaxCredit(1200000));
        assertFalse(account.setMaxCredit(-1200000));
        assertEquals(1000,account.getMaxCredit());
    }

    @Test
    void setMaxCreditThanOk(){
        System.out.println("Test 4");
        account.block();

        assertTrue(account.setMaxCredit(1200));
        assertEquals(1200, account.getMaxCredit());

        assertTrue(account.setMaxCredit(-1500));
        assertEquals(-1500, account.getMaxCredit());
    }

    @Test
    void WhenUnblockAccount(){
        System.out.println("Test 5");

        account.block();
        account.balance = -3000;

        assertFalse(account.unblock());

        account.setMaxCredit(1000);
        account.balance = 0;

        assertTrue(account.unblock());
    }

    @Test
    void NegativeWithdrawAndDepositParameter(){
        System.out.println("Test 6");
        account.blocked = false;
        account.balance = 10000;

        assertFalse(account.deposit(-1250));
        assertEquals(10000, account.getBalance());

        assertFalse(account.deposit(5000000));
        assertEquals(10000, account.getBalance());

        assertFalse(account.withdraw(-5000));
        assertEquals(10000, account.getBalance());

        assertFalse(account.withdraw(2000000));
        assertEquals(10000, account.getBalance());
    }

    @Test
    void ifDepositOrWithdrawBeyondBound(){
        System.out.println("Test 7");
        account.balance = 500000;
        account.blocked = false;
        account.bound = 1000000;

        assertFalse(account.deposit(750000));
        assertEquals(500000, account.getBalance());
    }

    @Test
    void ifAccountIsBlocked(){
        System.out.println("Test 8");
        account.balance = -10000;
        account.block();

        assertFalse(account.deposit(500000));
        assertEquals(-10000, account.getBalance());

        assertFalse(account.withdraw(50000));
        assertEquals(-10000, account.getBalance());
    }

    @AfterEach
    void tearDown() {
        System.out.println("End of tests");
    }
}