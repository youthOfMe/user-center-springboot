package com.niuma.usercenter.homework.Bank;

public class Test {

    public static void main(String[] args) {

        Bank bank = new Bank("超级银行", "123456qq", "123456qq", 158.88, 9);
        bank.welcome();
        bank.withdrawal(12);
        bank.deposit(188.0);
        bank.deposit(18);
        bank.quit();

    }

}
