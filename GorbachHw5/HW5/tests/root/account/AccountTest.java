package root.account;


import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {

    Account account = new Account();

    @Test
    public void simpleDeposit() {
        //простой проверочный депозит

        assertTrue(account.deposit(5000));

        assertTrue(account.deposit(350000));

        account.balance = 0;
    }

    @Test
    public void simpleWithdraw() {
        //простой проверочный вывод

        account.balance = 400000;

        assertTrue(account.withdraw(5000));

        assertTrue(account.withdraw(350000));

        account.balance = 0;
    }

    @Test
    public void ifUnblockedAndMoreThanNegativeMaximum(){
        //тест если счет разблокирован и сумма меньше лимита на блокировку
        //preparation
        account.balance = -1250;

        assertFalse(account.isBlocked());
        assertFalse(account.withdraw(10000));
        assertEquals(-1250,account.getBalance());
    }

    @Test
    public void ifUnblockedAndTryToChangeMaxCredit(){
        //Если счет разблокирован и осуществляется попытка изменения maxCredit
        account.blocked = false;
        account.balance = 0;

        assertFalse(account.setMaxCredit(5000));
        assertEquals(1000,account.getMaxCredit());
    }

    @Test
    public void setMaxCreditAboveMillion(){
        //попытка сделать maxCredit гиганстким
        account.maxCredit = -1000;

        assertFalse(account.setMaxCredit(1200000));
        assertFalse(account.setMaxCredit(-1200000));
        assertEquals(1000,account.getMaxCredit());
    }

    @Test
    public void setMaxCreditThanOk(){
        //попытка успешной замены maxCredit
        account.block();

        assertTrue(account.setMaxCredit(1200));
        assertEquals(1200, account.getMaxCredit());

        assertTrue(account.setMaxCredit(-1500));
        assertEquals(-1500, account.getMaxCredit());
    }

    @Test
    public void WhenUnblockAccount(){
        //попытка разблокировки аккаунта при разных балансах
        account.block();
        account.balance = -3000;

        assertFalse(account.unblock());

        account.setMaxCredit(1000);
        account.balance = 0;

        assertTrue(account.unblock());
    }

    @Test
    public void NegativeWithdrawAndDepositParameter(){
        //попытка вывести или ввести отрицательный баланс
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
    public void ifDepositOrWithdrawBeyondBound(){
        //если вывод или ввод больше верхней границы
        account.balance = 500000;
        account.blocked = false;
        account.bound = 1000000;

        assertFalse(account.deposit(750000));
        assertEquals(500000, account.getBalance());

        assertFalse(account.deposit(1200000));
        assertEquals(500000, account.getBalance());

        assertTrue(account.withdraw(350000));
        assertEquals(150000, account.getBalance());
        //добавим немного чтобы баланс был больше миллиона
        account.balance = 1200000;

        assertFalse(account.withdraw(1100000));
        assertEquals(1200000, account.getBalance());
    }

    @Test
    public void ifAccountIsBlocked(){
        //попытка преодолеть действия если аккаунт заблокирован
        account.balance = -10000;
        account.block();

        assertFalse(account.deposit(500000));
        assertEquals(-10000, account.getBalance());

        assertFalse(account.withdraw(50000));
        assertEquals(-10000, account.getBalance());
    }
}