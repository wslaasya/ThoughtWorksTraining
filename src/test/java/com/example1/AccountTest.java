package com.example1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.DoubleHolder;

/**
 * Created by wunul on 01-04-2016.
 */
public class AccountTest {
    private String name;
    private Double balance;
    Account account;
    @Before
    public void commonData()
    {
        name = "AccountHolderName";
        balance = 12000.0;
        account = new Account(name,balance);
    }
    @Test
    public void deductAmountFromBalance() throws Exception {
//        String name = "accountHolderName";
//        Double balance = 12000.0;
//        Account account = new Account(name , balance);
        account.withdraw(3000.0);

        Assert.assertEquals(9000.0 , account.getBalanceAmount(),0.01);
    }
    @Test(expected = Exception.class)
    public void deductMoreAmountThanBalance() throws Exception{
//        String name = "accountHolderName";
//        Double balance = 12000.0;
//        Account ac = new Account(name,balance);
        account.withdraw(15000.0);
        //Assert.assertNotEquals();
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetExceptionWhenInvalidAmoutGivenForWithdraw() throws Exception {
        account.withdraw(-1000.0);
    }

    @Test
    public void putDeposit() throws Exception {
        account.deposit(500);
        Assert.assertEquals(12500.0, account.getBalanceAmount(), 0.01);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldGetExceptionWhenInvalidAmoutGivenForDeposit() throws Exception {
        account.deposit(-1000.0);
    }
}
