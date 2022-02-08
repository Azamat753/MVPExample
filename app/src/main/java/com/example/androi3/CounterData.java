package com.example.androi3;

public class CounterData {
    private int value = 0;

    public void increase() {
        this.value++;
    }

    public int getValue() {
        return value;
    }

    public void decrement() {
        this.value--;
    }
}
