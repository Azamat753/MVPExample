package com.example.androi3.mvp;

public class CounterContracts {
    interface CounterView {
        void updateCounter(int count);
        void tenCount();
        void greenText();
    }
    interface Presenter{
        void increaseCounter();
        void attachView(CounterView view);
        void detachView();
        void decrement();
        void congratulation();
        void changeColor();
    }
}
