package com.challenge.caleta.dto;

public class RollbackRequest {
    private Long player;
    private Long txn;
    private double value;

    public RollbackRequest() {
    }

    public RollbackRequest(Long player, Long txn, double value) {
        this.player = player;
        this.txn = txn;
        this.value = value;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public Long getTxn() {
        return txn;
    }

    public void setTxn(Long txn) {
        this.txn = txn;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}