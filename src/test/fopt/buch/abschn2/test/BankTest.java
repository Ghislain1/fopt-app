package fopt.buch.abschn2.test;

import org.junit.jupiter.api.Test;

import fopt.buch.abschn2.Bank;

public class BankTest
{
    @Test
    void transferMoney_should_run_successfully()
    {
	Bank bank = new Bank();

	bank.transferMoney(1, 100);

    }

    @Test
    void transferMoney_should_fail_successfully()
    {
	Bank bank = new Bank();

	bank.transferMoney(10000, 100);

    }
}
