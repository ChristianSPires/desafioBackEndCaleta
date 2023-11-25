package com.challenge.caleta.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Integer txn;

    private double value;

    public Transaction() {
    }

    public Transaction(Integer txn, double value) {
        this.txn = txn;
        this.value = value;
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

    @Override
    public String toString() {
        return "Transaction{" +
                "txn=" + txn +
                ", value=" + value +
                '}';
    }
}
