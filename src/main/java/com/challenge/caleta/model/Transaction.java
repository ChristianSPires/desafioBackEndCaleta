package com.challenge.caleta.model;

import com.challenge.caleta.controller.PlayerController;
import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer txn;

    private double value;

    private boolean active;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private Player player;

    public Transaction() {
    }

    public Transaction(Player player, double amount, PlayerController.TransactionType type) {
        this.player = player;
    }

    public Transaction(Integer txn, double value) {
        this.txn = txn;
        this.value = value;
    }

    public Transaction(Long id, double betAmount, PlayerController.TransactionType transactionType) {
    }

    public Transaction(Long playerId, String win, double winAmount) {
    }

    public Integer getTxn() {
        return txn;
    }

    public void setTxn(Integer txn) {
        this.txn = txn;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "txn=" + txn +
                ", value=" + value +
                '}';
    }
}
