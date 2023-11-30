package com.challenge.caleta.dto;

public class WinRequest {
    private Long player;
    private double value;

    public WinRequest() {
    }

    public WinRequest(Long player, double value) {
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
