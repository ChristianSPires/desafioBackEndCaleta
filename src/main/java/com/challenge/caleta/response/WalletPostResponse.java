package com.challenge.caleta.response;

public class WalletPostResponse {

    private Long player;
    private double balance;
    private Long txn;

    public WalletPostResponse(Long player, double balance, Long txn) {
        this.player = player;
        this.balance = balance;
        this.txn = txn;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Long getTxn() {
        return txn;
    }

    public void setTxn(Long txn) {
        this.txn = txn;
    }
}
