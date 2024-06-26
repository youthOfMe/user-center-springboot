package com.niuma.usercenter.homework;


public class FindPrimeNumber {

    public static void main(String[] args) {
        int rightNum = 100;
        boolean flag = true;

        System.out.println(2);
        for (int i = 3; i <= rightNum; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println(i);
            }
            flag = true;
        }
    }

}
