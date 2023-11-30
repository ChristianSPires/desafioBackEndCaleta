package com.challenge.caleta.dto;

public class BetRequest {
    private Long player;
    private double value;

    public BetRequest() {
    }

    public BetRequest(Long player, double value) {
        this.player = player;
        this.value = value;
    }

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}