package com.example.androi3.mvp;

public class CounterPresenter implements CounterContracts.Presenter {
    private final CounterData counterData;
    private CounterContracts.CounterView counterView;

    public CounterPresenter() {
        this.counterData = new CounterData();
    }

    @Override
    public void increaseCounter() {
        counterData.increase();
        counterView.updateCounter(counterData.getValue());
    }

    @Override
    public void attachView(CounterContracts.CounterView view) {
        counterView = view;
    }

    @Override
    public void detachView() {
        counterView = null;
    }

    @Override
    public void decrement() {
        counterData.decrement();
        counterView.updateCounter(counterData.getValue());
    }

    @Override
    public void congratulation() {
        if (counterData.getValue() == 10) {
            counterView.tenCount();
        }
    }

    @Override
    public void changeColor() {
        if (counterData.getValue() == 20) {
            counterView.greenText();
        }
    }
}
