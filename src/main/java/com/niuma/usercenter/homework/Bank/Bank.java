package com.niuma.usercenter.homework.Bank;

public class Bank {

    private String name;

    private String account;

    private String password;

    private double balance;

    private double tradeMoney;

    public Bank() {
    }

    public Bank(String name, String account, String password, double balance, double tradeMoney) {
        this.name = name;
        this.account = account;
        this.password = password;
        this.balance = balance;
        this.tradeMoney = tradeMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getTradeMoney() {
        return tradeMoney;
    }

    public void setTradeMoney(double tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    // 欢迎用户
    public void welcome() {
        System.out.println("您好" + name + "银行欢迎您！！！");
    }

    // 用户离开
    public void quit() {
        System.out.println("欢迎您下次再来！！！");
    }

    // 存款
    public void deposit(double money) {
        if (money > balance) {
            System.out.println("对不起余额不足");
            return;
        }
        balance -= money;
        tradeMoney += money;
        System.out.println("取款成功！！！");

    }

    // 取款
    public void withdrawal(double money) {
        balance += money;
        tradeMoney += money;
        System.out.println("存款成功！！！");
    }
}
