package com.atguigu.java;

import java.io.Serializable;

/**
 * @author fengzitao
 * @date 2022/01/10
 */
public class Account implements Serializable {
        public static final long serialVersionUID = 4754534532L;
        private double balance;

        @Override
        public String toString() {
            return "Account{" +
                    "balance=" + balance +
                    '}';
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }

        public Account(double balance) {

            this.balance = balance;
        }
}

