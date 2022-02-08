package com.example.androi3.mvp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.View;

import com.example.androi3.base.BaseFragment;
import com.example.androi3.databinding.FragmentCounterBinding;

public class CounterFragment extends BaseFragment<FragmentCounterBinding> implements CounterContracts.CounterView {

    CounterContracts.Presenter presenter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = Injector.counterPresenter();
        presenter.attachView(this);
        initListeners();
    }

    private void initListeners() {
        binding.incrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.increaseCounter();
            }
        });
        binding.decrementBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.decrement();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    protected FragmentCounterBinding bind() {
        return FragmentCounterBinding.inflate(getLayoutInflater());
    }

    @Override
    public void updateCounter(int count) {
        binding.counterTv.setText(String.valueOf(count));
    }
}