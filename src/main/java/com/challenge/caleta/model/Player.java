package com.challenge.caleta.model;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    private double balance;

    public Player() {

    }

    public Player(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", balance=" + balance +
                '}';
    }
}
