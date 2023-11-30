package com.challenge.caleta.response;

public class WalletRollbackResponse {

    private String code;

    private double balance;

    public WalletRollbackResponse(String code, double balance) {
        this.code = code;
        this.balance = balance;
    }

    public WalletRollbackResponse(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
