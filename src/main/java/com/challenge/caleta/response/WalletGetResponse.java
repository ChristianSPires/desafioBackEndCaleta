package com.challenge.caleta.response;

public class WalletGetResponse {
    private Long player;
    private double balance;

    public WalletGetResponse(Long player, double balance) {
        this.player = player;
        this.balance = balance;
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
}
