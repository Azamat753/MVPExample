package com.example.androi3.mvp;

public class Injector {
    public static CounterContracts.Presenter counterPresenter() {
        return new CounterPresenter();
    }
}
