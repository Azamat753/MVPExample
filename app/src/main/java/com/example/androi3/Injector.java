package com.example.androi3;

public class Injector {
    public static CounterContracts.Presenter counterPresenter() {
        return new CounterPresenter();
    }
}
