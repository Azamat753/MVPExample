package com.example.androi3;

public class CounterContracts {
    interface CounterView {
        void updateCounter(int count);
    }
    interface Presenter{
        void increaseCounter();
        void attachView(CounterView view);
        void detachView();
        void decrement();
    }
}
